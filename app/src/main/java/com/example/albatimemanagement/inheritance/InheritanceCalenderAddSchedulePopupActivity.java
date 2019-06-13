package com.example.albatimemanagement.inheritance;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

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
