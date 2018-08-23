package com.ak.crx.model.converter;

import com.ak.crx.domain.Hill;
import com.ak.crx.model.HillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * converts {@link com.ak.crx.model.HillRequest} to {@link com.ak.crx.domain.Hill}
 */
@Component
public class HillConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(HillConverter.class);

    public Hill convert(@NonNull HillRequest hillRequest) {
        Hill hill = new Hill();

        hill.setSurfacePoints(hillRequest.getSurfacePoints());

        return hill;
    }

}
