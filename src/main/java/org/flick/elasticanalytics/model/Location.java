package org.flick.elasticanalytics.model;

import lombok.Data;

@Data
public class Location {
    private String country;
    private String regionName;
    private String city;
    private double latitude;
    private double longitude;
}