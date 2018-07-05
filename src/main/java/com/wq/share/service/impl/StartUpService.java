package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.StartUpRequestDto;
import com.wq.share.dto.response.StartUpResponseDto;
import com.wq.share.remote.ItemRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 首页
 */
@Service("wq.wangqin.startUp")
public class StartUpService extends AbstractService<StartUpRequestDto,StartUpResponseDto>{

    @Autowired
    private ItemRemoteService itemRemoteService;


    @Override
    protected BaseResponseDto<StartUpResponseDto> exec(BaseRequestDto<StartUpRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        StartUpRequestDto req = requestDto.getOperation();
        StartUpResponseDto resp = itemRemoteService.getStartUpItems(req.getType(),
                requestDto.getCommon().getCompanyNo(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<StartUpRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<StartUpRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<StartUpRequestDto> requestDto) {
        //TODO
    }
}
