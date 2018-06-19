package com.wq.share.dto.response;

import com.wq.share.dto.response.entity.OrderDetailEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailResponseDto extends AbstractResponseDto {

    private String orderDetailDesc;

    private List<OrderDetailEntity> orderDetailList;

}
