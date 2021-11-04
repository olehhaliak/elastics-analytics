package org.flick.elasticanalytics.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LocationService.class})
class LocationServiceTest {
@Autowired
LocationService service;
    @Test
    void getLocationForIpTest() {
        String ip = "188.163.112.225";
        System.out.println(service.getLocationByIp(ip));
    }
}