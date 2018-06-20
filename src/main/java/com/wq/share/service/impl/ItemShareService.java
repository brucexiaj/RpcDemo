package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemShareRequestDto;
import com.wq.share.dto.response.ItemShareResponseDto;
import com.wq.share.remote.ItemRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分享
 */
@Service("wq.wangqin.share")
public class ItemShareService implements IService{

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    public BaseResponseDto<ItemShareResponseDto> handle(String requestData) {

        //1 反序列化
        BaseRequestDto<ItemShareRequestDto> requestDto = BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<ItemShareRequestDto>>(){});
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        ItemShareRequestDto req = requestDto.getOperation();
        ItemShareResponseDto resp = itemRemoteService.getShareItemInfo(req.getItemCode(),
                requestDto.getCommon().getCompanyNo(), requestDto.getCommon().getUserId());

        responseDto.setOperation(resp);

        return responseDto;
    }

}
