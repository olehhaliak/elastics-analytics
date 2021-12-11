package org.flick.elasticanalytics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "analytics")
public class AnalyticsRecord {
    @Id
    @SequenceGenerator(name = "PROJECT_ID_GENERATOR", sequenceName = "PROJECT_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_GENERATOR")
    private Integer id;
    private String page;
    private String referer;
    private int historyLength;
    private String locale;
    @JsonProperty
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
        @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZZ")
        private Timestamp timestamp;
        private int timezone;
    }
}
