package org.example.Exceptions;

public class NINLengthNotValidException extends RuntimeException {
    public NINLengthNotValidException() {
        super("National Insurance Number Length is not a valid number for "
                + "Canada, France, or China");
    }
}
