package com.kaibacorp.vaccineapi.Domain.exception;

public class DontFoundEntityException extends RuntimeException {
    private static final long serialVersionUID=1L;

    public DontFoundEntityException(String msg){
        super(msg);
    }
}