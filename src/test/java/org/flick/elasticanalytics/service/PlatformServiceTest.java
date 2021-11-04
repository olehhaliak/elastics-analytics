package org.flick.elasticanalytics.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {PlatformService.class})
@ExtendWith(SpringExtension.class)
class PlatformServiceTest {
    @Autowired
    PlatformService service;
    @Test
    void getPlatformByUserAgentTest() {
        System.out.println(service.getPlatformByUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36 Edg/95.0.1020.40"));
    }
}