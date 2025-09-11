package org.example.Exceptions;

public class FailedToCreateException extends Throwable {
    public FailedToCreateException(final Entity entity) {
        super(entity.getEntity() + "Failed to create");
    }
}
