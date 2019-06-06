package com.example.albatimemanagement.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.albatimemanagement.R;

public class InheritancePayCheckSelectActivity extends AppCompatActivity {
    private ListView lvInheritancePayCheck;
    private ArrayAdapter<String> inheritanceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_pay_check_select);

        initView();

        inheritanceListAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.item_inheritance_name_list);
        inheritanceListAdapter.add("(주)PJW");
        inheritanceListAdapter.add("(주)KWS");
        inheritanceListAdapter.add("(주)JWS");



        lvInheritancePayCheck.setAdapter(inheritanceListAdapter);
    }

    private void initView() {
        lvInheritancePayCheck = findViewById(R.id.lvInheritancePayCheck);
    }

}
