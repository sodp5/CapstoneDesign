package com.example.albatimemanagement.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.albatimemanagement.R;

public class EmployeeAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_acount);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }
}
