package org.example.services;

import org.example.Exceptions.Entity;
import org.example.Exceptions.FailedToCreateException;
import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployeeRequest;


import java.sql.SQLException;

public class DeliveryEmployeeService {

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
        if (lenthOfNIN != 9 && lenthOfNIN != 15 && lenthOfNIN != 19) {
            throw new RuntimeException("National Insurance Number " +
                    "must be 9, 15 or 19 characters long.");
        }
        // Canada NIN check
        if (lenthOfNIN == 9) {
            if (!nin.matches("\\d+")) {
                throw new RuntimeException("Canadian National Insurance " +
                        "Number can be numbers only.");
            }
        }

        // China NIN check first 18 digits last can be X or digit
        if (lenthOfNIN == 19) {
            if (!nin.substring(0, 18).matches("\\d+")) {
                throw new RuntimeException("First 18 characters of Chinese " +
                        "National Insurance Number must be numbers only.");
            }
            if (!nin.substring(18).matches("\\d|X")) {
                throw new RuntimeException("Last character of Chinese " +
                        "National Insurance Number must be a number or an X.");
            }
        }

        // France NIN check numbers only
        if (lenthOfNIN == 15) {
            if (!nin.matches("\\d+")) {
                throw new RuntimeException("French National Insurance " +
                        "Number must be numbers only.");
            }
        }

        if (deliveryEmployeeRequest.getSalary() < 0) {
            throw new RuntimeException("Salary cannot be negative");
        }

        if (deliveryEmployeeRequest.getFirstName().trim().length() < 2) {
            throw new RuntimeException("First name must be greater than 2 " +
                    "characters.");
        }
        if (deliveryEmployeeRequest.getFirstName().trim().length() > 49) {
            throw new RuntimeException("First name must be less than " +
                    "50 characters.");
        }

        if (deliveryEmployeeRequest.getLastName().trim().length() < 2) {
            throw new RuntimeException("Last name must be greater than " +
                    "2 characters.");
        }
        if (deliveryEmployeeRequest.getLastName().trim().length() > 49) {
            throw new RuntimeException("First name must be less than " +
                    "50 characters.");
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
