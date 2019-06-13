package com.example.albatimemanagement;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.companydata.CompanyInfo;
import com.example.albatimemanagement.inheritance.companydata.InheritanceListDataManager;

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

        CompanyInfo companyInfo = new CompanyInfo("(주)PJW", "박지웅", "1일", "경기도 시흥시 정왕동 C326");
        companyInfo.addEmp("안경문");
        companyInfo.addEmp("김경문");
        CompanyInfo companyInfo2 = new CompanyInfo("(주)JSD", "전선도", "10일", "경기도 시흥시 정왕동 C320");
        companyInfo2.addEmp("김태기");
        companyInfo2.addEmp("이태기");
        CompanyInfo companyInfo3 = new CompanyInfo("(주)KWS", "김응성", "15일", "경기도 시흥시 정왕동 C324");
        companyInfo3.addEmp("이  헌");
        companyInfo3.addEmp("박  헌");
        CompanyInfo companyInfo4 = new CompanyInfo("(주)KJS", "김정식", "10일", "경기도 시흥시 정왕동 C116");
        companyInfo4.addEmp("남다연");
        companyInfo4.addEmp("최다연");

        companyList.add(companyInfo);
        companyList.add(companyInfo2);
        companyList.add(companyInfo3);
        companyList.add(companyInfo4);
    }
}
