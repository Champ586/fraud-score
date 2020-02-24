package com.champ586.fraudscore.service;

import com.champ586.fraudscore.model.MessageRequest;

public interface FraudCalculatingService {
    int calculateFraudScore(MessageRequest messageRequest);
}
