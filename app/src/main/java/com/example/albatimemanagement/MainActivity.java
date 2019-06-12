package com.example.albatimemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.employee.EmployeeAccountActivity;
import com.example.albatimemanagement.employee.EmployeeCalenderActivity;
import com.example.albatimemanagement.employee.EmployeePayCheckActivity;
import com.example.albatimemanagement.employee.EmployeeSettingActivity;
import com.example.albatimemanagement.inheritance.InheritanceAccountActivity;
import com.example.albatimemanagement.inheritance.InheritanceCalenderActivity;
import com.example.albatimemanagement.inheritance.InheritancePayCheckSelectActivity;
import com.example.albatimemanagement.inheritance.InheritanceSettingActivity;

public class MainActivity extends BaseActivity {
    public static final String CLASSIFICATION = "classification";
    public static final String INHERITANCE = "inheritance";
    public static final String EMPLOYEE = "employee";

    private String classification;

    private Intent intentAccount, intentCalender, intentPaycheck, intentNotice, intentSetting;
    private View goToAccount, goToCalender, goToPaycheck, goToNotice, goToSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

        classification = getIntent().getStringExtra(CLASSIFICATION);
        if (classification.equals(INHERITANCE))
            initInheritanceIntent();
        else {
           initEmployeeIntent();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusMain));
    }

    private void initView() {
        goToAccount = findViewById(R.id.goToAccount);
        goToCalender = findViewById(R.id.goToCalender);
        goToPaycheck = findViewById(R.id.goToPaycheck);
        goToNotice = findViewById(R.id.goToNotice);
        goToSetting = findViewById(R.id.goToSetting);
    }

    private void initEvent() {
        goToAccount.setOnClickListener(clickListener);
        goToCalender.setOnClickListener(clickListener);
        goToPaycheck.setOnClickListener(clickListener);
        goToNotice.setOnClickListener(clickListener);
        goToSetting.setOnClickListener(clickListener);
    }

    private void initEmployeeIntent() {
        intentPaycheck = new Intent(getApplicationContext(), EmployeePayCheckActivity.class);
        intentCalender = new Intent(getApplicationContext(), EmployeeCalenderActivity.class);
        intentAccount = new Intent(getApplicationContext(), EmployeeAccountActivity.class);
        intentSetting = new Intent(getApplicationContext(), EmployeeSettingActivity.class);
    }


    private void initInheritanceIntent() {
        intentPaycheck = new Intent(getApplicationContext(), InheritancePayCheckSelectActivity.class);
        intentCalender = new Intent(getApplicationContext(), InheritanceCalenderActivity.class);
        intentAccount = new Intent(getApplicationContext(), InheritanceAccountActivity.class);
        intentSetting = new Intent(getApplicationContext(), InheritanceSettingActivity.class);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.goToAccount:
                    intent = intentAccount;
                    break;
                case R.id.goToCalender:
                    intent = intentCalender;
                    break;
                case R.id.goToPaycheck:
                    intent = intentPaycheck;
                    break;
                case R.id.goToNotice:
                    intent = intentNotice;
                    break;
                case R.id.goToSetting:
                    intent = intentSetting;
                    break;
            }
            if (intent == null) {
                Toast.makeText(MainActivity.this, "미구현", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(intent);
        }
    };


}
