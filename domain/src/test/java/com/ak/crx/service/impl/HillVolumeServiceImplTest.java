package com.ak.crx.service.impl;

import com.ak.crx.domain.Hill;
import com.ak.crx.exception.VolumeCalculationException;
import com.ak.crx.service.HillVolumeService;
import com.ak.crx.validator.HillValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class HillVolumeServiceImplTest {

    @Autowired
    private HillVolumeService hillVolumeService;

    @Autowired
    private HillValidator hillValidator;

    private Hill hill;

    @TestConfiguration
    static class TestContextConfiguration {

        @Bean
        public HillValidator hillValidator() {
            return new HillValidator();
        }

        @Bean
        public HillVolumeService hillVolumeService() {
            return new HillVolumeServiceImpl();
        }
    }

    @Before
    public void setup() {
        hill = new Hill();
    }

    @Test(expected = VolumeCalculationException.class)
    public void calculateHillVolumeFailed() throws VolumeCalculationException {
        //given
        Hill hill = new Hill();

        //when
        hillVolumeService.calculateHillVolume(hill);
    }

    @Test
    public void calculateHillVolumeRemoveLeftBounds() throws VolumeCalculationException {
        //given
        hill.setSurfacePoints(Arrays.asList(1, 2, 3, 0));

        //when and then
        Assert.assertTrue(0 == hillVolumeService.calculateHillVolume(hill));
    }

    @Test
    public void calculateHillVolumeRemoveRightBounds() throws VolumeCalculationException {
        //given
        hill.setSurfacePoints(Arrays.asList(3, 2, 1, 0));
        //when and then
        Assert.assertTrue(0 == hillVolumeService.calculateHillVolume(hill));

        //given
        hill.setSurfacePoints(Arrays.asList(3, 2, 2, 0));
        //when and then
        Assert.assertTrue(0 == hillVolumeService.calculateHillVolume(hill));
    }

    @Test
    public void calculateHillVolumeNotNullResult() throws VolumeCalculationException {
        //given
        hill.setSurfacePoints(Arrays.asList(0, 0, 0, 0));

        //when
        Integer hillVolume = hillVolumeService.calculateHillVolume(hill);

        //then
        Assert.assertNotNull(hillVolume);
        Assert.assertTrue(0 == hillVolume);
    }

    @Test
    public void calculateHillVolumeSuccess() throws VolumeCalculationException {
        //given
        hill.setSurfacePoints(Arrays.asList(10, 0, 10));
        //when and then
        Assert.assertTrue(10 == hillVolumeService.calculateHillVolume(hill));

        //given
        hill.setSurfacePoints(Arrays.asList(10, 0, 10, 5, 6));
        //when and then
        Assert.assertTrue(11 == hillVolumeService.calculateHillVolume(hill));

        //given
        hill.setSurfacePoints(Arrays.asList(10, 0, 10, 5, 6, 8, 3, 2, 1, 0, 2));
        //when and then
        Assert.assertTrue(18 == hillVolumeService.calculateHillVolume(hill));

    }
}
