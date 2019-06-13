package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.companydata.CompanyInfo;
import com.example.albatimemanagement.inheritance.companydata.InheritanceListDataManager;

import java.util.ArrayList;

public class InheritancePayCheckSelectActivity extends BaseActivity {
    private ListView lvInheritancePayCheck;
    private ArrayAdapter<String> inheritanceListAdapter;
    private ArrayList<CompanyInfo> companyList;
    private InheritanceListDataManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_pay_check_select);

        findViewById(R.id.ibtnInheritancePayCheckSelectGoBack).setOnClickListener(v -> finish());

        initView();
        initInstance();

        companyList = dm.getCompanyList();

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
                intent.putExtra("name", c.getName());
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
