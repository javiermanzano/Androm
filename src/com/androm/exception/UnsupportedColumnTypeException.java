package com.androm.exception;

public class UnsupportedColumnTypeException extends RuntimeException {
	
	public UnsupportedColumnTypeException() {
		super();
	}
	
	public UnsupportedColumnTypeException(String msg) {
		super(msg);
	}

}
