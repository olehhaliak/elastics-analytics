package org.flick.elasticanalytics.client.impl;

import org.flick.elasticanalytics.client.PlatformClient;
import org.flick.elasticanalytics.dto.PlatformDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlatformClientImpl implements PlatformClient {
    private static final String API_URL = "https://api.apicagent.com/?ua=%s";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public PlatformDto getPlatformByUserAgent(String userAgent) {
        String url = String.format(API_URL, userAgent);
        return restTemplate.getForObject(url, PlatformDto.class);
    }
}
