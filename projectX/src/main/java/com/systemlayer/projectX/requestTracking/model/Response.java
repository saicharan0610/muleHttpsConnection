package com.systemlayer.projectX.requestTracking.model;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	public Response() {
		super();
		this.success = false;
	}

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Response [success=" + success + "]";
	}
	
}
