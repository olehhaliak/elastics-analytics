package org.flick.elasticanalytics.mapper;

import org.flick.elasticanalytics.dto.PlatformDto;
import org.flick.elasticanalytics.model.Platform;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapper implements DtoMapper<Platform, PlatformDto> {
    @Override
    public Platform mapToModel(PlatformDto dto) {
        Platform platform = new Platform();
        BeanUtils.copyProperties(dto, platform);
        return platform;
    }
}
