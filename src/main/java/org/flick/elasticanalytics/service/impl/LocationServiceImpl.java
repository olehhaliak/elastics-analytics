package org.flick.elasticanalytics.service.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.client.LocationClient;
import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.mapper.LocationMapper;
import org.flick.elasticanalytics.model.Location;
import org.flick.elasticanalytics.service.LocationService;
import org.flick.elasticanalytics.util.DummyDataGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationClient locationClient;
    private final LocationMapper mapper;
    private final DummyDataGenerator generator;

    public Location getLocationByIp(String ip) {
        LocationDto dto = locationClient.getLocationByIp(ip);
        if (dto.getCountry() == null) {
            try {
                return generator.generateRandomizedRecord().getLocation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return mapper.mapToModel(dto);
    }

}
