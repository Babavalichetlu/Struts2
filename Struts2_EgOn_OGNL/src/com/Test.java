package com;

import java.util.ArrayList;
import java.util.List; 

public class Test {
/*	//data members
	private List<String> myList = new ArrayList<String>();
 
	//business logic
	public String execute(){
		myList.add("Bharat");
		myList.add("Richi");
		myList.add("Sahdev");
		myList.add("Rajesh");
		myList.add("Himanshu");
		myList.add("Vivek");
		myList.add("Shveta");
		myList.add("Bharti");
		return "success";	
	}
	public List<String> getMyList() {
		return myList;
	}
 
	public void setMyList(List<String> myList) {
		this.myList = myList;
	}
 */
	private  String[] sampleArray;
    {
    	sampleArray =  new String[]{"item1","item2","item3"};
    }
    public String execute()
    {
    	return "success";
    }
    public String[] getSampleArray() {
    	return sampleArray;
    }
    public void setSampleArray(String[] sampleArray) {
    	this.sampleArray = sampleArray;
    }
    
    
			
}