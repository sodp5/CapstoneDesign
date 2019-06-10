package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.inheritance.companylist.CompanyInfo;
import com.example.albatimemanagement.inheritance.companylist.InheritanceListDataManager;

import java.util.ArrayList;

public class InheritancePayCheckSelectActivity extends AppCompatActivity {
    private ListView lvInheritancePayCheck;
    private ArrayAdapter<String> inheritanceListAdapter;
    private ArrayList<CompanyInfo> companyList;
    private InheritanceListDataManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_pay_check_select);

        initView();
        initInstance();

        companyList = dm.getCompanyList();

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

        inheritanceListAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.item_inheritance_name_list);
//        inheritanceListAdapter.add("(주)PJW");
//        inheritanceListAdapter.add("(주)KWS");
//        inheritanceListAdapter.add("(주)JSD");

        for (CompanyInfo c : companyList) {
            inheritanceListAdapter.add(c.getName());
        }

        lvInheritancePayCheck.setAdapter(inheritanceListAdapter);

        lvInheritancePayCheck.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CompanyInfo c = companyList.get(i);
                Intent intent = new Intent(getApplicationContext(), InheritancePayCheckActivity.class);
                int size = 0;
                for (String s : c.getEmpList()) {
                    intent.putExtra("member" + size++, s);
                }
                intent.putExtra("size", size);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusPaycheck));
    }

    private void initView() {
        lvInheritancePayCheck = findViewById(R.id.lvInheritancePayCheck);
    }

    private void initInstance() {
        dm = InheritanceListDataManager.getInstance();
    }
}
