package com.ak.crx.service.impl;


import com.ak.crx.domain.Hill;
import com.ak.crx.exception.VolumeCalculationException;
import com.ak.crx.service.HillVolumeService;
import com.ak.crx.validator.HillValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * impl of {@link HillVolumeService}
 */
@Service
public class HillVolumeServiceImpl implements HillVolumeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HillVolumeServiceImpl.class);

    @Autowired
    private HillValidator hillValidator;

    /**
     * validates the input and then calculates the hill volume
     *
     * @param hill input for volume calculation
     * @return hill volume
     * @throws VolumeCalculationException if validation failed
     */
    @Override
    public Integer calculateHillVolume(Hill hill) throws VolumeCalculationException {
        LOGGER.debug("Calculate hill volume for surf points: " + hill.getSurfacePoints());

        if (!hillValidator.validateHillServicePoints(hill)) {
            LOGGER.error("Hill validation failed: " + hill);
            throw new VolumeCalculationException("Not valid input");
        }

        Integer volume = 0;

        List<Integer> surfPoints = hill.getSurfacePoints();

        int startIndex;
        //detect the left boundaries (e.g: 1,2,4,5,4 -> all before 5 not able to have a volume)
        for (startIndex = 0; startIndex < surfPoints.size() - 1; startIndex++) {
            if (surfPoints.get(startIndex) > surfPoints.get(startIndex + 1)) {
                break;
            }
        }

        int endIndex;
        //detect the right boundaries (e.g: 3,7,2,1,0 -> all after 3 not able to have a volume)
        for (endIndex = surfPoints.size() - 1; endIndex > 0; endIndex--) {
            if (surfPoints.get(endIndex) > surfPoints.get(endIndex - 1)) {
                break;
            }
        }

        int curPeakSurfPoint = surfPoints.get(startIndex);

        for (int i = startIndex + 1; i <= endIndex; i++) {
            int nextSurfPoint = surfPoints.get(i);

            //skip each next equal to current (e.g. 10, 0, 10, 10 -> 10, 10 can be skipped)
            if (curPeakSurfPoint == nextSurfPoint) {
                continue;
            }

            int nextPeakIndex = -1;

            //search next highest peak
            for (int j = i; j <= endIndex; j++) {
                //got highest peak
                if (curPeakSurfPoint <= surfPoints.get(j)) {
                    nextPeakIndex = j;
                    nextSurfPoint = surfPoints.get(j);
                    break;
                }

                //search for a next local peak
                if (nextSurfPoint < surfPoints.get(j)) {
                    nextPeakIndex = j;
                    nextSurfPoint = surfPoints.get(j);
                }
            }

            //calculate volume
            if (nextPeakIndex > 0) {
                curPeakSurfPoint = nextSurfPoint;

                for (int j = i; j < nextPeakIndex; j++) {
                    volume += curPeakSurfPoint - surfPoints.get(j);
                }
                i = nextPeakIndex;
            }

        }

        LOGGER.debug("Hill volume: " + volume);

        return volume;
    }


}
