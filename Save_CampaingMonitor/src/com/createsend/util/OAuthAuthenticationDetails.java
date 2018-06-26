
package com.createsend.util;

public class OAuthAuthenticationDetails extends AuthenticationDetails {
	private String accessToken;
	private String refreshToken;
	
	public OAuthAuthenticationDetails(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}
}
