package com.createsend.util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static Configuration Current = new Configuration();

    private Properties properties;
    private Configuration() {
        properties = new Properties();

        try {
            InputStream configProperties = getClass().getClassLoader().getResourceAsStream("com/createsend/util/config.properties");
           
            if (configProperties == null) {
                throw new FileNotFoundException("Could not find config.properties");
            }
            properties.load(configProperties);
                        
            InputStream createsendProperties = getClass().getClassLoader().getResourceAsStream("createsend.properties");
            if(createsendProperties != null) {
                properties.load(createsendProperties);
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }            
    }

    public void addPropertiesFile(String filename) throws IOException {
        properties.load(ClassLoader.getSystemResourceAsStream(filename));
    }

    public String getApiEndpoint() {
    	// System.out.println("****configProperties-->"+properties.getProperty("createsend.endpoint"));
        return properties.getProperty("createsend.endpoint");
    }

    public String getOAuthBaseUri() {
        return properties.getProperty("createsend.oauthbaseuri");
    }

    public String getWrapperVersion() {
        return properties.getProperty("createsend.version");
    }

    public boolean isLoggingEnabled() {
        return Boolean.parseBoolean(properties.getProperty("createsend.logging"));
    }
   
  
}
