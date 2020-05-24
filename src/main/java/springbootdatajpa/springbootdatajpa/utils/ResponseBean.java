package springbootdatajpa.springbootdatajpa.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("deprecation")
public class ResponseBean {
	
	private int status;
	private String message;
	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String errorMessage;
	private Object result;
	
	public ResponseBean(int status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}
	
	public ResponseBean(int status, String message, String errorMessage ,Object result) {
		super();
		this.status = status;
		this.message = message;
		this.errorMessage = errorMessage;
		this.result = result;
		
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
		

}
