package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.OrderDetailRequestDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import com.wq.share.remote.OrderRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单详情页
 */
@Service("wq.wangqin.orderDetail")
public class OrderDetailService implements IService {

    @Autowired
    private OrderRemoteService orderRemoteService;

    @Override
    public BaseResponseDto<OrderDetailResponseDto> handle(String requestData) {
        //1 反序列化
        BaseRequestDto<OrderDetailRequestDto> requestDto = BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<OrderDetailRequestDto>>(){});
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        OrderDetailRequestDto req = requestDto.getOperation();
        OrderDetailResponseDto resp = orderRemoteService.getOrderDetailList(requestDto.getCommon().getUserId(),
                req.getTime(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);

        return responseDto;
    }
}
