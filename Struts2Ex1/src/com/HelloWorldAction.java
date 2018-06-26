package com;

public class HelloWorldAction {	
	   private String name;

	   public String execute() throws Exception {
		   System.out.println("***** In execute method---");
	      return "success";
	   }
	   
	   public String getName() {
		   System.out.println("***** In execute method getname()---");
	      return name;
	   }

	   public void setName(String name) {
		   System.out.println("***** In execute method set name---");
	      this.name = name;
	   }
	}