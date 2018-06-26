package com;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;
 
public class Connection {
 
    static final String USERNAME     = "babavaliahmadi@gmail.com";
    static final String PASSWORD     = "Resmed12345Ns7tlkKARhAgeuTy8LmbRb1r";
    static final String LOGINURL     = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "3MVG9mclR62wycM0RXtUr99TxtB3x4Q9zQf66ge7HV.x_RkKmjG4X2AcKIm3XzfaH4FN0uulmkourUE.EP5t7";
    static final String CLIENTSECRET = "3617916833270429689";
 
    public static void Main(String[] args) {
 
        HttpClient httpclient = HttpClientBuilder.create().build();
 
        // Assemble the login request URL
        String loginURL = LOGINURL +
                          GRANTSERVICE +
                          "&amp;client_id=" + CLIENTID +
                          "&amp;client_secret=" + CLIENTSECRET +
                          "&amp;username=" + USERNAME +
                          "&amp;password=" + PASSWORD;
        System.out.println("****loginURL-->"+loginURL);
        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;
 
        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
 
        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to Force.com: "+statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            return;
        }
 
        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;
        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        System.out.println(response.getStatusLine());
        System.out.println("Successful login");
        System.out.println("  instance URL: "+loginInstanceUrl);
        System.out.println("  access token/session ID: "+loginAccessToken);
 
        // release connection
        httpPost.releaseConnection();
    }
}