package com.example.albatimemanagement.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.employee.paychecklist.EmployeePayCheckArrayAdapter;
import com.example.albatimemanagement.employee.paychecklist.EmployeePayCheckItem;

import java.util.ArrayList;

public class EmployeePayCheckActivity extends BaseActivity {
    private EmployeePayCheckArrayAdapter adapter;
    private ListView lvEmployeePayList;
    private ArrayList<EmployeePayCheckItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_pay_check_select);

        findViewById(R.id.ibtnEmployeePayCheckSelectGoBack).setOnClickListener(v -> finish());

        lvEmployeePayList = findViewById(R.id.lvEmployeePayList);
        list = new ArrayList<>();

        list.add(new EmployeePayCheckItem("10시간", "8,350원", "1일", "307,080원", "(주)PJW"));
        list.add(new EmployeePayCheckItem("12시간", "8,500원", "10일", "327,240원", "(주)JSD"));

        adapter = new EmployeePayCheckArrayAdapter(getApplicationContext(), list);

        lvEmployeePayList.setAdapter(adapter);
        setListViewHeightBasedOnChildren(lvEmployeePayList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusPaycheck));
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


}
