package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.companydata.CompanyInfo;
import com.example.albatimemanagement.inheritance.companydata.InheritanceListDataManager;
import com.example.albatimemanagement.inheritance.mycompanylist.InheritanceMyCompanyAdapter;

public class InheritanceAccountActivity extends BaseActivity {
    private Button btnAddCompany;
    private ListView lvInheritanceAccountMyCompany;
    private InheritanceMyCompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_account);

        findViewById(R.id.ibtnInheritanceAccountGoBack).setOnClickListener(v -> finish());

        lvInheritanceAccountMyCompany = findViewById(R.id.lvInheritanceAccountMyCompany);
        btnAddCompany = findViewById(R.id.btnAddCompany);
        btnAddCompany.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), InheritanceAddCompanyActivity.class)));

        adapter = new InheritanceMyCompanyAdapter(getApplicationContext(), InheritanceListDataManager.getInstance().getCompanyList());

        ((TextView)findViewById(R.id.tvInheritanceAccountCompanyName)).setText(adapter.getItem(0).getName());
        ((TextView)findViewById(R.id.tvInheritanceAccountNumberOfEmployee)).setText(String.format("%d",adapter.getItem(0).getEmpList().size()));
        ((TextView)findViewById(R.id.tvInheritanceAccountSalaryDay)).setText(adapter.getItem(0).getSalaryDay());

        lvInheritanceAccountMyCompany.setOnItemClickListener((adapterView, view, index, length) -> {
            CompanyInfo c = (CompanyInfo)adapterView.getItemAtPosition(index);
            ((TextView)findViewById(R.id.tvInheritanceAccountCompanyName)).setText(c.getName());
            ((TextView)findViewById(R.id.tvInheritanceAccountNumberOfEmployee)).setText(String.format("%d",c.getEmpList().size()));
            ((TextView)findViewById(R.id.tvInheritanceAccountSalaryDay)).setText(c.getSalaryDay());
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
        lvInheritanceAccountMyCompany.setAdapter(adapter);
    }
}
