package org.flick.elasticanalytics.service.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.client.LocationClient;
import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.mapper.LocationMapper;
import org.flick.elasticanalytics.model.Location;
import org.flick.elasticanalytics.service.LocationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationClient locationClient;
    private final LocationMapper mapper;

    public Location getLocationByIp(String ip) {
        LocationDto dto = locationClient.getLocationByIp(ip);
        return mapper.mapToModel(dto);
    }

}
