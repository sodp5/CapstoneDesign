package com.example.albatimemanagement.employee;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.roadnameinfo.LoadRegionName;
import com.example.albatimemanagement.roadnameinfo.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class EmployeeAccountFindCompanyActivity extends BaseActivity {
    private String lastClickSiDo, lastClickSiGunGu;
    private ArrayList<Region> topRegionList;
    private ArrayList<Region> mdlRegionList;
    private LoadRegionName loadRegionName;

    private Spinner spnSiDo;
    private Spinner spnSiGunGu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_account_find_company);

        findViewById(R.id.ibtnEmployeeAccountFindCompanyGoBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnEmployeeFindCompanyComplete).setOnClickListener(v -> finish());
        findViewById(R.id.ivCompanySearch).setOnClickListener(v -> findViewById(R.id.relCompanyInfo).setVisibility(View.VISIBLE));

        spnSiDo = findViewById(R.id.spinnerCityState);
        spnSiGunGu = findViewById(R.id.spinnerCityDistrictBorough);
        loadRegionName = new LoadRegionName();

        setSpinner();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }

    private void setSpinner() {
        topRegionList = loadRegionName.getRegionArray();
        setSpnSiDo();
    }

    private void setSpnSiDo() {
        HashMap<String, Integer> siDoNameMap = new LinkedHashMap<>();

        for (int i = 0; i < topRegionList.size(); i++)
            siDoNameMap.put(topRegionList.get(i).getValue(), i);

        Object[] objArray = siDoNameMap.keySet().toArray();
        String[] siDoNameList = Arrays.copyOf(objArray, objArray.length, String[].class);

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, siDoNameList);

        spnSiDo.setAdapter(regionAdapter);
        spnSiDo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lastClickSiDo = (String) adapterView.getSelectedItem();

                setSpnSiGunGu(topRegionList.get(siDoNameMap.get(lastClickSiDo)).getCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setSpnSiGunGu(String code) {
        final ArrayList<String> siGunGuNameList= new ArrayList<>();

        mdlRegionList = loadRegionName.getRegionArray(Integer.parseInt(code));

        for(Region r : mdlRegionList)
            siGunGuNameList.add(r.getValue());

        ArrayAdapter<String> regionAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, siGunGuNameList);

        spnSiGunGu.setAdapter(regionAdapter);
        spnSiGunGu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lastClickSiGunGu = siGunGuNameList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
