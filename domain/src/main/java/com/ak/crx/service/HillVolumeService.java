package com.ak.crx.service;

import com.ak.crx.domain.Hill;
import com.ak.crx.exception.VolumeCalculationException;
import org.springframework.lang.NonNull;

/**
 * a service to calculate hills volume
 */
public interface HillVolumeService {

    /**
     * calculates {@link Hill} volume
     *
     * @param hill input for volume calculation
     * @return hillVolume 0 or positive integer
     * @throws VolumeCalculationException if volume calculation failed
     */
    @NonNull
    Integer calculateHillVolume(@NonNull Hill hill) throws VolumeCalculationException;
}
