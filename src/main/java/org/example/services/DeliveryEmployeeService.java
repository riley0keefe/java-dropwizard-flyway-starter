package org.example.services;

import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployeeRequest;


import java.sql.SQLException;

public class DeliveryEmployeeService {
    private static final int NINE = 9;
    private static final int FIFTEEN = 15;
    private static final int EIGHTEEN = 18;
    private static final int NINETEEN = 19;
    private static final int FORTY_NINE = 49;

    DeliveryEmployeeDao deliveryEmployeeDao;

    public DeliveryEmployeeService(
            final DeliveryEmployeeDao deliveryEmployeeDao) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
    }

    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws FailedToCreateException,
            SQLException {

        String nin = deliveryEmployeeRequest.getNationalInsuranceNumber();
        int lenthOfNIN = nin.length();
        if (lenthOfNIN != NINE
                && lenthOfNIN != FIFTEEN
                && lenthOfNIN != NINETEEN) {
            throw new RuntimeException("National Insurance Number "
                    + "must be 9, 15 or 19 characters long.");
        }
        // Canada NIN check
        if (lenthOfNIN == NINE) {
            if (!nin.matches("\\d+")) {
                throw new RuntimeException("Canadian National Insurance "
                        + "Number can be numbers only.");
            }
        }

        // China NIN check first 18 digits last can be X or digit
        if (lenthOfNIN == NINETEEN) {
            if (!nin.substring(0, EIGHTEEN).matches("\\d+")) {
                throw new RuntimeException("First 18 characters of Chinese "
                        + "National Insurance Number must be numbers only.");
            }
            if (!nin.substring(EIGHTEEN).matches("\\d|X")) {
                throw new RuntimeException("Last character of Chinese "
                        + "National Insurance Number "
                        + "must be a number or an X.");
            }
        }

        // France NIN check numbers only
        if (lenthOfNIN == FIFTEEN) {
            if (!nin.matches("\\d+")) {
                throw new RuntimeException("French National Insurance "
                        + "Number must be numbers only.");
            }
        }

        if (deliveryEmployeeRequest.getSalary() < 0) {
            throw new RuntimeException("Salary cannot be negative");
        }

        if (deliveryEmployeeRequest.getFirstName().trim().length() < 2) {
            throw new RuntimeException("First name must be greater than 2 "
                    + "characters.");
        }
        if (deliveryEmployeeRequest.getFirstName()
                .trim().length() > FORTY_NINE) {
            throw new RuntimeException("First name must be less than "
                    + "50 characters.");
        }

        if (deliveryEmployeeRequest.getLastName().trim().length() < 2) {
            throw new RuntimeException("Last name must be greater than "
                    + "2 characters.");
        }
        if (deliveryEmployeeRequest.getLastName().trim()
                .length() > FORTY_NINE) {
            throw new RuntimeException("First name must be less than "
                    + "50 characters.");
        }

        if (!deliveryEmployeeRequest.getBankAccount().matches("\\d+")) {
            throw new RuntimeException("Bank account must be numbers only.");
        }

        int id = deliveryEmployeeDao.createDeliveryEmployee(
                deliveryEmployeeRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERY_EMPLOYEE);
        }
        return id;
    }

}
