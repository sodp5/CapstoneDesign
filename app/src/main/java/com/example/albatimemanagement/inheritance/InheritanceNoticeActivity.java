package com.example.albatimemanagement.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.albatimemanagement.R;


public class InheritanceNoticeActivity extends AppCompatActivity {
    private View.OnClickListener unImplement = v -> Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_notice);

        findViewById(R.id.ibtnInheritanceNoticeGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnInheritanceChangeApproval).setOnClickListener(unImplement);
        findViewById(R.id.btnInheritanceChangeRefusal).setOnClickListener(unImplement);
        findViewById(R.id.btnInheritanceApproval).setOnClickListener(unImplement);
        findViewById(R.id.btnInheritanceRefusal).setOnClickListener(unImplement);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusNotice));
    }
}
