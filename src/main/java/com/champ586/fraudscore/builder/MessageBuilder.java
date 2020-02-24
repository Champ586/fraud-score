package com.champ586.fraudscore.builder;

import com.champ586.fraudscore.model.MessageRequest;
import com.champ586.fraudscore.model.entity.Message;

import java.time.LocalDateTime;

public class MessageBuilder {
    public static Message buildMessage(MessageRequest messageRequest) {
        return Message.builder()
                .senderId(messageRequest.getSenderId())
                .recipientId(messageRequest.getRecipientId())
                .created(LocalDateTime.now())
                .build();
    }
}
