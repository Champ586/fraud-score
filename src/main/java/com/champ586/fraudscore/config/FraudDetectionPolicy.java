package com.champ586.fraudscore.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@ConfigurationProperties(prefix = "fraud-detection-policy")
@Configuration
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudDetectionPolicy {

    @NotNull
    private Integer maxMessageCount;

    @NotNull
    private Integer numOfMinutes;

    @NotNull
    private Integer pointsForRepeat;

    private List<PatternInfo> patterns;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatternInfo {

        @NotEmpty
        private String pattern;
        @NotNull
        private int points;
    }

}