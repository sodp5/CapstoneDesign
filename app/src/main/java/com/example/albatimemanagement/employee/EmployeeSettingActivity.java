package com.example.albatimemanagement.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class EmployeeSettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_setting);

        findViewById(R.id.ibtnEmployeeSettingGoBack).setOnClickListener(v -> finish());

        findViewById(R.id.btne1).setOnClickListener(this);
        findViewById(R.id.btne2).setOnClickListener(this);
        findViewById(R.id.btne3).setOnClickListener(this);
        findViewById(R.id.btne4).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusSetting));
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show();
    }
}
