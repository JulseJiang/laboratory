package cn.edu.nsu.lib.bean.admin;

import java.math.BigInteger;

public class Prize {

    private int	id ; //奖项主键
    private BigInteger owner;//所属人学号
    private String owner_name;//所属人名字
    private String name;//获奖名字
    private String category; //学科竞赛 课外活动
    private String region;//国家级 省级什么的
    private String rank;//获奖等级
    private String url;//奖项官网
    private String time;//获奖时间
    private boolean check;//审核结果

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
