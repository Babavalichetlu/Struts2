package com;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class MyValidator extends FieldValidatorSupport {
	private String domainName;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public void validate(Object object) throws ValidationException {
		System.out.println("^^^^^^ validate^^^^^^^");
		String fieldName = getFieldName();
		Object value = this.getFieldValue(fieldName, object);
		String s = (String) value;
		System.out.println("custom validator invoked for value : "+s);
		if (!s.endsWith(domainName)) {
			addFieldError(fieldName, object);
		}
	}
}
