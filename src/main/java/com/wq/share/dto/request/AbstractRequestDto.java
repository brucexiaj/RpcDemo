package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public  abstract class AbstractRequestDto implements Serializable {
    private String method;
    private String userId;
    private String companyNo;

    private String pageSize;
    private String pageNo;

}
