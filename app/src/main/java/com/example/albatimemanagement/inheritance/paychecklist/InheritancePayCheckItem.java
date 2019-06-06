package com.example.albatimemanagement.inheritance.paychecklist;

public class InheritancePayCheckItem {
    private String name;
    private String time;
    private String poh;
    private String salary;

    public InheritancePayCheckItem(String name, String time, String poh, String salary) {
        this.name = name;
        this.time = time;
        this.poh = poh;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPoh() {
        return poh;
    }

    public void setPoh(String poh) {
        this.poh = poh;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
