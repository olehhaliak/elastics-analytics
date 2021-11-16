package org.flick.elasticanalytics.service;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.flick.elasticanalytics.repository.AnalyticsRecordRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ElasticsearchService {
    final ElasticsearchOperations restTemplate;
    final AnalyticsRecordRepository repository;

    public void saveAnalyticsRecord(AnalyticsRecord record) {
        repository.save(record);
    }

}
