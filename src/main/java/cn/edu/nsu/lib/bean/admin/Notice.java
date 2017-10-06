package cn.edu.nsu.lib.bean.admin;

import java.math.BigInteger;

public class Notice {

    private long Notice_id;
    private long lab_id;
    private BigInteger publisher_id;
    private String time;
    private String file_name;
    private String title;
    private String content;
    private String file_path;

    public long getNotice_id() {
        return Notice_id;
    }

    public void setNotice_id(long notice_id) {
        Notice_id = notice_id;
    }


    public long getLab_id() {
        return lab_id;
    }

    public void setLab_id(long lab_id) {
        this.lab_id = lab_id;
    }

    public BigInteger getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(BigInteger publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
