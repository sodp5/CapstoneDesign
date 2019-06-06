package com.example.albatimemanagement.employee.paychecklist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.albatimemanagement.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayCheckArrayAdapter extends ArrayAdapter<EmployeePayCheckItem> {
    private Context context;
    private List mList;

    class PayCheckViewHolder {
        private TextView tvItemEmployeeStackTime;
        private TextView tvItemEmployeePoh;
        private TextView tvItemEmployeeSalaryDay;
        private TextView tvItemEmployeeSom;
    }


    // VocaAdapter를 초기화하기 위한 생성자로 아규먼트로 전달받은 context와 list를 내부 저장 공간에 저장합니다.
    public EmployeePayCheckArrayAdapter(Context context, // 레이아웃 XML 파일을 뷰(view) 객체로 바꾸는데 사용할 컨택스트(Context)
                                        List<EmployeePayCheckItem> list // ListView에 보여줄 데이터인 Voca 객체 리스트
    ) {
        super(context, 0, list);

        this.context = context;
        this.mList = list;
    }

    // ListView의  한 줄(row)이 렌더링(rendering)될 때 호출되는 메소드로 row를 위한 view를 리턴합니다.
    // 한 줄(Row)를 위한 뷰(View)를 재사용하여 ListIView의 효율성을 올립니다.
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parentViewGroup) {
        View rowView = convertView; // 코드 가독성을 위해서 rowView 변수를 사용합니다.
        PayCheckViewHolder viewHolder;

        // 기존에 생성했던 뷰라면 재사용하고 그렇지 않으면 XML 파일을 새로 view 객체로 변환합니다.
        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.item_employee_pay_list, parentViewGroup, false);


            // view holder의 구성 요소의 값과 한 줄을 구성하는 레이아웃을 연결함.
            //
            // rowView(=R.layout.list_item)에서 주어진 ID(R.id.textview_list_english)를 가진 뷰를 찾습니다.
            // 찾는 뷰의 타입에 따라 findViewById 리턴 결과를 타입 변환해줘야 합니다.
            viewHolder = new PayCheckViewHolder();
            viewHolder.tvItemEmployeeStackTime = rowView.findViewById(R.id.tvItemEmployeeStackTime);
            viewHolder.tvItemEmployeePoh = rowView.findViewById(R.id.tvItemEmployeePoh);
            viewHolder.tvItemEmployeeSalaryDay = rowView.findViewById(R.id.tvItemEmployeeSalaryDay);
            viewHolder.tvItemEmployeeSom = rowView.findViewById(R.id.tvItemEmployeeSom);

            rowView.setTag(viewHolder);
        } else {
            viewHolder = (PayCheckViewHolder) rowView.getTag();
        }


        // 태그 분석을 위한 코드 시작
        String Tag = rowView.getTag().toString();
        int idx = Tag.indexOf("@");
        String tag = Tag.substring(idx + 1);


        //Voca 객체 리스트의 position 위치에 있는 Voca 객체를 가져옵니다.
        EmployeePayCheckItem employeePayCheckItem = (EmployeePayCheckItem) mList.get(position);

        //현재 선택된 Vocal 객체를 화면에 보여주기 위해서 앞에서 미리 찾아 놓은 뷰에 데이터를 집어넣습니다.
        viewHolder.tvItemEmployeeStackTime.setText(employeePayCheckItem.getStackTime());
        viewHolder.tvItemEmployeePoh.setText(employeePayCheckItem.getPoh());
        viewHolder.tvItemEmployeeSalaryDay.setText(employeePayCheckItem.getSalaryDay());
        viewHolder.tvItemEmployeeSom.setText(employeePayCheckItem.getSom());

        // 화면에 보여질 뷰를 리턴하여 ListView의 특정 줄로 보여지게 합니다.
        //본 예제에서는 5개의 TextView 구성되어 있습니다.
        return rowView;
    }

    public void setList(ArrayList<EmployeePayCheckItem> p) {
        mList = p;
    }
}
