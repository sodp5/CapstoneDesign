package com.example.albatimemanagement.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;

public class InheritanceSettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_setting);

        findViewById(R.id.btni1).setOnClickListener(this);
        findViewById(R.id.btni2).setOnClickListener(this);
        findViewById(R.id.btni3).setOnClickListener(this);
        findViewById(R.id.btni4).setOnClickListener(this);
        findViewById(R.id.btni5).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusSetting));
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show();
    }
}
