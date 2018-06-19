package com.wq.share.service.impl;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemDetailRequestDto;
import com.wq.share.dto.response.ItemDetailResponseDto;
import com.wq.share.remote.ItemRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品详情页
 */
@Service("wq.wangqin.itemDetail")
public class ItemDetailService implements IService {

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    public BaseResponseDto<ItemDetailResponseDto> handle(String requestData) {

        //1 反序列化
        BaseRequestDto<ItemDetailRequestDto> requestDto = BaseDto.fromJson(requestData, BaseRequestDto.class);
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        ItemDetailRequestDto req = requestDto.getOperation();
        ItemDetailResponseDto resp = itemRemoteService.getItem(req.getItemCode(),
                requestDto.getCommon().getCompanyNo(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);

        return responseDto;
    }
}
