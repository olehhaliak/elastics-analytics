package org.flick.elasticanalytics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Platform {
    private Browser browser;
    private OS os;
    private String deviceType;

    @Data
    public static class Browser{
        private String name;
        private String version;
    }

    @Data
    public static class OS{
        private String name;
        private String version;
    }
}
