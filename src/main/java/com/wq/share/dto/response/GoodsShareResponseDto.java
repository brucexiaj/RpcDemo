package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GoodsShareResponseDto extends AbstractResponseDto {

    private List<String> goodsImageList;
    private String goodDesc;
    private String shareToken;

}
