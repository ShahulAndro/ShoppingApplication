package com.shopping.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String code;
    private String message;

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
