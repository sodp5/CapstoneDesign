package com.example.albatimemanagement.employee;

import android.content.Intent;
import android.os.Bundle;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class EmployeeCalenderActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_calender);

        findViewById(R.id.ibtnEmployeeCalenderGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnCalendarRequestChange).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), EmployeeScheduleChangePopUpActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusCalender));
    }
}
