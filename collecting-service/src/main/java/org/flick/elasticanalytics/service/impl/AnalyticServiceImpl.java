package org.flick.elasticanalytics.service.impl;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.dto.AnalyticsRecordDto;
import org.flick.elasticanalytics.mapper.AnalyticsRecordMapper;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.flick.elasticanalytics.service.AnalyticsService;
import org.flick.elasticanalytics.service.ElasticsearchService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticServiceImpl implements AnalyticsService {
    private final AnalyticsRecordMapper mapper;
    private final LocationServiceImpl locationService;
    private final PlatformServiceImpl platformService;
    private final ElasticsearchService service;

    public void addNewRecord(AnalyticsRecordDto dto) {
        AnalyticsRecord record = buildRecord(dto);
        service.saveAnalyticsRecord(record);
        System.out.println(record);
    }

    private AnalyticsRecord buildRecord(AnalyticsRecordDto dto) {
        AnalyticsRecord record = mapper.mapToModel(dto);
        record.setLocation(locationService.getLocationByIp(dto.getIp()));
        record.setPlatform(platformService.getPlatformByUserAgent(dto.getPlatform()));
        return record;
    }


}
