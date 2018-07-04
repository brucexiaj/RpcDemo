package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.OrderDetailRequestDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import com.wq.share.remote.OrderRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单详情页
 */
@Service("wq.wangqin.orderDetail")
public class OrderDetailService extends AbstractService<OrderDetailRequestDto, OrderDetailResponseDto> {

    @Autowired
    private OrderRemoteService orderRemoteService;


    @Override
    protected BaseResponseDto<OrderDetailResponseDto> exec(BaseRequestDto<OrderDetailRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        OrderDetailRequestDto req = requestDto.getOperation();
        OrderDetailResponseDto resp = orderRemoteService.getOrderDetailList(requestDto.getCommon().getUserId(),
                req.getTime(), req.getPageSize(), req.getPageNo());
        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<OrderDetailRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<OrderDetailRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<OrderDetailRequestDto> requestDto) {
       //TODO
    }
}
