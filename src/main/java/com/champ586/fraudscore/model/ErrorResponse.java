package com.champ586.fraudscore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    /**
     * Error message
     */
    private String message;
}
