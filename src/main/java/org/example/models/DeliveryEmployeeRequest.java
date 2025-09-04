package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployeeRequest {
    private String name;
    private double salary;
    private String bankNumber;
    private String nationalInsuranceNumber;

    public DeliveryEmployeeRequest(@JsonProperty("name") String name,
                                   @JsonProperty("salary") double salary,
                                   @JsonProperty("bankNumber") String bankNumber,
                                   @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNumber
                                   ) {
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
