package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.exception.InvalidException;
import org.example.models.DeliveryEmployeeRequest;
import org.example.validators.DeliveryEmployeeValidator;

import java.sql.SQLException;

public class DeliveryEmployeeService {
    DeliveryEmployeeDao deliveryEmployeeDao;
    DeliveryEmployeeValidator deliveryEmployeeValidator;
    public DeliveryEmployeeService(
            final DeliveryEmployeeDao deliveryEmployeeDao,
            final DeliveryEmployeeValidator deliveryEmployeeValidator) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
        this.deliveryEmployeeValidator = deliveryEmployeeValidator;
    }
   public int createDeliveryEmployee(
           final DeliveryEmployeeRequest request) throws
           SQLException, InvalidException {
            deliveryEmployeeValidator.validateDeliveryEmployee(request);
            int id = deliveryEmployeeDao.createDeliveryEmployee(request);
            if (id == -1) {
                throw new SQLException();
            }
            return 1;
    }
}
