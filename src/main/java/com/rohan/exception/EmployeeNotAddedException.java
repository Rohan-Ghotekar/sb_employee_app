package com.rohan.exception;

public class EmployeeNotAddedException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotAddedException(String message) {
        super(message);
    }
}