package com;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport {
	private String lid, lpass;

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLpass() {
		return lpass;
	}

	public void setLpass(String lpass) {
		this.lpass = lpass;
	}

	@Override
	public String toString() {

		return lid + "\t" + lpass;
	}
@Override
public void validate() {
if(lid.trim().length()==0)
	addFieldError("lid", "Login Id can not be left blank");
if(lpass.trim().length()==0)
	addFieldError("lpass", "Password can not be left blank");
}


	@Override
	public String execute() throws Exception {
		System.out.println(this);
		Thread.sleep(4000);
		return "success";
	}
}
