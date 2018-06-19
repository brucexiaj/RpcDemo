package com.wq.share.remote;

import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserRemoteService {

    @Autowired
    private RestTemplate restTemplate;
    

    public LoginResponseDto getUserInfo(LoginRequestDto req){

        ResponseEntity<LoginResponseDto> entity = restTemplate.getForEntity("http://localhost:8100/share/user/login", LoginResponseDto.class);
        HttpStatus httpStatus = entity.getStatusCode();
        LoginResponseDto loginResponseDto = entity.getBody();
        log.info(String.format("httpStatus: %s, response body: %s", httpStatus.value(), loginResponseDto));
        return entity.getBody();
        
    }


}
