package com.jira.demo.model;

public class CustomResponse{

	int status;
	String message;
	Object data;
	
	public CustomResponse(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public CustomResponse(int status, String message) {
		this.status = status;
		this.message = message;
		this.data = null;
	}
	public CustomResponse(int status) {
		this.status = status;
		this.message = "Failure";
		this.data = null;
	}
	public CustomResponse() {
		this.status = 500;
		this.message = "Failure";
		this.data = null;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "CustomResponse [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
}
