package com.wq.share.dto.response.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SkuEntity implements Serializable {

    private String skuId;
    private String price;
    private String originPrice;
    private String sharePrice;
    private String goodsDesc;
    private List<String> imgList;

}
