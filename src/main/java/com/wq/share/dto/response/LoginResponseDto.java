package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto extends AbstractResponseDto {

    private String userId;
    private String userNick;
    private String userAvtar;



}
