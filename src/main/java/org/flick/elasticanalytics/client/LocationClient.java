package org.flick.elasticanalytics.client;

import org.flick.elasticanalytics.dto.LocationDto;

public interface LocationClient {
    LocationDto getLocationByIp(String ip);
}
