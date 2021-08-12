package com.neutron;

public class AlreadyUsedException extends Exception {
    public AlreadyUsedException() { super(); }
    public AlreadyUsedException(String message) { super(message); }
    public AlreadyUsedException(String message, Throwable cause) { super(message, cause); }
    public AlreadyUsedException(Throwable cause) { super(cause); }
}
