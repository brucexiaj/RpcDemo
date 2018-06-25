package com.wq.share.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.dto.JsonResult;
import org.springframework.stereotype.Service;

import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;
import com.wq.share.remote.dto.AuthUserDO;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserRemoteService extends AbstractRemoteService{

    public static final String HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG = "http://img.haihu.com/wq_logo.jpg";

    public LoginResponseDto getUserInfo(LoginRequestDto req){

    	String url = String.format("%s/share/user/login?type=%s&mobileNo=%s&checkCode=%s&thirdPartyId=%s&thirdPartyUnionid=%s&thirdPartyAvtar=%s",
                getErpRemoteUri(), req.getType(), req.getMobileNo(), req.getCheckCode(), req.getThirdPartyId(), req.getThirdPartyUnionid(), req.getThirdPartyAvtar());

        String remoteResp = remoteGetCall(url);

        JsonResult<AuthUserDO> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<AuthUserDO>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_USER_EXCEPTION, jsonResult.getMsg());
        }
        //TODO refactor globalShop的返回字段需要重构
        AuthUserDO authUserDO = jsonResult.getData();
        LoginResponseDto resp = new LoginResponseDto();
        resp.setCompanyNo(authUserDO.getCompanyNo());
        resp.setUserNick(authUserDO.getName());
        resp.setUserId(authUserDO.getUserNo());
        resp.setUserAvtar(HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG);

        return resp;
    }




}
