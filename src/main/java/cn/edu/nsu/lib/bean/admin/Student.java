package cn.edu.nsu.lib.bean.admin;

import java.math.BigInteger;

public class Student {
    /**
     * 学号存取用这个类型 ：BigInteger
     * 前端数据类型用text只输入数字的时候可以自动转换为整形数据进行存入
     * String类型可以获取到前端页面数据类型为date的数据
     *
     */
    private BigInteger student_id;//学号
    private String name;//名字
    private String gender;//性别
    private int grade;//年纪
    private String time;//加实验室时间
    private long lab_id;//实验室id
    private long major_id;//专业id
    private String major;//
    private String instructor;//
    private BigInteger tel;//

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getLab_id() {
        return lab_id;
    }

    public void setLab_id(long lab_id) {
        this.lab_id = lab_id;
    }

    public long getMajor_id() {
        return major_id;
    }

    public void setMajor_id(long major_id) {
        this.major_id = major_id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public BigInteger getTel() {
        return tel;
    }

    public void setTel(BigInteger tel) {
        this.tel = tel;
    }


}
