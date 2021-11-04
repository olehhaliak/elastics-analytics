package org.flick.elasticanalytics.mapper;

import org.flick.elasticanalytics.dto.AnalyticsRecordDto;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsRecordMapper {

    public AnalyticsRecord mapToModel(AnalyticsRecordDto dto) {
        AnalyticsRecord record = new AnalyticsRecord();
        BeanUtils.copyProperties(dto, record);
        return record;
    }
}
