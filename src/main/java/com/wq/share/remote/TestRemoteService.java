package com.wq.share.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("testRemoteService")
public class TestRemoteService {

    @Autowired
    private RestTemplate restTemplate;

    public String remoteCall(){
        return restTemplate.postForObject("http://localhost:9080/api/test", null, String.class);
    }


}
