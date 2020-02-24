package com.champ586.fraudscore.service.impl;

import com.champ586.fraudscore.FraudScoreApplication;
import com.champ586.fraudscore.model.MessageRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = FraudScoreApplication.class)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class FraudCalculatingServiceWithDBTest {

    private static final String MESSAGE = "<a>go transfer some money to paypal<a> moneymoneymoney";

    @Autowired
    FraudCalculatingServiceWithDB fraudCalculatingServiceWithDB;

    @Test
    public void calculateFraudScore() {
        MessageRequest messageRequest = new MessageRequest("1", "2", MESSAGE);
        Assert.assertEquals(62, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));
        Assert.assertEquals(62, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));
        Assert.assertEquals(62, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));
        Assert.assertEquals(62, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));
        Assert.assertEquals(62, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));
        Assert.assertEquals(162, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequest));

        MessageRequest messageRequestNew = new MessageRequest("1", "3", "test<a>");
        Assert.assertEquals(1, fraudCalculatingServiceWithDB.calculateFraudScore(messageRequestNew));
    }
}