package org.flick.elasticanalytics.mapper.impl;

import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.mapper.LocationMapper;
import org.flick.elasticanalytics.model.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocationMapperImpl implements LocationMapper {
    @Override
    public Location mapToModel(LocationDto dto) {
        Location location = new Location();
        BeanUtils.copyProperties(dto, location);
        return location;
    }
}
