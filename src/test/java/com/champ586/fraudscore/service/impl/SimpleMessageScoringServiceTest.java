package com.champ586.fraudscore.service.impl;

import com.champ586.fraudscore.config.FraudDetectionPolicy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleMessageScoringServiceTest {

    private SimpleMessageScoringService fraudService;

    private static final String MESSAGE = "<a>go transfer some money to paypal<a> moneymoneymoney";

    @Before
    public void setUp() throws Exception {
        List<FraudDetectionPolicy.PatternInfo> patterns = new ArrayList<>();
        patterns.add(new FraudDetectionPolicy.PatternInfo("<a>", 1));
        patterns.add(new FraudDetectionPolicy.PatternInfo("money|transfer|paypal", 10));
        fraudService = new SimpleMessageScoringService(new FraudDetectionPolicy(5, 120, 100, patterns));
    }

    @Test
    public void calculateFraudScoreTest() {
        Assert.assertEquals(0, fraudService.calculateFraudScoreInString(""));
        Assert.assertEquals(62, fraudService.calculateFraudScoreInString(MESSAGE));
    }
}