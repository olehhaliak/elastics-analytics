package org.flick.elasticanalytics.repository;

import org.flick.elasticanalytics.model.AnalyticsRecord;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnalyticsRecordRepository extends ElasticsearchRepository<AnalyticsRecord,Integer> {

}
