package org.example.daos;

import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryEmployeeDao {
    final int bankNumIndex = 3;
    final int nationalInsuranceNumIndex = 4;
    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest employee) throws
            SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String insertStatement = "INSERT INTO DeliveryEmployees "
                    + "(`name`, `salary`, `bank_number`,"
                    + " `national_insurance_number`) "
                    + "VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection
                    .prepareStatement(insertStatement,
                            Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,
                    employee.getFirstName()
                            + " "
                            + employee.getMiddleName()
                            + " "
                            + employee.getLastName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(bankNumIndex, employee.getBankNumber());
            preparedStatement.setString(nationalInsuranceNumIndex,
                    employee.getNationalInsuranceNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }
}
