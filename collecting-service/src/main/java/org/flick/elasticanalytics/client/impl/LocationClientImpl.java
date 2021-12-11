package org.flick.elasticanalytics.client.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.client.LocationClient;
import org.flick.elasticanalytics.dto.LocationDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class LocationClientImpl implements LocationClient {
    private static final String API_URL = "http://ip-api.com/json/%s?fields=49369";
    private final RestTemplate template = new RestTemplate();

    @Override
    public LocationDto getLocationByIp(String ip) {
        String url = String.format(API_URL, ip);
        return template.getForObject(url, LocationDto.class);
    }
}
