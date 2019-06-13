package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class InheritanceCalenderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_calender);

        findViewById(R.id.ibtnInheritanceCalenderGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnCalendarComplete).setOnClickListener(v -> startActivityForResult(new Intent(getApplicationContext(), InheritanceCalenderAddSchedulePopupActivity.class), 0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusCalender));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    ((TextView)findViewById(R.id.tvGoneName)).setText("남다연");
                    ((TextView)findViewById(R.id.tvGoneTime)).setText("10:00~12:00");
                }
        }
    }
}
