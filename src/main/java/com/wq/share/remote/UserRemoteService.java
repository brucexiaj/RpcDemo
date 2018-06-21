package com.wq.share.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;
import com.wq.share.remote.dto.AuthUserDO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRemoteService extends AbstractRemoteService{

    public static final String HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG = "http://img.haihu.com/wq_logo.jpg";

    public LoginResponseDto getUserInfo(LoginRequestDto req){
        log.info("==call remote url /share/user/login ");
    	String url = String.format("%s/share/user/login?type=%s&mobileNo=%s&checkCode=%s&thirdPartyId=%s&thirdPartyAvtar=%s",
                ERP_REMOTE_URI, req.getType(), req.getMobileNo(), req.getCheckCode(), req.getThirdPartyId(), req.getThirdPartyAvtar());

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        log.info("==call remote url /api/share/user/login, result : {}", BaseDto.toString(entity));

        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        String remoteResp = entity.getBody();
        JsonResult<AuthUserDO> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<AuthUserDO>>() {});

        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_USER_EXCEPTION, jsonResult.getMsg());
        }

        AuthUserDO authUserDO = jsonResult.getData();
        LoginResponseDto resp = new LoginResponseDto();
        resp.setCompanyNo(authUserDO.getCompanyNo());
        resp.setUserNick(authUserDO.getName());
        resp.setUserId(authUserDO.getUserNo());
        resp.setUserAvtar(HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG);
        return resp;
    }


}
