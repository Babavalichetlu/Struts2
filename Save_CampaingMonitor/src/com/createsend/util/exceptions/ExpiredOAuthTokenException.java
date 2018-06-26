package com.createsend.util.exceptions;

public class ExpiredOAuthTokenException extends UnauthorisedException {
    private static final long serialVersionUID = 6082738273827262638L;

    public ExpiredOAuthTokenException(int apiErrorCode, String apiErrorMessage) {
    	super(apiErrorCode, apiErrorMessage);
    }
}
