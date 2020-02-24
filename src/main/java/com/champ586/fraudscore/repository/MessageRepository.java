package com.champ586.fraudscore.repository;

import com.champ586.fraudscore.model.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select count(m) from Message m " +
            "where senderId = :senderId " +
            "and recipientId = :recipientId " +
            "and created > :timestamp")
    Long countMessages(@Param("timestamp") LocalDateTime timestamp,
                       @Param("senderId") String senderId,
                       @Param("recipientId") String recipientId);
}
