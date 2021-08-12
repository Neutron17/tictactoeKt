package com.neutron.io;

import java.io.IOException;

public class NotFileException extends IOException {
    public NotFileException() { super(); }
    public NotFileException(String message) { super(message); }
    public NotFileException(String message, Throwable cause) { super(message, cause); }
    public NotFileException(Throwable cause) { super(cause); }
}
