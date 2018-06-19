package com.wq.share.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TestRequstDto implements Serializable{

    private String method;
    private String data;

}
