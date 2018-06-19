package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto extends AbstractRequestDto {

     private String type;
     private String mobileNo;
     private String checkCode;
     private String thirdPartyId;
     private String thirdPartyToken;
     private String thirdPartyUserNick;
     private String thirdPartyAvtar;

}
