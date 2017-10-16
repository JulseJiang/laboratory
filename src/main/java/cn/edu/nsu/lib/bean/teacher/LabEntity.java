package cn.edu.nsu.lib.bean.teacher;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class LabEntity {
    /**
    * class_name: LabEntity
    * describe: 实验室实体类
    * creat_user: 蒋玖宏 julse@qq.com
    * creat_date: 2017/9/28
    * creat_time: 21:19
    **/
    private String id;
    private String name;
    private String describ;
    private String qq;
    private String address;

    /**
     * 将实验室实体类以Jason数组返回
     * @return
     */
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        HashMap map = new HashMap();
        map.put("id","123");
        map.toString();
        return "id" +id+
                "name" +name+
                "describ" +describ+
                "qq" + qq+
                "address"+address;
    }




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

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
