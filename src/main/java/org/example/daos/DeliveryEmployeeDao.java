package org.example.daos;

import org.example.models.DeliveryEmployee;
import org.example.models.DeliveryEmployeeRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DeliveryEmployeeDao {
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    public int createDeliveryEmployee(
            final DeliveryEmployeeRequest deliveryEmployeeRequest)
            throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String insertStatement =
                    "INSERT INTO `delivery_employee` (first_name,"
                            + " middle_name, last_name, salary, "
                            + "bank_account_number, national_insurance_number)"
                            + " VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(
                    insertStatement, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(
                    1, deliveryEmployeeRequest.getFirstName());
            preparedStatement.setString(
                    2, deliveryEmployeeRequest.getMiddleName());
            preparedStatement.setString(
                    THREE, deliveryEmployeeRequest.getLastName());
            preparedStatement.setDouble(
                    FOUR, deliveryEmployeeRequest.getSalary());
            preparedStatement.setString(
                    FIVE, deliveryEmployeeRequest.getBankAccount());
            preparedStatement.setString(
                    SIX, deliveryEmployeeRequest.
                            getNationalInsuranceNumber());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        List<DeliveryEmployee> deliveryEmployees =
                new java.util.ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT id, first_name, middle_name, " +
                    "last_name, salary, bank_account_number, " +
                    "national_insurance_number FROM `delivery_employee`;";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("last_name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_account_number"),
                        resultSet.getString("national_insurance_number")
                );
                deliveryEmployees.add(deliveryEmployee);
            }
        }
        return deliveryEmployees;
    }
}
