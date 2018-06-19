package com.wq.share.dto.response.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OrderDetailEntity implements Serializable {

    private String orderNo;
    private String orderTime;
    private String commission;
    private String realPay;
    private String imgUrl;

}
