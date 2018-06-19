package com.wq.share.remote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("testRemoteService")
@Slf4j
public class TestRemoteService {

    @Autowired
    private RestTemplate restTemplate;

    public String remoteCall(){

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9080/api/test", String.class);
        HttpStatus httpStatus = entity.getStatusCode();
        String body = entity.getBody();
        log.info(String.format("httpStatus: %s, response body: %s", httpStatus.value(), body));
        return entity.getBody();
    }


}
