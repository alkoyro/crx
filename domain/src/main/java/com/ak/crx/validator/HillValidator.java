package com.ak.crx.validator;

import com.ak.crx.domain.Hill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * validates {@link com.ak.crx.domain.Hill} against the defined rules
 */
@Component
public class HillValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(HillValidator.class);

    /**
     * validates {@link Hill#surfacePoints}
     * 1) non-null
     * 2) size > 0
     * 3) all positive numbers
     *
     * @param hill obj for validating
     * @return true if surfacePoints are valid for presented {@code Hill}
     */
    public boolean validateHillServicePoints(@NonNull Hill hill) {
        if (hill.getSurfacePoints() == null) {
            LOGGER.debug("Hill surface points not defined: " + hill);
            return false;
        }

        if (hill.getSurfacePoints().size() == 0) {
            LOGGER.debug("Hill surface points size = 0: " + hill);
            return false;
        }

        boolean positiveSurfaces = hill.getSurfacePoints().stream().allMatch(s -> s >= 0);

        if (!positiveSurfaces) {
            LOGGER.debug("Hill surface points accept positive numbers only: " + hill);
            return false;
        }

        return true;
    }
}
