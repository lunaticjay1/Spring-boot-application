package com.customers.Springboot.application.exception;

public class ErrorDetails {

	public String code;
	public String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ErrorDetails [code=" + code + ", description=" + description + "]";
	}

}
