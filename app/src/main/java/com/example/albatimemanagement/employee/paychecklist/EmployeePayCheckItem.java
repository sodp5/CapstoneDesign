package com.example.albatimemanagement.employee.paychecklist;

public class EmployeePayCheckItem {
    private String stackTime;
    private String poh;
    private String salaryDay;
    private String som;

    public EmployeePayCheckItem(String stackTime, String poh, String salaryDay, String som) {
        this.stackTime = stackTime;
        this.poh = poh;
        this.salaryDay = salaryDay;
        this.som = som;
    }

    public String getStackTime() {
        return stackTime;
    }

    public void setStackTime(String stackTime) {
        this.stackTime = stackTime;
    }

    public String getPoh() {
        return poh;
    }

    public void setPoh(String poh) {
        this.poh = poh;
    }

    public String getSalaryDay() {
        return salaryDay;
    }

    public void setSalaryDay(String salaryDay) {
        this.salaryDay = salaryDay;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }
}
