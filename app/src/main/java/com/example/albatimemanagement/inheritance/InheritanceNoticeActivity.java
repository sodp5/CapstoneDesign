package com.example.albatimemanagement.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.albatimemanagement.R;

public class InheritanceNoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_notice);

        findViewById(R.id.ibtnInheritanceNoticeGoBack).setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusNotice));
    }
}
