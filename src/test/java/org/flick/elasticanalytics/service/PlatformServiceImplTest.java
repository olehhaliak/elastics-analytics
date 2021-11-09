package org.flick.elasticanalytics.service;

import org.flick.elasticanalytics.service.impl.PlatformServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlatformServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlatformServiceImplTest {
    @Autowired
    PlatformServiceImpl service;
    @Test
    void getPlatformByUserAgentTest() {
        System.out.println(service.getPlatformByUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36 Edg/95.0.1020.40"));
    }
}