package com.springjpa.exception;

public class CustomerException extends Exception {
    
    private static final long serialVersionUID = -3128681006635769411L;
     
    public CustomerException(String message) {
        super(message);
    }
 
}