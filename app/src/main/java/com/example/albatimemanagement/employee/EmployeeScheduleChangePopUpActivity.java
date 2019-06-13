package com.example.albatimemanagement.employee;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.albatimemanagement.R;

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }

    @Override
    public void onBackPressed() {
    }
}
