package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ItemDetailResponseDto extends AbstractResponseDto {

    private String title;
    private String itemCode;
    private String itemDesc;
    private String price;
    private String originPrice;
    private String sharePrice;
    private List<String> imgList;

}
