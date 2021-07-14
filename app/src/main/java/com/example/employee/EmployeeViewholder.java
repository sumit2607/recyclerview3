package com.example.employee;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewholder extends RecyclerView.ViewHolder {
    private TextView mtvName;
    private TextView mtvage;
    private ImageView mtvEdit;
    private TextView mtvaddress;
    itemClickListener itemClickListener;

    public EmployeeViewholder(@NonNull  View itemView,itemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvage=itemView.findViewById(R.id.tvAge);
        mtvEdit=itemView.findViewById(R.id.ivEdit);
        mtvaddress=itemView.findViewById(R.id.tvAddress);
    }

    public void setData(Employee employee,int po){
        mtvName.setText(employee.getname());
        mtvage.setText(employee.getAge() +" ");
        mtvaddress.setText(employee.getAddress()  );

        mtvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onitemClicked(getAdapterPosition(),employee);
            }
        });
    }


}
