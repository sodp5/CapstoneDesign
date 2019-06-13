package com.example.albatimemanagement.inheritance;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.albatimemanagement.R;
import com.example.albatimemanagement.baseactivity.BaseActivity;
import com.example.albatimemanagement.inheritance.companydata.CompanyInfo;
import com.example.albatimemanagement.inheritance.companydata.InheritanceListDataManager;
import com.example.albatimemanagement.roadnameinfo.LoadRegionName;
import com.example.albatimemanagement.roadnameinfo.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class InheritanceAddCompanyActivity extends BaseActivity {
    private EditText edtAddCompanyName;
    private EditText edtAddCompanyTelNumber;
    private EditText edtAddCompanyDetailAddress;
    private EditText edtAddCompanyNumber;
    private Spinner spnSiDo;
    private Spinner spnSiGunGu;
    private Spinner spnCompanySalaryDay;
    private Button btnInheritanceAddCompanyComplete;

    private InheritanceListDataManager dm;

    private LoadRegionName loadRegionName;

    private ArrayList<Region> topRegionList;
    private ArrayList<Region> mdlRegionList;

    private String lastClickSiDo;
    private String lastClickSiGunGu;

    private String salaryDay = "1일";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inheritance_add_company);

        findViewById(R.id.ibtnInheritanceAddCompanyGoBack).setOnClickListener(v -> finish());

        initView();
        initInstance();
        initEvent();
        setSpinner();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(getColor(R.color.colorStatusAccount));
    }

    private void initView() {
        edtAddCompanyName = findViewById(R.id.edtAddCompanyName);
        edtAddCompanyTelNumber = findViewById(R.id.edtAddCompanyTelNumber);
        edtAddCompanyDetailAddress = findViewById(R.id.edtAddCompanyDetailAddress);
        edtAddCompanyNumber = findViewById(R.id.edtAddCompanyNumber);
        spnSiDo = findViewById(R.id.spnSiDo);
        spnSiGunGu = findViewById(R.id.spnSiGunGu);
        spnCompanySalaryDay = findViewById(R.id.spnCompanySalaryDay);
        btnInheritanceAddCompanyComplete = findViewById(R.id.btnInheritanceAddCompanyComplete);
    }

    private void initInstance() {
        dm = InheritanceListDataManager.getInstance();
        topRegionList = new ArrayList<>();
        mdlRegionList = new ArrayList<>();
        loadRegionName = new LoadRegionName();
    }

    private void initEvent() {
        btnInheritanceAddCompanyComplete.setOnClickListener(btnInheritanceAddCompanyCompleteClickListener);
    }

    private void setSpinner() {
        topRegionList = loadRegionName.getRegionArray();
        setSpnSiDo();
        setSpnCompanySalaryDay();
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
                Log.d("마지막클릭은", lastClickSiDo);

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

    private void setSpnCompanySalaryDay() {
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item);
        for (int i = 1; i <= 28; i++) {
            dayAdapter.add(i + "일");
        }
        spnCompanySalaryDay.setAdapter(dayAdapter);
    }

    private View.OnClickListener btnInheritanceAddCompanyCompleteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String cantCompleteMsg = "";

            String companyName = edtAddCompanyName.getText().toString();
            String presidentName = ((EditText)findViewById(R.id.edtAddCompanyPresidentName)).getText().toString();
            String companyTelNumber = edtAddCompanyTelNumber.getText().toString();
            String companyDetailAddress = edtAddCompanyDetailAddress.getText().toString();
            String companyNumber = edtAddCompanyNumber.getText().toString();

            spnCompanySalaryDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    salaryDay = (String)adapterView.getItemAtPosition(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            if (companyName.equals(""))
                cantCompleteMsg = "기업 이름을 입력 해 주세요.";
            else if (presidentName.equals(""))
                cantCompleteMsg = "대표 이름을 입력 해 주세요.1";
            else if (companyTelNumber.equals(""))
                cantCompleteMsg = "전화번호를 기입 해 주세요.";
            else if (companyDetailAddress.equals(""))
                cantCompleteMsg = "상세 주소를 입력 해 주세요.";
            else if (companyNumber.equals(""))
                cantCompleteMsg = "사업자 번호를 입력 해 주세요.";
            else {
                String address = lastClickSiDo + " " + lastClickSiGunGu + " " + companyDetailAddress;
                dm.addCompany(new CompanyInfo(companyName, presidentName, salaryDay, address));
                finish();
            }
            Toast.makeText(InheritanceAddCompanyActivity.this, cantCompleteMsg, Toast.LENGTH_SHORT).show();
        }
    };
}
