package com.createsend.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.createsend.models.ApiErrorResponse;
import com.createsend.models.PagedResult;
import com.createsend.util.exceptions.BadRequestException;
import com.createsend.util.exceptions.CreateSendException;
import com.createsend.util.exceptions.CreateSendHttpException;
import com.createsend.util.exceptions.ExpiredOAuthTokenException;
import com.createsend.util.exceptions.NotFoundException;
import com.createsend.util.exceptions.ServerErrorException;
import com.createsend.util.exceptions.UnauthorisedException;
import com.createsend.util.jersey.AuthorisedResourceFactory;
import com.createsend.util.jersey.JsonProvider;
import com.createsend.util.jersey.ResourceFactory;
import com.createsend.util.jersey.UnauthorisedResourceFactory;
import com.createsend.util.jersey.UserAgentFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class JerseyClientImpl implements JerseyClient {

    private static Client client;
    static {
        ClientConfig cc = new DefaultClientConfig(); 
        cc.getClasses().add(JsonProvider.class); 
        
        Map<String, Object> properties = cc.getProperties();
        properties.put(ClientConfig.PROPERTY_CHUNKED_ENCODING_SIZE, 64 * 1024);
        properties.put(com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING, "true");

        client = Client.create(cc);
        client.setFollowRedirects(false);

        if (Configuration.Current.isLoggingEnabled()) {
            client.addFilter(new LoggingFilter(System.out));
        }

        client.addFilter(new GZIPContentEncodingFilter(false));
        client.addFilter(new UserAgentFilter());
    }

    private ErrorDeserialiser<String> defaultDeserialiser = new ErrorDeserialiser<String>(){};
    private ResourceFactory authorisedResourceFactory;
    private AuthenticationDetails authDetails;

    public JerseyClientImpl(AuthenticationDetails auth) {
    	this.setAuthenticationDetails(auth);
    }
    
    public AuthenticationDetails getAuthenticationDetails() {
    	return this.authDetails;
    }

	public void setAuthenticationDetails(AuthenticationDetails authDetails) {
		this.authDetails = authDetails;
    	if (authDetails instanceof OAuthAuthenticationDetails) {
			OAuthAuthenticationDetails oauthDetails = (OAuthAuthenticationDetails)authDetails;
			authorisedResourceFactory = new AuthorisedResourceFactory(oauthDetails.getAccessToken());
    	} else if (authDetails instanceof ApiKeyAuthenticationDetails) {
			ApiKeyAuthenticationDetails apiKeyDetails = (ApiKeyAuthenticationDetails)authDetails;
			authorisedResourceFactory = new AuthorisedResourceFactory(apiKeyDetails.getApiKey(), "x");
    	} else {
    		authorisedResourceFactory = new UnauthorisedResourceFactory();
    	}
	}

 
    public <T> T get(Class<T> klass, String... pathElements) throws CreateSendException {
        return get(klass, null, authorisedResourceFactory, pathElements);
    }
        
    public <T> T get(Class<T> klass, ErrorDeserialiser<?> errorDeserialiser, 
            String... pathElements) throws CreateSendException {
        return get(klass, null, authorisedResourceFactory, errorDeserialiser, pathElements);
    }
   
    public <T> T get(Class<T> klass, MultivaluedMap<String, String> queryString,
        String... pathElements) throws CreateSendException {
        return get(klass, queryString, authorisedResourceFactory, pathElements);
    }
        
    public <T> T get(Class<T> klass, MultivaluedMap<String, String> queryString,
        ResourceFactory resourceFactory, String... pathElements) throws CreateSendException {
        return get(klass, queryString, resourceFactory, defaultDeserialiser, pathElements);
    }
        
    public <T> T get(Class<T> klass, MultivaluedMap<String, String> queryString,
        ResourceFactory resourceFactory, ErrorDeserialiser<?> errorDeserialiser, 
        String... pathElements) throws CreateSendException {
        WebResource resource = resourceFactory.getResource(client, pathElements);
        
        if(queryString != null) {
            resource = resource.queryParams(queryString);
        }
        
        try {
            return fixStringResult(klass, resource.get(klass));
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, errorDeserialiser);
        }   
    }

    public <T> PagedResult<T> getPagedResult(Integer page, Integer pageSize, String orderField, 
        String orderDirection, MultivaluedMap<String, String> queryString, String... pathElements) 
        throws CreateSendException {
        WebResource resource = authorisedResourceFactory.getResource(client, pathElements);
        if(queryString == null) queryString = new MultivaluedMapImpl();
        
        addPagingParams(queryString, page, pageSize, orderField, orderDirection);
        
        try {
            if(queryString != null) {
                resource = resource.queryParams(queryString);
            }
            
            return resource.get(new GenericType<PagedResult<T>>(getGenericReturnType()));
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, defaultDeserialiser);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        
        return null;
    }
        
 
    public <T> T post(Class<T> klass, Object entity, String... pathElements) throws CreateSendException {
        return post(null, klass, entity, defaultDeserialiser, MediaType.APPLICATION_JSON_TYPE, pathElements);
    }

    public <T> T post(Class<T> klass, MultivaluedMap<String, String> queryString, Object entity, String... pathElements) throws CreateSendException {
        return post(null, klass, queryString, entity, defaultDeserialiser, MediaType.APPLICATION_JSON_TYPE, pathElements);
    }

    public <T> T post(Class<T> klass, Object entity, 
            ErrorDeserialiser<?> errorDeserialiser, String... pathElements) throws CreateSendException {
    	return post(null, klass, entity, errorDeserialiser, MediaType.APPLICATION_JSON_TYPE, pathElements);
    }

    public <T> T post(String baseUri, Class<T> klass, Object entity, String... pathElements) throws CreateSendException {
        return post(baseUri, klass, entity, defaultDeserialiser, MediaType.APPLICATION_JSON_TYPE, pathElements);
    }

    public <T> T post(String baseUri, Class<T> klass, Object entity,
            ErrorDeserialiser<?> errorDeserialiser, String... pathElements) throws CreateSendException {
    	return post(baseUri, klass, entity, errorDeserialiser, MediaType.APPLICATION_JSON_TYPE, pathElements);
    }

    public <T> T post(Class<T> klass, Object entity,
            MediaType mediaType, String... pathElements) throws CreateSendException {
    	return post(null, klass, entity, defaultDeserialiser, mediaType, pathElements);
    }

    public <T> T post(String baseUri, Class<T> klass, Object entity,
            MediaType mediaType, String... pathElements) throws CreateSendException {
    	return post(baseUri, klass, entity, defaultDeserialiser, mediaType, pathElements);
    }

    public <T> T post(String baseUri, Class<T> klass, Object entity,
            ErrorDeserialiser<?> errorDeserialiser,
            MediaType mediaType, String... pathElements) throws CreateSendException {
    	return post(baseUri, klass, null, entity, errorDeserialiser, mediaType, pathElements);
    }

    private <T> T post(String baseUri,
                      Class<T> klass,
                      MultivaluedMap<String, String> queryString,
                      Object entity,
                      ErrorDeserialiser<?> errorDeserialiser,
                      MediaType mediaType,
                      String... pathElements) throws CreateSendException {
        WebResource resource;
        if (baseUri != null)
            resource = authorisedResourceFactory.getResource(baseUri, client, pathElements);
        else
            resource = authorisedResourceFactory.getResource(client, pathElements);

        if( queryString != null )
            resource = resource.queryParams(queryString);

        try {
            WebResource.Builder builder = resource.type(mediaType);

            return fixStringResult(klass,
                    entity == null ?
                            builder.post(klass, "") :
                            builder.post(klass, entity)
            );
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, errorDeserialiser);
        }
    }


 
    public void put(Object entity, String... pathElements) throws CreateSendException {
        put(entity, null, defaultDeserialiser, pathElements);
    }
    
    public <T> T put(Class<T> klass, Object entity, String... pathElements) throws CreateSendException {
        WebResource resource = authorisedResourceFactory.getResource(client, pathElements);
        try { 
            return fixStringResult(klass, resource.
                type(MediaType.APPLICATION_JSON_TYPE).
                put(klass, entity));
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, defaultDeserialiser);
        }
    }
    
    public void put(Object entity, MultivaluedMap<String, String> queryString, String... pathElements) throws CreateSendException {
        put(entity, queryString, defaultDeserialiser, pathElements);
    }
    
    public void put(Object entity, ErrorDeserialiser<?> errorDeserialiser,
            String... pathElements) throws CreateSendException {
        put(entity, null, errorDeserialiser, pathElements);
    }

    private void put(Object entity, MultivaluedMap<String, String> queryString, ErrorDeserialiser<?> errorDeserialiser,
        String... pathElements) throws CreateSendException {
        WebResource resource = authorisedResourceFactory.getResource(client, pathElements);
        
        if(queryString != null) {
            resource = resource.queryParams(queryString);
        }
        
        try { 
            resource.
                type(MediaType.APPLICATION_JSON_TYPE).
                put(entity);
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, errorDeserialiser);
        }
    }


    public void delete(String... pathElements) throws CreateSendException {
        delete(null, pathElements);
    }
 
    @Override
	public void delete(MultivaluedMap<String, String> queryString, String... pathElements) throws CreateSendException {
        WebResource resource = authorisedResourceFactory.getResource(client, pathElements);
        
        if( queryString != null )
        	resource = resource.queryParams(queryString);
        
        try { 
            resource.delete();
        } catch (UniformInterfaceException ue) {
            throw handleErrorResponse(ue, defaultDeserialiser);
        }
    }

    protected void addPagingParams(MultivaluedMap<String, String> queryString,  
        Integer page, Integer pageSize, String orderField, String orderDirection) {        
        if(page != null) {
            queryString.add("page", page.toString());
        }
        
        if(pageSize != null) {
            queryString.add("pagesize", pageSize.toString());
        }
        
        if(orderField != null) {
            queryString.add("orderfield", orderField); 
        }
        
        if(orderDirection != null) {
            queryString.add("orderdirection", orderDirection);
        }
    }
    

    @SuppressWarnings("unchecked")
    protected <T> T fixStringResult(Class<T> klass, T result) {
        if(klass == String.class) { 
            String strResult = (String)result;
            if(strResult.startsWith("\"")) { 
                strResult = strResult.substring(1);
            }
            
            if(strResult.endsWith("\"")) {
                strResult = strResult.substring(0, strResult.length() - 1);
            }
            
            return (T)strResult;
        }
        
        return result;
    }
    

    private <T> CreateSendException handleErrorResponse(UniformInterfaceException ue, 
        ErrorDeserialiser<T> deserialiser) {
        ClientResponse response = ue.getResponse();
        ApiErrorResponse<T> apiResponse = null;
        
        Status responseStatus = response.getClientResponseStatus();
        if(responseStatus == Status.BAD_REQUEST || 
           responseStatus == Status.NOT_FOUND ||
           responseStatus == Status.UNAUTHORIZED ||
           responseStatus == Status.INTERNAL_SERVER_ERROR) {
            try { 
                apiResponse = deserialiser.getResponse(response);
            } catch (Throwable t) { }                
        }

        if (apiResponse == null) {
            return handleUnknownError(responseStatus);
        } else if (apiResponse.error != null && apiResponse.error.length() > 0) {
            return handleOAuthErrorResponse(responseStatus, apiResponse);
        } else {
        	return handleAPIErrorResponse(responseStatus, apiResponse);
        }
    }

    private <T> CreateSendException handleUnknownError(Status responseStatus) {
        return new CreateSendHttpException(responseStatus);
    }
    
    private <T> CreateSendException handleAPIErrorResponse(
    		Status responseStatus, ApiErrorResponse<T> apiResponse) {
        switch(responseStatus) {
	        case BAD_REQUEST:
	            return new BadRequestException(apiResponse.Code, apiResponse.Message, apiResponse.ResultData);
	        case INTERNAL_SERVER_ERROR:
	            return new ServerErrorException(apiResponse.Code, apiResponse.Message);
	        case NOT_FOUND:
	            return new NotFoundException(apiResponse.Code, apiResponse.Message);
	        case UNAUTHORIZED:
	        	if (apiResponse.Code == 121)
	        		return new ExpiredOAuthTokenException(apiResponse.Code, apiResponse.Message);
	            return new UnauthorisedException(apiResponse.Code, apiResponse.Message);
	        default:
	            return new CreateSendHttpException(responseStatus);
	    }
    }

    private <T> CreateSendException handleOAuthErrorResponse(
    		Status responseStatus, ApiErrorResponse<T> apiResponse) {
    	return new CreateSendHttpException(
    			String.format("The CreateSend OAuth receiver responded with the following error - %s: %s",
    					apiResponse.error, apiResponse.error_description),
    			responseStatus.getStatusCode(), 0, apiResponse.error_description);
    }

    private ParameterizedType getGenericReturnType() {
        return getGenericReturnType(null, 4);
    }
    
    public static ParameterizedType getGenericReturnType(Class<?> klass, int stackFrame) {   
        StackTraceElement element = Thread.currentThread().getStackTrace()[stackFrame];
        String callingMethodName = element.getMethodName();
        
        if(klass == null) {
            try { 
                klass = Class.forName(element.getClassName());
            } catch (ClassNotFoundException e) { }
        }
        
        if (klass != null) {
            for (Method method : klass.getMethods()) {
                if (method.getName().equals(callingMethodName)) {
                    return (ParameterizedType) method.getGenericReturnType();
                }
            }
        }
        
        return null;
    }
}
