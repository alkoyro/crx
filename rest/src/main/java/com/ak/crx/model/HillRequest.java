package com.ak.crx.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * represents dto object for requests {@link com.ak.crx.controller.HillRestController}
 */
public class HillRequest {

    @FieldView(value = "surfacePoints field expected to be array of numbers", example = "\"surfacePoints\":[10]")
    @NotNull(message = "surfacePoints field should not be empty")
    private List<@PositiveOrZero(message = "surfacePoints filed expect to have a positive numbers") Integer> surfacePoints;

    public List<Integer> getSurfacePoints() {
        return surfacePoints;
    }

    public void setSurfacePoints(List<Integer> surfacePoints) {
        this.surfacePoints = surfacePoints;
    }
}
