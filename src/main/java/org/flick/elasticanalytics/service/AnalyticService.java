package org.flick.elasticanalytics.service;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.dto.AnalyticsRecordDto;
import org.flick.elasticanalytics.mapper.AnalyticsRecordMapper;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticService {
    private final AnalyticsRecordMapper mapper;
    private final LocationService locationService;
    private final PlatformService platformService;

    public void addRecord(AnalyticsRecordDto dto) {
        AnalyticsRecord record = mapper.mapToModel(dto);
        record.setLocation(locationService.getLocationByIp(dto.getIp()));
        record.setPlatform(platformService.getPlatformByUserAgent(dto.getPlatform()));
        System.out.println(record);
    }


}
