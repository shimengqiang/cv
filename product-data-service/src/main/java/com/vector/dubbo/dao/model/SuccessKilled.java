package com.vector.dubbo.dao.model;

import java.util.Date;
import lombok.ToString;

@ToString
public class SuccessKilled {
    private Long seckillId;

    private Long userPhone;

    private Byte state;

    private Date createTime;

    public SuccessKilled() {
        super();
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}