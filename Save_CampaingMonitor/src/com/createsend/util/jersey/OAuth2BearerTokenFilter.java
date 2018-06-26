
package com.createsend.util.jersey;

import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import javax.ws.rs.core.HttpHeaders;

public final class OAuth2BearerTokenFilter extends ClientFilter {

    private final String authentication;

    public OAuth2BearerTokenFilter(final String accessToken) {
        authentication = "Bearer " + accessToken;
    }

    @Override
    public ClientResponse handle(final ClientRequest cr) throws ClientHandlerException {

        if (!cr.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            cr.getHeaders().add(HttpHeaders.AUTHORIZATION, authentication);
        }
        return getNext().handle(cr);
    }
}