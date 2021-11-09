package org.flick.elasticanalytics.service;

import org.flick.elasticanalytics.model.Location;

public interface LocationService {

     Location getLocationByIp(String ip);
}
