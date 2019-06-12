package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.albatimemanagement.R;

public class InheritanceAccountActivity extends AppCompatActivity {
    private Button btnAddCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_account);

        btnAddCompany = findViewById(R.id.btnAddCompany);

        btnAddCompany.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), InheritanceAddCompanyActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }
}
