package com.createsend.util;
public class ApiKeyAuthenticationDetails extends AuthenticationDetails {
	private String apiKey;
	
	public ApiKeyAuthenticationDetails(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiKey() {
		return apiKey;
	}
}
