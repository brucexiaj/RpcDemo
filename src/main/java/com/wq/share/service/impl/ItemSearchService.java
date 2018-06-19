package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.ItemSearchResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

/**
 * 搜索商品
 */
@Service("wq.wangqin.search")
public class ItemSearchService implements IService {

    @Override
    public BaseResponseDto<ItemSearchResponseDto> handle(String requestData) {

        return null;
    }
}
