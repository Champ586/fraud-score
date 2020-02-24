package com.champ586.fraudscore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FraudResponse {

    /**
     * Fraud score
     */
    private Integer score;

}
