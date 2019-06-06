package com.example.albatimemanagement.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.inheritance.paychecklist.InheritancePayCheckArrayAdapter;
import com.example.albatimemanagement.inheritance.paychecklist.InheritancePayCheckItem;

import java.util.ArrayList;

public class InheritancePayCheckActivity extends AppCompatActivity {
    private InheritancePayCheckArrayAdapter adapter;
    private ArrayList<InheritancePayCheckItem> list;
    private ListView lvPayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_pay_check);

        lvPayList = findViewById(R.id.lvInheritancePayList);

        list = new ArrayList<>();
        list.add(new InheritancePayCheckItem("안경문", "12시", "8,350원", "102,000원"));
        list.add(new InheritancePayCheckItem("김태기", "12시", "8,350원", "102,000원"));
        list.add(new InheritancePayCheckItem("이 헌", "12시", "8,350원", "102,000원"));
        list.add(new InheritancePayCheckItem("남다연", "12시", "8,350원", "102,000원"));
        adapter = new InheritancePayCheckArrayAdapter(getApplicationContext(), list);

        lvPayList.setAdapter(adapter);
    }
}
