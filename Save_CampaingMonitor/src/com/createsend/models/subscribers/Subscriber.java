package com.createsend.models.subscribers;

import java.util.Date;

public class Subscriber {
    public String ListID;
    public String EmailAddress;
    public String Name;
    public Date Date;
    public String State; // TODO: Probably want to move this to an enum
    public CustomField[] CustomFields;
    public String ReadsEmailWith;
    
    @Override
    public String toString() {
        return String.format("{ ListID: %s, EmailAddress: %s, Name: %s, Date: %s, State: %s }",
            ListID, EmailAddress, Name, Date, State);
    }
}
