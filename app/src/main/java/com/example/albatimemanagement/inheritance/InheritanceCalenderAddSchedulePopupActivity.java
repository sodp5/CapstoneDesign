package com.example.albatimemanagement.inheritance;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

import java.util.ArrayList;

public class InheritanceCalenderAddSchedulePopupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inheritance_calender_add_schedule_popup);

        findViewById(R.id.btnCancel).setOnClickListener(v -> {
            Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        });

        findViewById(R.id.btnConfirm).setOnClickListener(v -> {
            Toast.makeText(this, "적용 되었습니다.", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        });

        findViewById(R.id.btnAddTime).setOnClickListener(v -> {
            Toast.makeText(this, "시간이 추가 되었습니다.", Toast.LENGTH_SHORT).show();
            findViewById(R.id.addTimeView).setVisibility(View.VISIBLE);
        });

        ArrayList<String> timeList = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            if (i < 10)
                timeList.add("0" + i);
            else
                timeList.add(String.valueOf(i));
        }
        ArrayList<String> minuteList = new ArrayList<>();
        for (int i = 0; i <= 59; i++) {
            if (i < 10)
                minuteList.add("0" + i);
            else
                minuteList.add(String.valueOf(i));
        }

        ((Spinner)findViewById(R.id.spinnerAddEmployeeName)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, new String[] {"직원이름", "안경문", "김태기", "이  헌", "남다연"}));
        ((Spinner)findViewById(R.id.spinnerAddDate)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, new String[] {"월", "화", "수", "목", "금", "토", "일"}));
        ((Spinner)findViewById(R.id.spinnerHour1)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, timeList));
        ((Spinner)findViewById(R.id.spinnerMinute1)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, minuteList));
        ((Spinner)findViewById(R.id.spinnerHour2)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, timeList));
        ((Spinner)findViewById(R.id.spinnerMinute2)).setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_spinner_dropdown_item, minuteList));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    @Override
    public void onBackPressed() {
    }
}
