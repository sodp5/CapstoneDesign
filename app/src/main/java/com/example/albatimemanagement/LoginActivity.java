package com.example.albatimemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.albatimemanagement.baseactivity.BaseActivity;

public class LoginActivity extends BaseActivity {
    private EditText edtLoginUserName;
    private EditText edtLoginPassword;

    private Button btnSelectInheritance;
    private Button btnSelectEmployee;
    private Button btnLogin;
    private Button btnJoinIn;

    private String classification = MainActivity.INHERITANCE;

    private final String ID = "admin";
    private final String PW = "1234";

    private View.OnClickListener unImplement = v -> Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnFindId).setOnClickListener(unImplement);
        findViewById(R.id.btnFindPw).setOnClickListener(unImplement);

        initView();
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusSplash));
    }

    private void initView() {
        edtLoginUserName = findViewById(R.id.edtLoginUserName);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);
        btnSelectInheritance = findViewById(R.id.btnSelectInheritance);
        btnSelectEmployee = findViewById(R.id.btnSelectEmployee);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoinIn = findViewById(R.id.btnJoinIn);
    }

    private void initEvent() {
        btnLogin.setOnTouchListener(btnLoginTouchEvent);
        btnSelectInheritance.setOnClickListener(btnSelectInheritanceClickEvent);
        btnSelectEmployee.setOnClickListener(btnSelectEmployeeClickEvent);
        btnJoinIn.setOnClickListener(btnJoinInClickEvent);
    }

    private View.OnClickListener btnSelectInheritanceClickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("로그인구분", "기업");
            btnSelectInheritance.setBackground(getDrawable(R.drawable.btn_sortation_clicked));
            btnSelectEmployee.setBackground(getDrawable(R.drawable.btn_sortation_unclicked));
            classification = MainActivity.INHERITANCE;
        }
    };

    private View.OnClickListener btnSelectEmployeeClickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("로그인구분", "직원");
            btnSelectEmployee.setBackground(getDrawable(R.drawable.btn_sortation_clicked));
            btnSelectInheritance.setBackground(getDrawable(R.drawable.btn_sortation_unclicked));
            classification = MainActivity.EMPLOYEE;
        }
    };

    private View.OnClickListener btnJoinInClickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(), JoinInActivity.class));
        }
    };

    private View.OnTouchListener btnLoginTouchEvent = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d("현재행동", "누르는중");
                btnLogin.setBackground(getDrawable(R.drawable.btn_login_touched));
            }

            else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                Log.d("현재행동", "뗐다");
                btnLogin.setBackground(getDrawable(R.drawable.btn_login_non_touch));

                if (isLoginOk()) {
                    Toast.makeText(LoginActivity.this, ID + "님 환영합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(MainActivity.CLASSIFICATION, classification);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "로그인 정보가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        }
    };

    private boolean isLoginOk() {
        return edtLoginUserName.getText().toString().equals(ID) && edtLoginPassword.getText().toString().equals(PW);
    }
}
