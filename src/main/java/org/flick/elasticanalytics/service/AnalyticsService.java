package org.flick.elasticanalytics.service;

import org.flick.elasticanalytics.dto.AnalyticsRecordDto;

public interface AnalyticsService {

    void addNewRecord(AnalyticsRecordDto dto);
}
