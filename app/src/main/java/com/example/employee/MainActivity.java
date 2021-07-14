package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListener{

    private final ArrayList<Employee>employeeList=new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEditcardView;
    private EditText mEtName;
    private EditText mEtAge;
    private EditText mEtAddress;
    private Button mBtnDone;
    private EmployeeAdopter employeeAdopter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildEmployeeList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        employeeAdopter=new EmployeeAdopter(employeeList,this );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager((this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdopter);
    }

    private void buildEmployeeList() {
        for(int i=0;i<50;i++){
            Employee employee=new Employee("Sumit Kumar rai",i+1,"Jaynagar"+i);
            employeeList.add(employee);
        }
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        mEditcardView =findViewById(R.id.editCardView);
        mEtName=findViewById(R.id.etName);
        mEtAge=findViewById(R.id.etAge);
        mEtAddress=findViewById(R.id.etAddress);
        mBtnDone=findViewById(R.id.btnDone);

    }




    @Override
    public void onitemClicked(int position, Employee employee) {
        mEditcardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getname());
        mEtAge.setText(employee.getAge() + "");
        mEtAddress.setText(employee.getAddress());



        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditcardView.setVisibility(View.GONE);
                Employee new_employee=new Employee(mEtName.getText().toString(),Integer.parseInt(mEtAge.getText().toString()),mEtAddress.getText().toString());
                employeeList.set(position,new_employee);
                employeeAdopter.notifyItemChanged(position);
            }
        });

    }
}