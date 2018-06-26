package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawReqResponse extends AbstractResponseDto {

    private String withdrawStatus;
    private String withdrawMessage;

}
