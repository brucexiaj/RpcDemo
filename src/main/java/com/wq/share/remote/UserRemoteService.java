package com.wq.share.remote;

import com.wq.share.dto.request.LoginRequestDto;
import com.wq.share.dto.response.LoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRemoteService {

    @Autowired
    private RestTemplate restTemplate;


    public LoginResponseDto getUserInfo(LoginRequestDto req){
           
           


        return null;
    }


}
