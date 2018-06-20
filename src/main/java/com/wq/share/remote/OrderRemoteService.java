package com.wq.share.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import com.wq.share.dto.response.entity.OrderEntity;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class OrderRemoteService {

    public final static String ORDER_REMOTE_URI = "http://localhost:8100";

    @Autowired
    private RestTemplate restTemplate;

    public MyHomeResponseDto getMyHomeList(String userId, String pageSize, String pageNo){

        log.info("==call remote url /api/orders/myHome ");
        String url = String.format("%s/api/orders/myHome?userId=%s&pageSize=%s&pageNo=%s",
                ORDER_REMOTE_URI, userId, pageSize, pageNo);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        log.info("==call remote url /api/orders/myHome, resp:{} ", entity);
        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        String remoteResp = entity.getBody();
        JsonResult<List<OrderEntity>> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<List<OrderEntity>>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }
        MyHomeResponseDto resp = new MyHomeResponseDto();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        resp.setOrderList(jsonResult.getData());
        return resp;
    }

    public OrderDetailResponseDto getOrderDetailList(String userId, String time, String pageSize, String pageNo){
        log.info("==call remote url /api/orders/detail ");
        String url = String.format("%s/api/orders/detail?userId=%s&time=%s&pageSize=%s&pageNo=%s",
                ORDER_REMOTE_URI, userId, time, pageSize, pageNo);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        log.info("==call remote url /api/orders/detail, resp:{} ", entity);
        if (entity.getStatusCode() != HttpStatus.OK){
            throw new ApplicationException(ReturnCode.REMOTE_EXCEPTION);
        }
        String remoteResp = entity.getBody();
        JsonResult<OrderDetailResponseDto> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<OrderDetailResponseDto>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }
        OrderDetailResponseDto resp = jsonResult.getData();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        return resp;
    }

}
