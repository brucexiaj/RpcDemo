package com.wq.share.dto.response;

import com.wq.share.dto.response.entity.SkuEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GoodsDetailResponseDto extends AbstractResponseDto {

    private String title;
    private List<String>  sizeList;
    private List<SkuEntity> skuList;

}
