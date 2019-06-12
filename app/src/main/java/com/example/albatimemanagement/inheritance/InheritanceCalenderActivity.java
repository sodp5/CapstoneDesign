package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class InheritanceCalenderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_calender);

        findViewById(R.id.ibtnInheritanceCalenderGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnCalendarComplete).setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), InheritanceCalenderAddSchedulePopupActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusCalender));
    }
}
