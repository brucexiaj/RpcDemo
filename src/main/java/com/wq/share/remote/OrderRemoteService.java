package com.wq.share.remote;

import com.wq.share.dto.response.MyHomeResponseDto;
import com.wq.share.dto.response.OrderDetailResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderRemoteService {

    @Autowired
    private RestTemplate restTemplate;

    public MyHomeResponseDto getMyHomeList(String userId, String pageSize, String pageNo){

        return null;
    }

    public OrderDetailResponseDto getOrderDetailList(String userId, String time, String pageSize, String pageNo){

        return null;
    }

}
