package org.flick.elasticanalytics.service;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.dto.PlatformDto;
import org.flick.elasticanalytics.mapper.PlatformMapper;
import org.flick.elasticanalytics.model.Platform;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PlatformService {
    private static final String API_URL = "https://api.apicagent.com/?ua=%s";
    private final PlatformMapper mapper;
    private RestTemplate restTemplate = new RestTemplate();

    public Platform getPlatformByUserAgent(String userAgent) {
        String url = String.format(API_URL, userAgent);
        PlatformDto dto = restTemplate.getForObject(url, PlatformDto.class);
        return mapper.mapToModel(dto);
    }
}
