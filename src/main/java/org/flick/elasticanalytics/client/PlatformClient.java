package org.flick.elasticanalytics.client;

import org.flick.elasticanalytics.dto.PlatformDto;

public interface PlatformClient {
    PlatformDto getPlatformByUserAgent(String userAgent);
}
