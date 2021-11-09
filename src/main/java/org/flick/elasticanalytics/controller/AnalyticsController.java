package org.flick.elasticanalytics.controller;

import lombok.RequiredArgsConstructor;
import org.flick.elasticanalytics.dto.AnalyticsRecordDto;
import org.flick.elasticanalytics.service.impl.AnalyticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final AnalyticServiceImpl analyticService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void getAnalytics(@RequestBody AnalyticsRecordDto dto, @Autowired HttpServletRequest request) {
        dto.setIp(request.getRemoteAddr());
        analyticService.addRecord(dto);
    }
}
