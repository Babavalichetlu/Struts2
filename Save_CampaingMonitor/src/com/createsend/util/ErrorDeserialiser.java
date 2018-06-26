package com.createsend.util;

import com.createsend.models.ApiErrorResponse;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ErrorDeserialiser<T> {

    public ApiErrorResponse<T> getResponse(ClientResponse response) {
        ParameterizedType returnType = JerseyClientImpl.getGenericReturnType(this.<T>getClass(), 2);
        Type genericType = this.getClass().getGenericSuperclass();
        if (genericType instanceof ParameterizedType) {
            try {
                Field f = returnType.getClass().getDeclaredField("actualTypeArguments");
                f.setAccessible(true);
                f.set(returnType, ((ParameterizedType)genericType).getActualTypeArguments());
                f.setAccessible(false);
            } catch (NoSuchFieldException e) {
                // ok to ignore
            } catch (IllegalAccessException e) {
                // ok to ignore
            }
        }
        return response.getEntity(new GenericType<ApiErrorResponse<T>>(returnType));
    }
}
