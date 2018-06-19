package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class AbstractResponseDto implements Serializable{

    private String pageSize;
    private String pageNo;
    private String companyNo;

}
