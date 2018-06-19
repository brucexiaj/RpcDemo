package com.wq.share.remote;

import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
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
public class UserRemoteService {


    @Autowired
    private RestTemplate restTemplate;

    //TODO 配置化
    public final static String USER_REMOTE_URI = "http://localhost:8100";
    public static final String HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG = "http://img.haihu.com/wq_logo.jpg";

    public LoginResponseDto getUserInfo(LoginRequestDto req){
        log.info("==call remote url /api/share/user/login ");
    	String url = String.format("%s/api/share/user/login?type=%s&mobileNo=%s&checkCode=%s&thirdPartyId=%s&thirdPartyAvtar=%s",
                USER_REMOTE_URI, req.getType(), req.getMobileNo(), req.getCheckCode(), req.getThirdPartyId(), req.getThirdPartyAvtar());

        ResponseEntity<AuthUserDO> entity = restTemplate.getForEntity(url, AuthUserDO.class);
        log.info("==call remote url /api/share/user/login, result : {}", BaseDto.toString(entity));

        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        AuthUserDO authUserDO = entity.getBody();
        LoginResponseDto resp = new LoginResponseDto();
        resp.setCompanyNo(authUserDO.getCompanyNo());
        resp.setUserNick(authUserDO.getName());
        resp.setUserId(authUserDO.getUserNo());
        resp.setUserAvtar(HTTP_IMG_HAIHU_COM_WQ_LOGO_JPG);
        return resp;
    }


}
