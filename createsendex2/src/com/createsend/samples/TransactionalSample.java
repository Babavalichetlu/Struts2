/**
 * Copyright (c) 2015 Richard Bremner
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.createsend.samples;

import com.createsend.ClassicEmail;
import com.createsend.Messages;
import com.createsend.SmartEmail;
import com.createsend.models.transactional.EmailContent;
import com.createsend.models.transactional.request.Attachment;
import com.createsend.models.transactional.request.ClassicEmailRequest;
import com.createsend.models.transactional.request.SmartEmailRequest;
import com.createsend.models.transactional.response.*;
import com.createsend.util.ApiKeyAuthenticationDetails;
import com.createsend.util.OAuthAuthenticationDetails;
import com.createsend.util.exceptions.CreateSendException;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

/**
 * Simple examples of how to use the Transactional API.
 */
public class TransactionalSample {

    //private static final OAuthAuthenticationDetails auth = new OAuthAuthenticationDetails("your access token", "your refresh token");
	private static ApiKeyAuthenticationDetails auth = new ApiKeyAuthenticationDetails("97e25f5bb17c72635c8e769a927e073d91ff107d36a6d9a9");

    //private static final UUID smartEmailID = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
   // private static final UUID messageID = UUID.fromString("123456");
    private static final String toAddress = "Babavali.Chetlu@lntinfotech.com";
    private static final String fromAddress = "Gajalakshmi.PM@lntinfotech.com";
    private static final String replyToAddress = "you@example.com";
    private static final String subject = "TestMail";
    private static final String group = "java wrapper emails";
    private static final String clientID = "3e197011dedd7b0bf10c582dae7b126c"; // Can be null

    public static void main(String args[]) throws CreateSendException, IOException {
        //listSmartEmails();
       // sendSmartEmail();

       // listGroups();
        sendClassicEmail();

        //resendMessage();
       // getMessage();

     //   showStatistics();

        timeline();
    }

    public static void timeline() throws CreateSendException {
        System.out.println("---- Timeline ----");

        Messages messages = new Messages(auth);

        MessageLogItem[] timeline = messages.timeline(clientID, null, null, 50, null, null, null);

        for (MessageLogItem item : timeline) {
            System.out.println("*** Items are-->"+item);
        }
    }

    /*private static void showStatistics() throws CreateSendException {
        System.out.println("---- Show Statistics ----");

        Messages messages = new Messages(auth);

        TransactionalStatistics stats = messages.statistics(clientID, smartEmailID, null, null, null, null);

        System.out.println(stats);
    }*/

  /*  private static void getMessage() throws CreateSendException {
        System.out.println("---- Get Message ----");

        Messages messages = new Messages(auth);

        Message message = messages.get(messageID);

        System.out.println(message);
    }*/

    private static void sendClassicEmail() throws CreateSendException, IOException {
        System.out.println("---- Send Classic Email ----");

        ClassicEmail classicEmail = new ClassicEmail(auth);
        System.out.println("****111classicEmail--"+classicEmail);
        System.out.println("****222toAddress--"+toAddress);

        ClassicEmailRequest classicEmailRequest = new ClassicEmailRequest(toAddress);
        System.out.println("****333classicEmailRequest-->"+classicEmailRequest);
        classicEmailRequest.setFrom(fromAddress);
        classicEmailRequest.setReplyTo(replyToAddress);
        classicEmailRequest.setSubject(subject);

        EmailContent content = new EmailContent();
        content.setHtml("<html><body><h1>HTML content</h1>html sent via the wrapper</body></html>");
        content.setText("plain text sent via the wrapper");
        content.setTrackOpens(true);
        content.setTrackClicks(true);
        classicEmailRequest.setContent(content);

        //optional, but more powerful reporting is available if you specify a group
       // classicEmailRequest.setGroup(group);

        Attachment attachment = getAttachment();
        System.out.println("****444attachment-->"+attachment);
        classicEmailRequest.addAttachment(attachment);
        System.out.println("****555classicEmailRequest-->"+classicEmailRequest);

        classicEmail.send(classicEmailRequest);
    }

    private static void listGroups() throws CreateSendException {
        System.out.println("---- List Groups ----");

        ClassicEmail classicEmail = new ClassicEmail(auth);

        ClassicEmailGroup[] groups = classicEmail.list(clientID);

        for (ClassicEmailGroup group : groups) {
            System.out.printf("Classic Email: %s\n", group);
        }
    }

    private static void listSmartEmails() throws CreateSendException {
        System.out.println("---- List Smart Emails ----");

        SmartEmail smartEmail = new SmartEmail(auth);
        SmartEmailItem[] smartEmails = smartEmail.list(clientID);
        System.out.println("****smartEmails--->"+smartEmails.toString());

        boolean hasGotFirst = false;
        for (SmartEmailItem status : smartEmails) {
        	System.out.println("--in side for loop--");
            System.out.printf("Smart Email: %s\n", status);
            if (!hasGotFirst) {
                getSmartEmailDetails(status.getId());
                hasGotFirst = true;
            }
        }
        System.out.println("--outside for loop--");
    }

    private static void getSmartEmailDetails(UUID smartEmailId) throws CreateSendException {
        System.out.println("---- Get Smart Email Details ----");

        SmartEmail smartEmail = new SmartEmail(auth);
        SmartEmailDetails smartEmailDetails = smartEmail.get(smartEmailId);

        System.out.println(smartEmailDetails);
    }

  /* private static void sendSmartEmail() throws CreateSendException, IOException {
        System.out.println("---- Send Smart Email ----");

        SmartEmail smartEmail = new SmartEmail(auth);
        System.out.println("----smartEmailID----"+smartEmailID);
        System.out.println("----toAddress----"+toAddress);
        SmartEmailRequest smartEmailRequest = new SmartEmailRequest(smartEmailID, toAddress);
        System.out.println("----smartEmailRequest----"+smartEmailRequest);
        smartEmailRequest.addData("myvariable", "supplied via the wrapper sample runner");

        Attachment attachment = getAttachment();
        smartEmailRequest.addAttachment(attachment);

        smartEmail.send(smartEmailRequest);
    }*/
/*
    private static void resendMessage() throws CreateSendException {
        System.out.println("---- Resend Message ----");

        Messages messages = new Messages(auth);
        messages.resend(messageID);
    }*/

    private static Attachment getAttachment() throws IOException {
        //attach an image to the outgoing email
        URL attachmentUrl = new URL("http://imgs.xkcd.com/comics/email.png");

        Attachment attachment = new Attachment();
        attachment.Name = "email.png";
        attachment.Type = "image/png";
        attachment.base64EncodeContentStream(attachmentUrl.openStream());

        return attachment;
    }
}