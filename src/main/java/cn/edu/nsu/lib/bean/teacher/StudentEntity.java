package cn.edu.nsu.lib.bean.teacher;

/**
 * 学生实体类
 */
public class StudentEntity {
    /**
     * 学号
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年级
     */
    private String grade;
    /**
     * 时间
     */
    private String time;
    /**
     * 实验室
     */
    private String lab_name;
    /**
     * 专业
     */
    private String major;
    /**
     * 辅导员
     */
    private String instuctor;
    /**
     * 电话
     */
    private String tel;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getInstuctor() {
        return instuctor;
    }

    public void setInstuctor(String instuctor) {
        this.instuctor = instuctor;
    }
}
