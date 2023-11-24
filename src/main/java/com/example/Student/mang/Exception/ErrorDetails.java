package com.example.Student.mang.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCodel;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCodel) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.errorCodel = errorCodel;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCodel() {
		return errorCodel;
	}
	public void setErrorCodel(String errorCodel) {
		this.errorCodel = errorCodel;
	}

}
