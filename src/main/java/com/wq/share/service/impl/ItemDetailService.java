package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemDetailRequestDto;
import com.wq.share.dto.response.ItemDetailResponseDto;
import com.wq.share.remote.ItemRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品详情页
 */
@Service("wq.wangqin.itemDetail")
public class ItemDetailService extends AbstractService<ItemDetailRequestDto, ItemDetailResponseDto>{

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    protected BaseResponseDto<ItemDetailResponseDto> exec(BaseRequestDto<ItemDetailRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        ItemDetailRequestDto req = requestDto.getOperation();
        ItemDetailResponseDto resp = itemRemoteService.getItem(req.getItemCode(), requestDto.getCommon().getCompanyNo());
        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<ItemDetailRequestDto> parse(String requestData) {
        return  BaseDto.fromJson(requestData,  new TypeReference<BaseRequestDto<ItemDetailRequestDto>>(){});
    }

    @Override
    protected void validate(BaseRequestDto<ItemDetailRequestDto> requestDto) {
        //TODO
    }
}
