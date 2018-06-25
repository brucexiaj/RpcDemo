package com.wq.share.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.BaseRequestDto;
import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.request.ItemSearchRequestDto;
import com.wq.share.dto.response.ItemSearchResponseDto;
import com.wq.share.remote.ItemRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 搜索商品
 */
@Service("wq.wangqin.search")
public class ItemSearchService extends AbstractService<ItemSearchRequestDto, ItemSearchResponseDto> {

    @Autowired
    private ItemRemoteService itemRemoteService;

    @Override
    protected BaseResponseDto<ItemSearchResponseDto> exec(BaseRequestDto<ItemSearchRequestDto> requestDto) {
        BaseResponseDto responseDto = new BaseResponseDto();
        ItemSearchRequestDto req = requestDto.getOperation();
        ItemSearchResponseDto resp = itemRemoteService.getSearchItems(req.getKeyWord(),
                requestDto.getCommon().getCompanyNo(), req.getPageSize(), req.getPageNo());

        responseDto.setOperation(resp);
        return responseDto;
    }

    @Override
    protected BaseRequestDto<ItemSearchRequestDto> parse(String requestData) {
        BaseRequestDto<ItemSearchRequestDto> requestDto = BaseDto.fromJson(requestData, new TypeReference<BaseRequestDto<ItemSearchRequestDto>>(){});
        return requestDto;
    }

    @Override
    protected void validate(BaseRequestDto<ItemSearchRequestDto> requestDto) {
       //TODO
    }
}
