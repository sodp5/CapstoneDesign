package com.example.albatimemanagement.inheritance.companydata;

import java.util.ArrayList;

public class CompanyInfo {
    private String name;
    private String presidentName;
    private ArrayList<String> empList;
    private String salaryDay;
    private String address;

    public CompanyInfo(String name, String presidentName, String salaryDay, String address) {
        this.name = name;
        this.presidentName = presidentName;
        this.salaryDay = salaryDay;
        this.address = address;
        empList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresidentName() {
        return presidentName;
    }

    public void setPresidentName(String presidentName) {
        this.presidentName = presidentName;
    }

    public String getSalaryDay() {
        return salaryDay;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getEmpList() {
        return empList;
    }

    public void addEmp(String empName) {
        empList.add(empName);
    }

    public void delEmp(String empName) {
        empList.remove(empName);
    }
}
