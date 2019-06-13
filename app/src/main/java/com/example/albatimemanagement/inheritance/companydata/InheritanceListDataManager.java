package com.example.albatimemanagement.inheritance.companydata;

import java.util.ArrayList;

public class InheritanceListDataManager {
    private ArrayList<CompanyInfo> companyList;

    private InheritanceListDataManager() {
        companyList = new ArrayList<>();
    }

    public ArrayList<CompanyInfo> getCompanyList() {
        return companyList;
    }

    public void addCompany(CompanyInfo c) {
        companyList.add(c);
    }

    private static class Singleton {
        private final static InheritanceListDataManager instance = new InheritanceListDataManager();
    }

    public static InheritanceListDataManager getInstance() {
        return Singleton.instance;
    }
}
