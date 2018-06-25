package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemShareRequestDto;
import com.wq.share.dto.response.ItemShareResponseDto;
import com.wq.share.remote.ItemRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分享
 */
@Service("wq.wangqin.share")
public class ItemShareService extends AbstractService<ItemShareRequestDto, ItemShareResponseDto>{

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    protected BaseResponseDto<ItemShareResponseDto> exec(BaseRequestDto<ItemShareRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        ItemShareRequestDto req = requestDto.getOperation();
        ItemShareResponseDto resp = itemRemoteService.getShareItemInfo(req.getItemCode(),
                requestDto.getCommon().getCompanyNo(), requestDto.getCommon().getUserId());
        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<ItemShareRequestDto> parse(String requestData) {
        return BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<ItemShareRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<ItemShareRequestDto> requestDto) {
        //TODO
    }

}
