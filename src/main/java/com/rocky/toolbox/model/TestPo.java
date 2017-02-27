package com.rocky.toolbox.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by rocky on 17/2/27.
 */
public class TestPo {
    private Integer id;


    private Long activityId;


    private Integer position;


    private String title;


    private String cake;


    private Boolean isOk;


    private Float fuDian;


    private Double doubleNum;


    private BigDecimal whatYou;


    private Timestamp createdAt;


    private Date letDate;


    private byte[] pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCake() {
        return cake;
    }

    public void setCake(String cake) {
        this.cake = cake;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public Float getFuDian() {
        return fuDian;
    }

    public void setFuDian(Float fuDian) {
        this.fuDian = fuDian;
    }

    public Double getDoubleNum() {
        return doubleNum;
    }

    public void setDoubleNum(Double doubleNum) {
        this.doubleNum = doubleNum;
    }

    public BigDecimal getWhatYou() {
        return whatYou;
    }

    public void setWhatYou(BigDecimal whatYou) {
        this.whatYou = whatYou;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLetDate() {
        return letDate;
    }

    public void setLetDate(Date letDate) {
        this.letDate = letDate;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
