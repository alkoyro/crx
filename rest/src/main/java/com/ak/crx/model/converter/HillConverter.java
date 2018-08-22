package com.ak.crx.model.converter;

import com.ak.crx.domain.Hill;
import com.ak.crx.model.HillRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * converts {@link com.ak.crx.model.HillRequest} to {@link com.ak.crx.domain.Hill}
 */
@Component
public class HillConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(HillConverter.class);

    public Hill convert(@NonNull HillRequest hillRequest) {
        Hill hill = new Hill();

        List<Integer> surfPoints = hillRequest.getSurfacePoints().stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        hill.setSurfacePoints(surfPoints);

        return hill;
    }

}
