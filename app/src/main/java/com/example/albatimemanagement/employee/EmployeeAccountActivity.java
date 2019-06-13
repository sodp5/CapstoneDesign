package com.example.albatimemanagement.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.employee.mycompanylist.EmployeeMyCompanyAdapter;
import com.example.albatimemanagement.inheritance.companydata.CompanyInfo;
import com.example.albatimemanagement.inheritance.companydata.InheritanceListDataManager;
import com.example.albatimemanagement.inheritance.mycompanylist.InheritanceMyCompanyAdapter;

public class EmployeeAccountActivity extends BaseActivity {
    private ListView lvEmployeeMyCompanyList;
    private EmployeeMyCompanyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_acount);

        findViewById(R.id.ibtnEmployeeAccountGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnAccountSearchCompany).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EmployeeAccountFindCompanyActivity.class)));

        lvEmployeeMyCompanyList = findViewById(R.id.lvEmployeeMyCompanyList);

        adapter = new EmployeeMyCompanyAdapter(getApplicationContext(), InheritanceListDataManager.getInstance().getCompanyList());

        ((TextView)findViewById(R.id.tvEmployeeAccountCompanyName)).setText(adapter.getItem(0).getName());
        ((TextView)findViewById(R.id.tvEmployeeAccountSalaryDay)).setText(adapter.getItem(0).getSalaryDay());

        lvEmployeeMyCompanyList.setOnItemClickListener((adapterView, view, i, l) -> {
            CompanyInfo c = (CompanyInfo)adapterView.getItemAtPosition(i);
            ((TextView)findViewById(R.id.tvEmployeeAccountCompanyName)).setText(c.getName());
            ((TextView)findViewById(R.id.tvEmployeeAccountSalaryDay)).setText(c.getSalaryDay());
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));

        lvEmployeeMyCompanyList.setAdapter(adapter);
    }
}
