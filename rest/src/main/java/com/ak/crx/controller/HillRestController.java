package com.ak.crx.controller;

import com.ak.crx.domain.Hill;
import com.ak.crx.exception.VolumeCalculationException;
import com.ak.crx.model.HillRequest;
import com.ak.crx.model.HillResponse;
import com.ak.crx.model.converter.HillConverter;
import com.ak.crx.service.HillVolumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * rest controller that interact with base endpoint "/hills"
 */
@RestController
@RequestMapping(value = "/hills",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class HillRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HillRestController.class);

    @Autowired
    private HillVolumeService hillVolumeService;

    @Autowired
    private HillConverter hillConverter;

    @GetMapping(path = "/volume")
    HillResponse calculateVolume(@Valid @RequestBody HillRequest hillRequest)
            throws VolumeCalculationException {
        LOGGER.debug("calculate volume for hillRequest: " + hillRequest);

        Hill hill = hillConverter.convert(hillRequest);

        return new HillResponse("Hill volume", hillVolumeService.calculateHillVolume(hill));
    }

}
