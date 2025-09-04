package org.example.validators;

import org.example.exception.Entity;
import org.example.exception.InvalidException;
import org.example.models.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {
    final int maxFullLengthName = 64;
    final int bankNumberMaxLength = 27;
    final int nationalInsuranceNumberMaxLength = 20;

    public void validateDeliveryEmployee(final DeliveryEmployeeRequest req)
            throws InvalidException {
        if ((req.getFirstName().length()
                + req.getMiddleName().length()
                + req.getLastName().length()) > maxFullLengthName) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Full name exceeds maximum length of 64 characters.");
        }

        if (req.getFirstName() == null || req.getFirstName().isEmpty()) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "First name is required.");
        }

        if (req.getLastName() == null || req.getLastName().isEmpty()) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Last name is required.");
        }

        if (req.getSalary() < 0) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Salary cannot be negative.");
        }

        if (req.getSalary() == 0) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Salary must be greater than zero.");
        }

        if (req.getBankNumber() == null || req.getBankNumber().isEmpty()) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Bank number is required.");
        }

        if (req.getBankNumber().length() > bankNumberMaxLength) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "Bank number exceeds maximum length of 27 characters.");
        }

        if (req.getNationalInsuranceNumber() == null
                || req.getNationalInsuranceNumber().isEmpty()) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "National Insurance Number is required.");
        }

        if (req.getNationalInsuranceNumber().length()
                > nationalInsuranceNumberMaxLength) {
            throw new InvalidException(Entity.DELIVERY_EMPLOYEE,
                    "National Insurance Number "
                            + "exceeds maximum length of 20 characters.");
        }

    }
}
