package org.flick.elasticanalytics.service.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.dto.LocationDto;
import org.flick.elasticanalytics.mapper.LocationMapper;
import org.flick.elasticanalytics.model.Location;
import org.flick.elasticanalytics.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private static final String API_URL = "http://ip-api.com/json/%s?fields=49369";
    private final LocationMapper mapper;
    private RestTemplate template = new RestTemplate();

    public Location getLocationByIp(String ip) {
        String url = String.format(API_URL, ip);
        LocationDto dto = template.getForObject(url, LocationDto.class);
        return mapper.mapToModel(dto);
    }

}
