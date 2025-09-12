package org.example.models;

/**
 * Represents a delivery employee in the system.
 */
public class DeliveryEmployee {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private double salary;
    private String bankAccount;
    private String nationalInsuranceNumber;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(final String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(
            final String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public DeliveryEmployee(final int id,
                            final String firstName,
                            final String middleName,
                            final String lastName,
                            final double salary,
                            final String bankAccount,
                            final String nationalInsuranceNumber) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.bankAccount = bankAccount;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }
}
