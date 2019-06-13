package com.example.albatimemanagement.employee.paychecklist;

public class EmployeePayCheckItem {
    private String stackTime;
    private String poh;
    private String salaryDay;
    private String som;
    private String companyName;

    public EmployeePayCheckItem(String stackTime, String poh, String salaryDay, String som, String companyName) {
        this.stackTime = stackTime;
        this.poh = poh;
        this.salaryDay = salaryDay;
        this.som = som;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return companyName;
    }
}
