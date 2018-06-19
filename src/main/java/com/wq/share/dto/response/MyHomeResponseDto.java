package com.wq.share.dto.response;

import com.wq.share.dto.response.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyHomeResponseDto extends AbstractResponseDto {

    private String commission;
    private List<OrderEntity> orderList;

}
