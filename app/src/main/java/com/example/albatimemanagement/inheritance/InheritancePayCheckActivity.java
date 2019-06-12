package com.example.albatimemanagement.inheritance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.paychecklist.InheritancePayCheckArrayAdapter;
import com.example.albatimemanagement.inheritance.paychecklist.InheritancePayCheckItem;

import java.util.ArrayList;

public class InheritancePayCheckActivity extends BaseActivity {
    private InheritancePayCheckArrayAdapter adapter;
    private ArrayList<InheritancePayCheckItem> list;
    private ListView lvPayList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_pay_check);

        findViewById(R.id.ibtnInheritancePayCheckGoBack).setOnClickListener(v -> finish());

        initView();
        initInstance();

        for (int i = 0; i < intent.getIntExtra("size", 0); i++) {
            list.add(new InheritancePayCheckItem(intent.getStringExtra("member" + i), "12시", "8,350원", "102,000원"));
        }
//        list.add(new InheritancePayCheckItem("안경문", "12시", "8,350원", "102,000원"));
//        list.add(new InheritancePayCheckItem("김태기", "12시", "8,350원", "102,000원"));
//        list.add(new InheritancePayCheckItem("이 헌", "12시", "8,350원", "102,000원"));
//        list.add(new InheritancePayCheckItem("남다연", "12시", "8,350원", "102,000원"));

        lvPayList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusPaycheck));
    }

    private void initView() {
        lvPayList = findViewById(R.id.lvInheritancePayList);
    }

    private void initInstance() {
        list = new ArrayList<>();
        adapter = new InheritancePayCheckArrayAdapter(getApplicationContext(), list);
        intent = getIntent();
    }
}
