package com.wq.share.dto.response.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderEntity implements Serializable {

    private String time;
    private String orderCount;
    private String commission;

}
