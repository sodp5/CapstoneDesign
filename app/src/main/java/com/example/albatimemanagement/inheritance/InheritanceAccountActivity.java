package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class InheritanceAccountActivity extends BaseActivity {
    private Button btnAddCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_account);

        findViewById(R.id.ibtnInheritanceAccountGoBack).setOnClickListener(v -> finish());

        btnAddCompany = findViewById(R.id.btnAddCompany);
        btnAddCompany.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), InheritanceAddCompanyActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }
}
