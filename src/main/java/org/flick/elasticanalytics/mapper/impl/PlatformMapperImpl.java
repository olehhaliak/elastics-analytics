package org.flick.elasticanalytics.mapper.impl;

import org.flick.elasticanalytics.dto.PlatformDto;
import org.flick.elasticanalytics.mapper.PlatformMapper;
import org.flick.elasticanalytics.model.Platform;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PlatformMapperImpl implements PlatformMapper {
    @Override
    public Platform mapToModel(PlatformDto dto) {
        Platform platform = new Platform();
        BeanUtils.copyProperties(dto, platform);
        return platform;
    }
}
