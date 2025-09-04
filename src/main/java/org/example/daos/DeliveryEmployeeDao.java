package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {
    public int createDeliveryEmployee(DeliveryEmployeeRequest employee) throws
            SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String insertStatement = "INSERT INTO DeliveryEmployees "
                    + "(`name`, `salary`, `bank_number`,"
                    + " `national_insurance_number`) "
                    + "VALUES (?, ?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getBankNumber());
            preparedStatement.setString(4, employee.getNationalInsuranceNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

    public List<DeliveryEmployee>  getDeliveryEmployees() throws SQLException {
        List<DeliveryEmployee> deliveryEmployees = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String selectStatement = "SELECT name, salary, bank_number, national_insurance_number FROM DeliveryEmployees";

            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_number"),
                        resultSet.getString("national_insurance_number")
                );

                deliveryEmployees.add(deliveryEmployee);
            }
        }

        return deliveryEmployees;
    }
}
