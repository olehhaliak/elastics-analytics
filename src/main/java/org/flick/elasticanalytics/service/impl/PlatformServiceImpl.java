package org.flick.elasticanalytics.service.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.client.PlatformClient;
import org.flick.elasticanalytics.dto.PlatformDto;
import org.flick.elasticanalytics.mapper.PlatformMapper;
import org.flick.elasticanalytics.model.Platform;
import org.flick.elasticanalytics.service.PlatformService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    private final PlatformClient platformClient;
    private final PlatformMapper mapper;

    public Platform getPlatformByUserAgent(String userAgent) {
        PlatformDto dto = platformClient.getPlatformByUserAgent(userAgent);
        return mapper.mapToModel(dto);
    }
}
