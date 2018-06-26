package com.createsend;

import javax.ws.rs.core.MultivaluedMap;
import com.createsend.models.subscribers.EmailToUnsubscribe;
import com.createsend.models.subscribers.HistoryItem;
import com.createsend.models.subscribers.ImportResult;
import com.createsend.models.subscribers.Subscriber;
import com.createsend.models.subscribers.SubscriberToAdd;
import com.createsend.models.subscribers.SubscribersToAdd;
import com.createsend.util.AuthenticationDetails;
import com.createsend.util.ErrorDeserialiser;
import com.createsend.util.JerseyClientImpl;
import com.createsend.util.exceptions.CreateSendException;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class Subscribers extends CreateSendBase {
    private String listID;
    public Subscribers(AuthenticationDetails auth, String listID) {
        setListID(listID);
        this.jerseyClient = new JerseyClientImpl(auth);
    }
    
   
    public void setListID(String listID) {
        this.listID = listID;
    }
    
   
    public String getListID() {
        return listID;
    }
    
   //Adding(single) the info to campaing monitor
    public String add(SubscriberToAdd subscriber) throws CreateSendException {
        return jerseyClient.post(String.class, subscriber, "subscribers", listID + ".json");
    }
    
  //Adding(Multipule) the info to campaing monitor
/*    public ImportResult addMany(SubscribersToAdd subscribers) throws CreateSendException {
        return jerseyClient.post(ImportResult.class, subscribers, 
            new ErrorDeserialiser<ImportResult>(), "subscribers", listID, "import.json");
    }*/
    
  //details the info from campaing monitor
 /*   public Subscriber details(String emailAddress) throws CreateSendException {
        MultivaluedMap<String, String> queryString = new MultivaluedMapImpl();
        queryString.add("email", emailAddress);
        
        return jerseyClient.get(Subscriber.class, queryString, "subscribers", listID + ".json");
    }*/
    
 // collecting the History from CM
 /*   public HistoryItem[] history(String emailAddress) throws CreateSendException {
        MultivaluedMap<String, String> queryString = new MultivaluedMapImpl();
        queryString.add("email", emailAddress);
        
        return jerseyClient.get(HistoryItem[].class, queryString, "subscribers", listID, "history.json");
    }*/
    
  // unsubscribe email 
  /*  public void unsubscribe(String emailAddress) throws CreateSendException {
        jerseyClient.post(String.class, EmailToUnsubscribe.fromString(emailAddress), 
            "subscribers", listID, "unsubscribe.json");
    }
    */
  // Deleting the emails
  /*  public void delete(String emailAddress) throws CreateSendException {
    	MultivaluedMap<String, String> queryString = new MultivaluedMapImpl();
        queryString.add("email", emailAddress);
        
        jerseyClient.delete(queryString, "subscribers", listID + ".json");
    }
    */
// Update the existing values from CM
  /*  public void update(String originalEmailAddress, SubscriberToAdd newDetails) throws CreateSendException {
        MultivaluedMap<String, String> queryString = new MultivaluedMapImpl();
        queryString.add("email", originalEmailAddress);
        
        jerseyClient.put(newDetails, queryString, "subscribers", listID + ".json");
    }*/
}
