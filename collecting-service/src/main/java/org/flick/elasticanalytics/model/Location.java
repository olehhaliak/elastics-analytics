package org.flick.elasticanalytics.model;

import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.elasticsearch.annotations.GeoPointField;

@Data
public class Location {

    private String country;
    private String regionName;
    private String city;
    private double latitude;
    private double longitude;
    @GeoPointField
    private GeoPoint geoPoint;
}