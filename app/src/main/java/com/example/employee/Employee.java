package com.example.employee;

public class Employee {

    private String name;
    private int age;
    private String address;

    public Employee(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }

    public String  getname(){
        return  name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }

}
