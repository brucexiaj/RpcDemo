package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto extends AbstractRequestDto {

     private String type;  //mobile/wechat

     private String mobileNo; //手机号
     private String checkCode; //密码

     private String thirdPartyId; //openId
     private String thirdPartyUnionid;
     private String thirdPartyToken;
     private String thirdPartyUserNick; //传回去
     private String thirdPartyAvtar;

}
