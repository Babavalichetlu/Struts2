package com.createsend.models.subscribers;

public class CustomField {
    public String Key;
    public String Value;
    public Boolean Clear;
    
    @Override
    public String toString() {
        return String.format("{ Key: %s, Value: %s, Clear: %s }", Key, Value, Clear);
    }
}
