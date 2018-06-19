package com.wq.share.remote;

import com.wq.share.dto.response.ItemDetailResponseDto;
import com.wq.share.dto.response.ItemSearchResponseDto;
import com.wq.share.dto.response.ItemShareResponseDto;
import com.wq.share.dto.response.StartUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemRemoteService {

    @Autowired
    private RestTemplate restTemplate;

    public StartUpResponseDto getStartUpItems(String type, String companyNo, String pageSize, String pageNo){

        return null;
    }

    public ItemSearchResponseDto getSearchItems(String keyWord, String companyNo, String pageSize, String pageNo) {

        return null;
    }

    public ItemDetailResponseDto getItem(String itemCode, String companyNo, String pageSize, String pageNo) {

        return null;
    }

    public ItemShareResponseDto getShareItemInfo(String itemCode, String companyNo, String userId) {

        return null;
    }
}
