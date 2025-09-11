package org.example.services;

import org.example.Exceptions.Entity;
import org.example.Exceptions.FailedToCreateException;
import org.example.Exceptions.NINLengthNotValidException;
import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;


import java.sql.SQLException;
import java.util.List;

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

        int lenthOfNIN = deliveryEmployeeRequest.getNationalInsuranceNumber().length();
        if (lenthOfNIN != 9 && lenthOfNIN != 15 && lenthOfNIN != 18) {
            throw new NINLengthNotValidException();
        }

        int id = deliveryEmployeeDao.createDeliveryEmployee(
                deliveryEmployeeRequest);
        if (id == -1) {
            throw new FailedToCreateException(Entity.DELIVERY_EMPLOYEE);
        }
        return id;
    }

    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        return deliveryEmployeeDao.getAllDeliveryEmployees();
    }
}
