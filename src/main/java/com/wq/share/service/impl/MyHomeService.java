package com.wq.share.service.impl;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.MyHomeRequestDto;
import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.remote.OrderRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 我的页面
 */
@Service("wq.wangqin.myHome")
public class MyHomeService implements IService {

    @Autowired
    private OrderRemoteService orderRemoteService;

    @Override
    public BaseResponseDto<MyHomeResponseDto> handle(String requestData) {

        //1 反序列化
        BaseRequestDto<MyHomeRequestDto> requestDto = BaseDto.fromJson(requestData, BaseRequestDto.class);
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        MyHomeRequestDto req = requestDto.getOperation();
        MyHomeResponseDto resp = orderRemoteService.getMyHomeList(requestDto.getCommon().getUserId(),
                                                                  req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);

        return responseDto;
    }
}
