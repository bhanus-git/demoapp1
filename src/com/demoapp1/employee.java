package com.demoapp1;

import java.util.List;

public class employee {

    private int empid;
    private String ename;
    private String dept;
    private double sal;
   private List<String > email;

    void Employee()
    {

    }

    public employee(int empid, String ename, String dept, double sal, List<String> email) {
        this.empid = empid;
        this.ename = ename;
        this.dept = dept;
        this.sal = sal;
        this.email = email;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public  String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "employee{" +
                "empid=" + empid +
                ", ename='" + ename + '\'' +
                ", dept='" + dept + '\'' +
                ", sal=" + sal +
                ", email=" + email +
                '}';
    }
}
