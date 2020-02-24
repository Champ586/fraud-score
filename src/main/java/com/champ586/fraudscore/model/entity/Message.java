package com.champ586.fraudscore.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /**
     * Id of the message sender
     */
    @Column(name = "sender_id")
    private String senderId;

    /**
     * Id of the message recipient
     */
    @Column(name = "recipient_id")
    private String recipientId;

    /**
     * Timestamp when message was created
     */
    private LocalDateTime created;
}
