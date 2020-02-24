package com.champ586.fraudscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    /**
     * Id of the message sender
     */
    @NotEmpty
    private String senderId;

    /**
     * Id of the message recipient
     */
    @NotEmpty
    private String recipientId;

    /**
     * The message
     */
    @NotNull
    private String message;
}
