package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StartUpRequestDto extends AbstractRequestDto {

    private String type; //0对应今日上新，1对应全部商品

}
