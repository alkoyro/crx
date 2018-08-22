package com.ak.crx.domain;

import java.util.List;
import java.util.Objects;

/**
 * hill domain class that represents hill surface
 */
public class Hill {

    /**
     * surface of high/low points for a given {@code Hill}
     */
    private List<Integer> surfacePoints;

    public List<Integer> getSurfacePoints() {
        return surfacePoints;
    }

    public void setSurfacePoints(List<Integer> surfacePoints) {
        this.surfacePoints = surfacePoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hill hill = (Hill) o;
        return Objects.equals(surfacePoints, hill.surfacePoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surfacePoints);
    }

    @Override
    public String toString() {
        return "Hill [" + "surfacePoints = " + surfacePoints + "]";
    }
}
