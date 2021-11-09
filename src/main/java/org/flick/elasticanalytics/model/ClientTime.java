package org.flick.elasticanalytics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientTime {
    private Long timestamp;
    private int timezone;
}