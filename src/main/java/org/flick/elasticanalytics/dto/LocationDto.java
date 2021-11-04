package org.flick.elasticanalytics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationDto {
    private String country;
    private String regionName;
    private String city;
    @JsonProperty(value = "lat")
    private double latitude;
    @JsonProperty(value = "lon")
    private double longitude;
}
