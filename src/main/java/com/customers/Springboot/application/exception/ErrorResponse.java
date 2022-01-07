package com.customers.Springboot.application.exception;

import java.util.List;

public class ErrorResponse {

	private String result;
	private String source;
	// Specific errors in API request processing
	private List<ErrorDetails> errorDetails;

	public ErrorResponse(String result, String source, List<ErrorDetails> errorDetails) {

		this.result = result;
		this.source = source;
		this.errorDetails = errorDetails;
	}

	// Getter and setters
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<ErrorDetails> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<ErrorDetails> errorDetails) {
		this.errorDetails = errorDetails;
	}

	@Override
	public String toString() {
		return "ErrorResponse [result=" + result + ", source=" + source + ", errorDetails=" + errorDetails + "]";
	}

}