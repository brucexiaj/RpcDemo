package com.wq.share.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wq.share.common.BaseDto;
import com.wq.share.common.exception.ApplicationException;
import com.wq.share.dto.response.ItemDetailResponseDto;
import com.wq.share.dto.response.ItemSearchResponseDto;
import com.wq.share.dto.response.ItemShareResponseDto;
import com.wq.share.dto.response.StartUpResponseDto;
import com.wq.share.dto.response.entity.ItemEntity;
import com.wq.share.enums.ReturnCode;
import com.wq.share.remote.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ItemRemoteService extends AbstractRemoteService{

    public StartUpResponseDto getStartUpItems(String type, String companyNo, String pageSize, String pageNo){
        String url = String.format("%s/api/items/startup?type=%s&companyNo=%s&pageSize=%s&pageNo=%s",
                getErpRemoteUri(), type, companyNo, pageSize, pageNo);

        String remoteResp = remoteGetCall(url);

        JsonResult<List<ItemEntity>> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<List<ItemEntity>>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }

        StartUpResponseDto resp = new StartUpResponseDto();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        resp.setItemList(jsonResult.getData());

        return resp;
    }

    public ItemSearchResponseDto getSearchItems(String keyWord, String companyNo, String pageSize, String pageNo) {

        String url = String.format("%s/api/items/search?keyword=%s&companyNo=%s&pageSize=%s&pageNo=%s",
                getErpRemoteUri(), keyWord, companyNo, pageSize, pageNo);
        String remoteResp = remoteGetCall(url);

        JsonResult<List<ItemEntity>> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<List<ItemEntity>>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }

        ItemSearchResponseDto resp = new ItemSearchResponseDto();
        resp.setPageNo(pageNo);
        resp.setPageSize(pageSize);
        resp.setItemList(jsonResult.getData());

        return resp;
    }

    public ItemDetailResponseDto getItem(String itemCode, String companyNo) {

        String url = String.format("%s/api/items/detail?itemCode=%s&companyNo=%s",
                getErpRemoteUri(), itemCode, companyNo);
        String remoteResp = remoteGetCall(url);

        JsonResult<ItemDetailResponseDto> jsonResult = BaseDto.fromJson(remoteResp,
                new TypeReference<JsonResult<ItemDetailResponseDto>>() {});

        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }
        ItemDetailResponseDto responseDto = jsonResult.getData();

        return responseDto;
    }

    public ItemShareResponseDto getShareItemInfo(String itemCode, String companyNo, String userId) {

        String url = String.format("%s/api/items/share?itemCode=%s&companyNo=%s&userId=%s",
                getErpRemoteUri(), itemCode, companyNo, userId);

        String remoteResp = remoteGetCall(url);

        JsonResult<ItemShareResponseDto> jsonResult = BaseDto.fromJson(remoteResp, new TypeReference<JsonResult<ItemShareResponseDto>>() {});
        if (!jsonResult.isSuccess()){
            throw new ApplicationException(ReturnCode.REMOTE_ITEM_EXCEPTION, jsonResult.getMsg());
        }
        ItemShareResponseDto responseDto = jsonResult.getData();

        return responseDto;
    }
}
