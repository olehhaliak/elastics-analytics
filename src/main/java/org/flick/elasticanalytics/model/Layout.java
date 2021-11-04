package org.flick.elasticanalytics.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class Layout {
    private int screenWidth;
    private int screenHeight;
    private int windowWidth;
    private int windowHeight;
}

