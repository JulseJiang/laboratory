package cn.edu.nsu.lib.bean.admin;

import java.math.BigInteger;

public class Student_check {

    private BigInteger student_id;
    private String name;
    private String date;
    private boolean register;


    public BigInteger getStudent_id() {
        return student_id;
    }

    public void setStudent_id(BigInteger student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

}
