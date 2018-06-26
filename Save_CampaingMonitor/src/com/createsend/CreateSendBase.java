package com.createsend;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import com.createsend.models.OAuthTokenDetails;
import com.createsend.util.AuthenticationDetails;
import com.createsend.util.Configuration;
import com.createsend.util.JerseyClient;
import com.createsend.util.JerseyClientImpl;
import com.createsend.util.OAuthAuthenticationDetails;
import com.createsend.util.exceptions.CreateSendException;

public abstract class CreateSendBase {
	protected static final String urlEncodingScheme = "UTF-8";

	protected JerseyClient jerseyClient = null;

	/**
	 * Refresh the current OAuth token using the current refresh token.
	 * 
	 * @return New OAuthTokenDetails instance containing the new access token,
	 *         'expires in' value, and refresh token.
	 */
	public OAuthTokenDetails refreshToken() throws CreateSendException {
		OAuthTokenDetails result = null;
		AuthenticationDetails auth = this.jerseyClient
				.getAuthenticationDetails();
		if (auth != null && auth instanceof OAuthAuthenticationDetails) {
			OAuthAuthenticationDetails oauthDetails = (OAuthAuthenticationDetails) auth;
			String body = "grant_type=refresh_token";
			try {
				body += "&refresh_token="
						+ URLEncoder.encode(oauthDetails.getRefreshToken(),
								urlEncodingScheme);
			} catch (UnsupportedEncodingException e) {
				body = null;
			}
			JerseyClient oauthClient = new JerseyClientImpl(null);
			
	    	// TODO: Use a custom error deserialiser in the following post

			result = oauthClient.post(Configuration.Current.getOAuthBaseUri(),
					OAuthTokenDetails.class, body,
					MediaType.APPLICATION_FORM_URLENCODED_TYPE, "token");
			if (result != null && result.access_token != null
					&& result.refresh_token != null) {
				AuthenticationDetails newAuthDetails = new OAuthAuthenticationDetails(
						result.access_token, result.refresh_token);
				this.jerseyClient.setAuthenticationDetails(newAuthDetails);
			}
		}
		return result;
	}
}
