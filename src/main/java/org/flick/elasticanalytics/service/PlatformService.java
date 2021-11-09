package org.flick.elasticanalytics.service;

import org.flick.elasticanalytics.model.Platform;

public interface PlatformService {

     Platform getPlatformByUserAgent(String userAgent);
}
