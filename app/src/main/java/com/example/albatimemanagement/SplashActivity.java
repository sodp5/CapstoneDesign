package com.example.albatimemanagement;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.companylist.CompanyInfo;
import com.example.albatimemanagement.inheritance.companylist.InheritanceListDataManager;

import java.util.ArrayList;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initDataManager();

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplication(), LoginActivity.class));
                SplashActivity.this.finish();
            }
        }, 2500);
    }

    @Override
    public void onBackPressed() {
    }

    private void initDataManager() {
        InheritanceListDataManager dm = InheritanceListDataManager.getInstance();

        ArrayList<CompanyInfo> companyList = dm.getCompanyList();

        companyList.clear();

        CompanyInfo companyInfo = new CompanyInfo("(주)PJW");
        companyInfo.addEmp("경문1");
        companyInfo.addEmp("경문2");
        CompanyInfo companyInfo2 = new CompanyInfo("(주)JSD");
        companyInfo2.addEmp("태기1");
        companyInfo2.addEmp("태기2");
        CompanyInfo companyInfo3 = new CompanyInfo("(주)KWS");
        companyInfo3.addEmp("이헌1");
        companyInfo3.addEmp("이헌2");
        CompanyInfo companyInfo4 = new CompanyInfo("(주)KJS");
        companyInfo4.addEmp("다연1");
        companyInfo4.addEmp("다연2");

        companyList.add(companyInfo);
        companyList.add(companyInfo2);
        companyList.add(companyInfo3);
        companyList.add(companyInfo4);
    }
}
