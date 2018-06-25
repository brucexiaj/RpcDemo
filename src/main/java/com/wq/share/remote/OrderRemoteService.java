package com.wq.share.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderRemoteService extends AbstractRemoteService{

    public MyHomeResponseDto getMyHomeList(String userId, String pageSize, String pageNo){

        String url = String.format("%s/api/orders/myHome?userId=%s&pageSize=%s&pageNo=%s",
                getErpRemoteUri(), userId, pageSize, pageNo);
        String remoteResp = remoteGetCall(url);

        JsonResult<MyHomeResponseDto> jsonResult = BaseDto.fromJson(remoteResp,
                new TypeReference<JsonResult<MyHomeResponseDto>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }

        MyHomeResponseDto resp = jsonResult.getData();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        return resp;
    }

    public OrderDetailResponseDto getOrderDetailList(String userId, String time, String pageSize, String pageNo){
        String url = String.format("%s/api/orders/detail?userId=%s&time=%s&pageSize=%s&pageNo=%s",
                getErpRemoteUri(), userId, time, pageSize, pageNo);

        String remoteResp = remoteGetCall(url);
        JsonResult<OrderDetailResponseDto> jsonResult = BaseDto.fromJson(remoteResp,
                new TypeReference<JsonResult<OrderDetailResponseDto>>() {});

        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }

        OrderDetailResponseDto resp = jsonResult.getData();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        return resp;
    }

}
