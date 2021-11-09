package org.flick.elasticanalytics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flick.elasticanalytics.dto.AnalyticsRecordDto;

@Data
public class AnalyticsRecord {
    private String page;
    private String referer;
    private int historyLength;
    private String locale;
    private Layout layout;
    private ClientTime clientTime;
    private String ip;
    private Location location;
    private Platform platform;
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
