package edu.ustb.yaolegou.entity;

import java.util.Date;

public class Banner {
    private int id;
    private String image;
    private String bgcolor;

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    private int istingyong;
    private String beizhu;
    private Date CreateTime;

    private String href;

    public int getIstingyong() {
        return istingyong;
    }

    public void setIstingyong(int istingyong) {
        this.istingyong = istingyong;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }



    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }
}
