package com.wq.share.dto.response;

import com.wq.share.dto.response.entity.GoodsEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StartUpResponseDto extends AbstractResponseDto {

   private List<GoodsEntity> goodsList;

}
