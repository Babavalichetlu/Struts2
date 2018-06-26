package com.createsend.samples;
import java.util.Arrays;
import java.util.Date;

import com.createsend.Clients;
import com.createsend.General;
import com.createsend.Lists;
import com.createsend.Subscribers;
import com.createsend.models.campaigns.SentCampaign;
import com.createsend.models.clients.ClientBasics;
import com.createsend.models.lists.CustomFieldForCreate;
import com.createsend.models.lists.List;
import com.createsend.models.subscribers.CustomField;
import com.createsend.models.subscribers.Subscriber;
import com.createsend.models.subscribers.SubscriberToAdd;
import com.createsend.models.subscribers.SubscribersToAdd;
import com.createsend.util.ApiKeyAuthenticationDetails;
import com.createsend.util.exceptions.CreateSendException;

public class Tester {
    public static void main(String[] args) throws CreateSendException {
        ApiKeyAuthenticationDetails auth = new ApiKeyAuthenticationDetails("97e25f5bb17c72635c8e769a927e073d91ff107d36a6d9a9");
        General general = new General(auth);
        System.out.println("**general--"+general.getClients().toString());
        ClientBasics[] clients = general.getClients();
        System.out.println("**clients--"+clients);
        for (ClientBasics cl : clients) {
            System.out.printf("here Client: %s\n", cl.Name);
            Clients cls = new Clients(auth, cl.ClientID);
            System.out.printf("- Campaigns:\n");
           /* for (SentCampaign cm : cls.sentCampaigns()) {
            	System.out.println("IN loop");
                System.out.printf(" in for loop - %s\n", cm.Subject);
            }*/
        }
            Lists listAPI = new Lists(auth);
          /*  Date subscribersFrom = new Date();
            subscribersFrom.setHours(0);
            */
           // List list = new List();
           // list.Title = "Java API Test List";
            //list.ConfirmedOptIn = false;
            String clientID = "7c7a6087b0e450ad72b38be83098e271";
            System.out.println("****create before line");
			listAPI.create(clientID, list);        
			 System.out.println("****clientID-->"+clientID);
			 System.out.println("****list-->"+list);
            CustomFieldForCreate customField = new CustomFieldForCreate();
            customField.DataType = "Text";
            customField.FieldName = "Website";
            
            String key = listAPI.createCustomField(customField);
            System.out.println("**listAPI.getListID()--"+listAPI.getListID());
            Subscribers subscriberAPI = new Subscribers(auth, listAPI.getListID());
            
            SubscriberToAdd subscriber = new SubscriberToAdd();
            subscriber.Resubscribe = true;
            subscriber.EmailAddress = "Myemail@bab.com";
            subscriber.Name = "MyName";
           /* subscriber.CustomFields = new CustomField[] {
                new CustomField()
            };
            subscriber.CustomFields[0].Key = key;
            subscriber.CustomFields[0].Value = "http://www.example.com";*/
            
            System.out.printf("Result of subscriber add: %s\n", subscriberAPI.add(subscriber));
            
            /*String originalEmail = subscriber.EmailAddress;
            subscriber.EmailAddress = "New Subscriber Email Address";
            subscriber.CustomFields = null; // We don't want to update any custom fields
            subscriber.Name = "New Subscriber Name";
            subscriberAPI.update(originalEmail, subscriber);  
            
            System.out.printf("Result of subscriber details: %s\n", subscriberAPI.details(subscriber.EmailAddress));
            System.out.printf("Result of subscriber history: %s\n", 
                Arrays.deepToString(subscriberAPI.history(subscriber.EmailAddress)));
            subscriberAPI.unsubscribe(subscriber.EmailAddress);      
            
            SubscribersToAdd subscribers = new SubscribersToAdd();
            subscribers.Resubscribe = true;
            subscribers.Subscribers = new Subscriber[] {
                new Subscriber(), new Subscriber(), new Subscriber()
            };
            
            subscribers.Subscribers[0].EmailAddress = "Subscriber Email 1";
            subscribers.Subscribers[0].CustomFields = new CustomField[] { new CustomField() };
            subscribers.Subscribers[0].CustomFields[0].Key = key;
            subscribers.Subscribers[0].CustomFields[0].Clear = true; // remove website from this existing subscriber
            
            subscribers.Subscribers[1].EmailAddress = "Subscriber Email 2";
            
            subscribers.Subscribers[2].EmailAddress = "Subscriber Email 3";
            subscribers.Subscribers[2].CustomFields = new CustomField[] { new CustomField() };
            subscribers.Subscribers[2].CustomFields[0].Key = key;
            subscribers.Subscribers[2].CustomFields[0].Value = "http://www.google.com";
            subscriberAPI.addMany(subscribers);
            
            System.out.printf("Result of list active: %s\n", 
                    listAPI.active(subscribersFrom, null, null, null, null));
            
            subscriberAPI.delete("Subscriber Email 1");
            
            listAPI.delete();*/
        
    }
}