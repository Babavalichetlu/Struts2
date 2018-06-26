
package com.createsend.util.exceptions;

public class BadRequestException extends CreateSendHttpException {    
    private static final long serialVersionUID = -2724621705342365927L;

    private Object resultData;

    public BadRequestException(int apiErrorCode, String apiErrorMessage, Object resultData) { 
        super(
            String.format("The CreateSend API responded with the following client error %d: %s.%s",
                apiErrorCode, apiErrorMessage,
                resultData != null ? " Check resultData for more details" : ""), 
            400,
            apiErrorCode,
            apiErrorMessage);

        this.resultData = resultData;
    }
    
    public Object getResultData() {
        return resultData;
    }
}
