package com.main;

import com.createsend.Subscribers;
import com.createsend.models.subscribers.CustomField;
import com.createsend.models.subscribers.SubscriberToAdd;
import com.createsend.util.ApiKeyAuthenticationDetails;
import com.createsend.util.exceptions.BadRequestException;
import com.createsend.util.exceptions.CreateSendException;


public class Runner {
	
	private static ApiKeyAuthenticationDetails auth = new ApiKeyAuthenticationDetails("97e25f5bb17c72635c8e769a927e073d91ff107d36a6d9a9");
	
	
    public static void main(String[] args) {        
        try {
        	 String clientID = "createsend.clientID";                       
            runSubscriberMethods(clientID);
           // runUnSubscriberMethods(clientID);
            //runSubscriberUpdateMethods(clientID);
        } catch (BadRequestException e) {
            e.printStackTrace();
            
            if(e.getResultData() != null) {
                System.err.printf("Exception result data: %s\n", e.getResultData());
            }
        } catch (CreateSendException e) {
            e.printStackTrace();
        }
       
    }
    
    @SuppressWarnings("deprecation")
    private static void runSubscriberMethods(String clientID) throws CreateSendException { 
    	System.out.println("*****runSubscriberMethods*****");    	
    	String listID = "7c7a6087b0e450ad72b38be83098e271";    	
    	Subscribers subscriberAPI = new Subscribers(auth,listID); 
        SubscriberToAdd subscriber = new SubscriberToAdd();
        subscriber.Resubscribe = true;
        subscriber.EmailAddress = "hello@hello.com";
        subscriber.Name = "hello123";
        subscriber.CustomFields = new CustomField[] {
            new CustomField()
        };
        subscriber.CustomFields[0].Key = "country";        
        subscriber.CustomFields[0].Value = "India";
        
        System.out.printf("Result of subscriber add: %s\n", subscriberAPI.add(subscriber));
       
    }
    //Unsubscribe method
  /*  @SuppressWarnings("deprecation")
    private static void runUnSubscriberMethods(String clientID) throws CreateSendException {
    	String listID = "7c7a6087b0e450ad72b38be83098e271";
        Subscribers subscriberAPI = new Subscribers(auth,listID);
        SubscriberToAdd subscriber = new SubscriberToAdd();       
        subscriber.EmailAddress = "sundari.gunaseelan@haha.com";// mandatory field        
        subscriber.Name = "yoyo";
        subscriber.CustomFields = new CustomField[] {
                new CustomField()
            };
            subscriber.CustomFields[0].Key = "country";        
            subscriber.CustomFields[0].Value = "USA";        
        System.out.printf("Result of subscriber details: %s\n", subscriberAPI.details(subscriber.EmailAddress));
        System.out.printf("Result of subscriber history: %s\n", 
            Arrays.deepToString(subscriberAPI.history(subscriber.EmailAddress)));
        subscriberAPI.unsubscribe(subscriber.EmailAddress);   
        SubscribersToAdd subscribers = new SubscribersToAdd();
        subscribers.Resubscribe = true;
        subscribers.Subscribers = new Subscriber[] {
            new Subscriber(), new Subscriber(), new Subscriber()
        };        
    
    }*/
  //SubscribeUpdate method
 /*   @SuppressWarnings("deprecation")
    private static void runSubscriberUpdateMethods(String clientID) throws CreateSendException { 
    	System.out.println("*****runUnSubscriberMethods*****");
    	String listID = "7c7a6087b0e450ad72b38be83098e271";      
    	Subscribers subscriberAPI = new Subscribers(auth,listID);               
        SubscriberToAdd subscriber = new SubscriberToAdd();      
        String originalEmail = "Crispi@cris.com";
        subscriber.EmailAddress = "sundari.gunaseelan@haha.com ";    
        subscriber.Name = "yoyo";
        subscriber.CustomFields = new CustomField[] {
                new CustomField()
            };
            subscriber.CustomFields[0].Key = "country";        
            subscriber.CustomFields[0].Value = "USA";
           subscriberAPI.update(originalEmail,subscriber);
        
            
   
    }*/
}

