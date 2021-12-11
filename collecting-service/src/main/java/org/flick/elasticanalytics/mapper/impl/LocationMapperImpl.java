package org.flick.elasticanalytics.mapper.impl;

import org.elasticsearch.common.geo.GeoPoint;
import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.mapper.LocationMapper;
import org.flick.elasticanalytics.model.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.swing.text.GapContent;

@Component
public class LocationMapperImpl implements LocationMapper {
    @Override
    public Location mapToModel(LocationDto dto) {
        Location location = new Location();
        BeanUtils.copyProperties(dto, location);
        location.setGeoPoint(new GeoPoint(dto.getLatitude(),dto.getLongitude()));
        return location;
    }
}
