
package com;
public class HelloWorld {

    private String message;

    private String userName;
    
    public HelloWorld() {
    }

    public String execute() {
        setMessage("Hello " + getUserName());
        return "SUCCESS";
    }

    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}