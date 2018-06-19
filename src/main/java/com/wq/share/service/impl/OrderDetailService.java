package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

@Service("wq.wangqin.orderDetail")
public class OrderDetailService implements IService {
    @Override
    public BaseResponseDto<OrderDetailResponseDto> handle(String requestData) {
        return null;
    }
}
