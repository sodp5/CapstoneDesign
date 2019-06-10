package com.example.albatimemanagement.inheritance.companylist;

import java.util.ArrayList;

public class CompanyInfo {
    private String name;
    private ArrayList<String> empList;

    public CompanyInfo(String name) {
        this.name = name;
        empList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
