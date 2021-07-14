package com.example.employee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdopter extends RecyclerView.Adapter<EmployeeViewholder> {

    private final ArrayList<Employee> employeeList;
    private final itemClickListener itemClickListener;

    public EmployeeAdopter(ArrayList<Employee>employeeList,itemClickListener itemClickListener){
        this.employeeList=employeeList;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new EmployeeViewholder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeeViewholder holder, int position) {
        Employee employee=employeeList.get(position);
        holder.setData(employee,position);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }


}
