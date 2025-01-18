package com.shopping.api.builder;

import com.shopping.api.response.Message;

public class MessageBuilder {

    public static Message response(String code, String message) {
        return new Message(code, message);
    }

}
