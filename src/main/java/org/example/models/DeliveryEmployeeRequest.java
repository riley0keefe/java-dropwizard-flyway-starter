package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to create a delivery employee in the system.
 */
public class DeliveryEmployeeRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private double salary;
    private String bankAccount;
    private String nationalInsuranceNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(final String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(final String nationalInsuranceNo) {
        this.nationalInsuranceNumber = nationalInsuranceNo;
    }

    @SuppressWarnings("checkstyle:ParameterNumber")
    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("firstName") final String firstName,
            @JsonProperty("middleName") final String middleName,
            @JsonProperty("lastName") final String lastName,
            @JsonProperty("salary") final double salary,
            @JsonProperty("bankAccount") final String bankAccount,
            @JsonProperty("nationalInsuranceNumber")
            final String nationalInsuranceNumber

    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
