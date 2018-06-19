package com.wq.share.dto.response.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GoodsEntity implements Serializable {
    private String title;
    private String goodsId;
    private String price;
    private String originPrice;
    private String imgUrl;
}
