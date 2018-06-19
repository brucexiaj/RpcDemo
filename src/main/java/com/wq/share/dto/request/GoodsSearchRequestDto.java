package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoodsSearchRequestDto extends AbstractRequestDto {

    private String keyWord;

}
