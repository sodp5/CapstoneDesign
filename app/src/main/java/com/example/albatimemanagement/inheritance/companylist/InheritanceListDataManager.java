package com.example.albatimemanagement.inheritance.companylist;

import java.util.ArrayList;

public class InheritanceListDataManager {
    private ArrayList<CompanyInfo> companyList;

    private InheritanceListDataManager() {
        companyList = new ArrayList<>();
    }

    public ArrayList<CompanyInfo> getCompanyList() {
        return companyList;
    }

    private static class Singleton {
        private final static InheritanceListDataManager instance = new InheritanceListDataManager();
    }

    public static InheritanceListDataManager getInstance() {
        return Singleton.instance;
    }
}
