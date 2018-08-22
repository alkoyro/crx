package com.ak.crx.model.converter;

import com.ak.crx.domain.Hill;
import com.ak.crx.model.HillRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
public class HillConverterTest {

    @Autowired
    private HillConverter hillConverter;

    @TestConfiguration
    static class TestContextConfiguration {

        @Bean
        public HillConverter hillCoverter() {
            return new HillConverter();
        }

    }

    @Test
    public void testConvertHillRequestToHill() {
        //given
        HillRequest hillRequest = new HillRequest();
        hillRequest.setSurfacePoints(Arrays.asList("1", "2", "4", "7"));

        //when
        Hill hill = hillConverter.convert(hillRequest);

        //then
        Assert.assertNotNull(hill);
        Assert.assertNotNull(hill.getSurfacePoints());
    }
}
