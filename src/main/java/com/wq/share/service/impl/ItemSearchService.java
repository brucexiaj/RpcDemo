package com.wq.share.service.impl;

import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemSearchRequestDto;
import com.wq.share.dto.response.ItemSearchResponseDto;
import com.wq.share.remote.ItemRemoteService;
import com.wq.share.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 搜索商品
 */
@Service("wq.wangqin.search")
public class ItemSearchService implements IService {

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    public BaseResponseDto<ItemSearchResponseDto> handle(String requestData) {

        //1 反序列化
        BaseRequestDto<ItemSearchRequestDto> requestDto = BaseDto.fromJson(requestData, BaseRequestDto.class);
        BaseResponseDto responseDto = new BaseResponseDto();
        //2 TODO 检验

        //3 调用远程接口
        ItemSearchRequestDto req = requestDto.getOperation();
        ItemSearchResponseDto resp = itemRemoteService.getSearchItems(req.getKeyWord(),
                requestDto.getCommon().getCompanyNo(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);

        return responseDto;
    }
}
