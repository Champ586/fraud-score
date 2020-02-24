package com.champ586.fraudscore.service.impl;

import com.champ586.fraudscore.builder.MessageBuilder;
import com.champ586.fraudscore.config.FraudDetectionPolicy;
import com.champ586.fraudscore.model.MessageRequest;
import com.champ586.fraudscore.model.entity.Message;
import com.champ586.fraudscore.repository.MessageRepository;
import com.champ586.fraudscore.service.FraudCalculatingService;
import com.champ586.fraudscore.service.MessageScoringService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class FraudCalculatingServiceWithDB implements FraudCalculatingService {

    private MessageScoringService messageScoringService;

    private MessageRepository messageRepository;

    private FraudDetectionPolicy fraudDetectionPolicy;

    public FraudCalculatingServiceWithDB(MessageScoringService messageScoringService,
                                         MessageRepository messageRepository,
                                         FraudDetectionPolicy fraudDetectionPolicy) {
        this.messageScoringService = messageScoringService;
        this.messageRepository = messageRepository;
        this.fraudDetectionPolicy = fraudDetectionPolicy;
    }

    @Override
    @Transactional
    public int calculateFraudScore(MessageRequest messageRequest) {
        int score = messageScoringService.calculateFraudScoreInString(messageRequest.getMessage());
        if (checkRepeatableMessage(messageRequest))
            score += fraudDetectionPolicy.getPointsForRepeat();

        return score;
    }

    private boolean checkRepeatableMessage(MessageRequest messageRequest) {
        Message message = MessageBuilder.buildMessage(messageRequest);
        messageRepository.save(message);

        LocalDateTime timestamp = message.getCreated().minusMinutes(fraudDetectionPolicy.getNumOfMinutes());
        Long count = messageRepository.countMessages(timestamp, messageRequest.getSenderId(), messageRequest.getRecipientId());

        return count > fraudDetectionPolicy.getMaxMessageCount();
    }
}
