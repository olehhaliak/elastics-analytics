package org.flick.elasticanalytics.service;

import org.flick.elasticanalytics.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LocationServiceImpl.class})
class LocationServiceImplTest {
@Autowired
LocationServiceImpl service;
    @Test
    void getLocationForIpTest() {
        String ip = "188.163.112.225";
        System.out.println(service.getLocationByIp(ip));
    }
}