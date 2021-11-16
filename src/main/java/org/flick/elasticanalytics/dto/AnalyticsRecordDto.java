package org.flick.elasticanalytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsRecordDto {
    private String page;
    private String referer;
    private int historyLength;
    private String locale;
    private String platform;
    private Layout layout;
    private ClientTime clientTime;
    private String ip;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Layout {
        private int screenWidth;
        private int screenHeight;
        private int windowWidth;
        private int windowHeight;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClientTime {
        private Long timestamp;
        private int timezone;
    }
    
}
