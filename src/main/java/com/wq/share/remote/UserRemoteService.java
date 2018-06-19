package com.wq.share.remote;

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
    

    public AuthUserDO getUserInfo(LoginRequestDto req){

    	StringBuilder requestUrl = new StringBuilder("http://localhost:8100/share/user/loginz?wxOpenId=");
    	requestUrl.append(req.getThirdPartyId());
        ResponseEntity<AuthUserDO> entity = restTemplate.getForEntity(requestUrl.toString(), AuthUserDO.class);
        HttpStatus httpStatus = entity.getStatusCode();
        AuthUserDO authUserDO = entity.getBody();
        log.info(String.format("httpStatus: %s, response body: %s", httpStatus.value(), authUserDO));
        return entity.getBody();
        
    }


}
