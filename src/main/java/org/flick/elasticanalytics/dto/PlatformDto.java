package org.flick.elasticanalytics.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.flick.elasticanalytics.model.Platform;

import java.util.Map;

@Data
public class PlatformDto {
    @JsonProperty("client")
    private Platform.Browser browser;
    private Platform.OS os;
    private String deviceType;

    @JsonProperty("device")
    private void unpachNested(Map<String,String> device){
        deviceType = device.get("type");
    }
}
