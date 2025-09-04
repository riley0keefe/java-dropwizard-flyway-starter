package org.example.services;

import org.example.daos.DeliveryEmployeeDao;
import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.SQLException;

public class DeliveryEmployeeService {
    DeliveryEmployeeDao deliveryEmployeeDao;
    public DeliveryEmployeeService(DeliveryEmployeeDao deliveryEmployeeDao) {
        this.deliveryEmployeeDao = deliveryEmployeeDao;
    }
   public int createDeliveryEmployee(DeliveryEmployeeRequest request) throws
           SQLException {
       int id = deliveryEmployeeDao.createDeliveryEmployee(request);
         if (id == -1) {
              throw new SQLException();
         }
       return 1;
   }
}
