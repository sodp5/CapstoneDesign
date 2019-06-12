package com.example.albatimemanagement.employee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class EmployeeAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_acount);

        findViewById(R.id.ibtnEmployeeAccountGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnAccountSearchCompany).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EmployeeAccountFindCompanyActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }
}
