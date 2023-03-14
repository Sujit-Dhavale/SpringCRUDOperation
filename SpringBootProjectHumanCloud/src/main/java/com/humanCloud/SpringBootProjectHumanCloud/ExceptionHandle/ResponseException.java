package com.humanCloud.SpringBootProjectHumanCloud.ExceptionHandle;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ResponseException {
	public Date timespan;
	public HttpStatus error;
	public String msg;

	public ResponseException(Date timespan, HttpStatus error, String msg) {
		super();
		this.timespan = timespan;
		this.error = error;
		this.msg = msg;
	}

}
