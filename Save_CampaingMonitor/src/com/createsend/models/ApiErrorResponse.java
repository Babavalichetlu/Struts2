
package com.createsend.models;

public class ApiErrorResponse<T> {
	// For deserialisation of API errors
    public int Code;
    public String Message;
    public T ResultData;

    // For deserialisation of OAuth errors
    public String error;
    public String error_description;
}
