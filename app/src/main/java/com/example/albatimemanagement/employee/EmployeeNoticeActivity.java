package com.example.albatimemanagement.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.albatimemanagement.R;

public class EmployeeNoticeActivity extends AppCompatActivity {

    private View.OnClickListener unImplement = v -> Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_notice);

        findViewById(R.id.ibtnEmployeeNoticeGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnApproval).setOnClickListener(v -> {
            Toast.makeText(this, "처리 되었습니다.", Toast.LENGTH_SHORT).show();
            findViewById(R.id.btnApproval).setVisibility(View.GONE);
            findViewById(R.id.btnRefusal).setVisibility(View.GONE);
            findViewById(R.id.tvWantVisible).setVisibility(View.VISIBLE);
        });
        findViewById(R.id.btnRefusal).setOnClickListener(unImplement);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusNotice));
    }
}
