package com.ak.crx.model;

import com.ak.crx.model.validator.constraint.ListPositiveIntegerConstraint;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * represents dto object for requests {@link com.ak.crx.controller.HillRestController}
 */
public class HillRequest {

    @NotNull(message = "surfacePoints field should not be empty")
    @ListPositiveIntegerConstraint(message = "surfacePoints expected to be positive numbers")
    private List<String> surfacePoints;

    public List<String> getSurfacePoints() {
        return surfacePoints;
    }

    public void setSurfacePoints(List<String> surfacePoints) {
        this.surfacePoints = surfacePoints;
    }
}
