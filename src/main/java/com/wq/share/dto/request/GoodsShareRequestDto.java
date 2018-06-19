package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsShareRequestDto extends AbstractRequestDto {

    private String goodsId;
    private String skuId;

}
