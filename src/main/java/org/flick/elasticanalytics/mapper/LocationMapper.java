package org.flick.elasticanalytics.mapper;

import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.model.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper implements DtoMapper<Location, LocationDto> {
    @Override
    public Location mapToModel(LocationDto dto) {
        Location location = new Location();
        BeanUtils.copyProperties(dto, location);
        return location;
    }
}
