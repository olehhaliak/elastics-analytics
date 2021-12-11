package org.flick.elasticanalytics.mapper.impl;

import org.flick.elasticanalytics.dto.AnalyticsRecordDto;
import org.flick.elasticanalytics.mapper.AnalyticsRecordMapper;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.flick.elasticanalytics.model.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class AnalyticsRecordMapperImpl implements AnalyticsRecordMapper {

    public AnalyticsRecord mapToModel(AnalyticsRecordDto dto) {
        AnalyticsRecord record = new AnalyticsRecord();
        record.setLayout(new AnalyticsRecord.Layout());
        record.setClientTime(new AnalyticsRecord.ClientTime(
                new Timestamp(dto.getClientTime().getTimestamp()),
                dto.getClientTime().getTimezone()
        ));
        BeanUtils.copyProperties(dto, record);
        BeanUtils.copyProperties(dto.getLayout(), record.getLayout());
        BeanUtils.copyProperties(dto.getClientTime(), record.getClientTime());
        return record;
    }
}
