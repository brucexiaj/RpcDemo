package com.wq.share.service.impl;

import com.wq.share.common.BaseResponseDto;
import com.wq.share.dto.response.ItemDetailResponseDto;
import com.wq.share.service.IService;
import org.springframework.stereotype.Service;

/**
 * 商品详情页
 */
@Service("wq.wangqin.itemDetail")
public class ItemDetailService implements IService {

    @Override
    public BaseResponseDto<ItemDetailResponseDto> handle(String requestData) {

        return null;
    }
}
