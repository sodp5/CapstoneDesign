package com.example.albatimemanagement.employee;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class ScheduleChangePopUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_schedule_change_pop_up);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return event.getAction() != MotionEvent.ACTION_OUTSIDE;
    }
}
