package com.wq.share.remote;

import com.wq.share.OneShareApplicationConfig;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.enums.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Slf4j
public abstract class AbstractRemoteService {

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected OneShareApplicationConfig oneShareApplicationConfig;

    protected String getErpRemoteUri(){
        return oneShareApplicationConfig.getErpRemoteURI();
    }

    protected String remoteGetCall(String url) {
        url = String.format("%s&reqNo=%s", url, UUID.randomUUID());
        log.info("==call remote url {} ", url);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        log.info("==call remote url {}, result : {}", url , BaseDto.toString(entity));
        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        return entity.getBody();
    }

    protected String remotePostCall(String url, String params){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<>(params, headers);
        log.info("==call remote url {}, params: {} ", url, params);
        ResponseEntity<String> entity = restTemplate.postForEntity(url, formEntity, String.class);
        log.info("==call remote url {}, result : {}", url , BaseDto.toString(entity));
        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        return entity.getBody();
    }

}
