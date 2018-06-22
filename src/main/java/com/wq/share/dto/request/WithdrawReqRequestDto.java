package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawReqRequestDto extends AbstractRequestDto {

    private String alipayAccount;
    private String realName;

}
