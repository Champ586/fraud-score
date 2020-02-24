package com.champ586.fraudscore.controller;

import com.champ586.fraudscore.model.FraudResponse;
import com.champ586.fraudscore.model.MessageRequest;
import com.champ586.fraudscore.service.FraudCalculatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FraudController {

    private FraudCalculatingService fraudCalculatingService;

    public FraudController(FraudCalculatingService fraudCalculatingService) {
        this.fraudCalculatingService = fraudCalculatingService;
    }

    /**
     * Check a message for fraud
     * @param body body
     * @return FraudResponse
     */
    @PostMapping("/message")
    public ResponseEntity<FraudResponse> checkMessageForFraud(@Valid @RequestBody MessageRequest body) {

        return ResponseEntity.ok(
                FraudResponse
                        .builder()
                        .score(fraudCalculatingService.calculateFraudScore(body))
                        .build()
                );
    }
}
