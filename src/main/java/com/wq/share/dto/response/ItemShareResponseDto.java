package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ItemShareResponseDto extends AbstractResponseDto {

    private List<String> itemImgList;
    private String itemDesc;

}
