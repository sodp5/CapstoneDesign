package com.example.albatimemanagement.employee;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.albatimemanagement.R;

import java.util.ArrayList;

public class EmployeeScheduleChangePopUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_employee_schedule_change_pop_up);

        findViewById(R.id.btnChangeCancel).setOnClickListener(v -> {
            Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        });

        findViewById(R.id.btnChangeComplete).setOnClickListener(v -> {
            Toast.makeText(this, "변경요청 되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
        });

        ((Spinner)findViewById(R.id.spinnerReason)).setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, new String[] {"시간교체", "대타"}));
        ((Spinner)findViewById(R.id.spinnerEmployeeName)).setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, new String[] {"직원이름", "안경문", "김태기", "이  헌", "남다연"}));
        ((Spinner)findViewById(R.id.spinnerMyTime)).setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, new String[] {"본인시간", "10:00", "15:00"}));
        ((Spinner)findViewById(R.id.spinnerOtherTime)).setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, new String[] {"상대시간", "10:00", "15:00"}));


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    @Override
    public void onBackPressed() {
    }
}
