package com.wq.share.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WithdrawListResponse extends AbstractResponseDto {

    private String allAmount ="0";
    private String availableAmount = "0";
    private String doneAmount = "0";
    private List<WithdrawEntity> withdrawList = new ArrayList<>();

    @Getter
    @Setter
    public static class WithdrawEntity{
        private String time;
        private String amount;
    }

}

