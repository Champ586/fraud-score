package com.champ586.fraudscore.service.impl;

import com.champ586.fraudscore.config.FraudDetectionPolicy;
import com.champ586.fraudscore.service.MessageScoringService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SimpleMessageScoringService implements MessageScoringService {

    private FraudDetectionPolicy fraudDetectionPolicy;

    public SimpleMessageScoringService(FraudDetectionPolicy fraudDetectionPolicy) {
        this.fraudDetectionPolicy = fraudDetectionPolicy;
    }

    @Override
    public int calculateFraudScoreInString(String message) {
        if (fraudDetectionPolicy != null && fraudDetectionPolicy.getPatterns() != null)
            return fraudDetectionPolicy.getPatterns()
                    .stream()
                    .mapToInt(patternInfo ->
                            findOccurrencesInMessageByPattern(message, patternInfo.getPattern()) * patternInfo.getPoints())
                    .sum();
        else
            return 0;
    }

    private int findOccurrencesInMessageByPattern(String message, String patternRegEx) {
        int cnt = 0;
        Pattern pattern = Pattern.compile(patternRegEx);
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            cnt++;
        }
        return cnt;
    }
}
