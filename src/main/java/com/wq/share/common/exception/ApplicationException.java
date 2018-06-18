package com.wq.share.common.exception;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -2765274790055355530L;

    private BaseReturnType type;

    private Object[]       args;

    public ApplicationException(BaseReturnType type, Object... args) {
        super(MessageFormat.format(StringUtils.stripToEmpty(type.getMessage()), args));
        this.type = type;
        this.args = args;
    }
}
