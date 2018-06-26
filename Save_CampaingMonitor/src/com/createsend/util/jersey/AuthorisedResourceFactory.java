
package com.createsend.util.jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class AuthorisedResourceFactory extends ResourceFactory {  
    private HTTPBasicAuthFilter apiKeyFilter;
    private OAuth2BearerTokenFilter oauthTokenFilter;

    public AuthorisedResourceFactory(String accessToken) {
        oauthTokenFilter = new OAuth2BearerTokenFilter(accessToken);
    }

    public AuthorisedResourceFactory(String username, String password) {
        apiKeyFilter = new HTTPBasicAuthFilter(username, password);
    }

    @Override
    public WebResource getResource(Client client, String... pathElements) {
        WebResource resource = super.getResource(client, pathElements);
        if (apiKeyFilter != null)
	        resource.addFilter(apiKeyFilter);
        if (oauthTokenFilter != null)
        	resource.addFilter(oauthTokenFilter);
        return resource;
    }
}