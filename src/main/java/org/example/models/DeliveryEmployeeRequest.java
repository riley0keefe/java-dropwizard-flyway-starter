package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private double salary;
    private String bankNumber;
    private String nationalInsuranceNumber;

    public DeliveryEmployeeRequest(final @JsonProperty("firstName")
                                   String firstName,
                                   final @JsonProperty("middleName")
                                   String middleName,
                                   final @JsonProperty("lastName")
                                   String lastName,
                                   final @JsonProperty("salary")
                                   double salary,
                                   final @JsonProperty("bankNumber")
                                   String bankNumber,
                                   final @JsonProperty
                                           ("nationalInsuranceNumber")
                                   String nationalInsuranceNumber
                                   ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

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

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(final String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(
            final String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
