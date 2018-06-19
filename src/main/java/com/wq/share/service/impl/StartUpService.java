package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.StartUpRequestDto;
import com.wq.share.dto.response.StartUpResponseDto;
import com.wq.share.remote.ItemRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * 首页
 */
@Service("wq.wangqin.startUp")
public class StartUpService implements IService{


    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    public BaseResponseDto<StartUpResponseDto> handle(String requestData) {
        //1 反序列化
        BaseRequestDto<StartUpRequestDto> requestDto = BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<StartUpRequestDto>>(){});
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        StartUpRequestDto req = requestDto.getOperation();
        StartUpResponseDto resp = itemRemoteService.getStartUpItems(req.getType(),
                requestDto.getCommon().getCompanyNo(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);

        return responseDto;
    }
}
