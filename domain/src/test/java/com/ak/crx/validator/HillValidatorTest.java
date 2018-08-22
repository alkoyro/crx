package com.ak.crx.validator;

import com.ak.crx.domain.Hill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
public class HillValidatorTest {

    @Autowired
    private HillValidator hillValidator;

    @TestConfiguration
    static class TestContextConfiguration {

        @Bean
        public HillValidator hillValidator() {
            return new HillValidator();
        }

    }

    @Test
    public void testValidationSuccess() {
        //given
        Hill hill = new Hill();
        hill.setSurfacePoints(Arrays.asList(1,2,0,5,6));

        //when
        boolean result = hillValidator.validateHillServicePoints(hill);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testValidationFailed() {
        //given
        Hill hill = new Hill();

        //when
        boolean result = hillValidator.validateHillServicePoints(hill);
        //then
        Assert.assertFalse(result);

        //given
        hill.setSurfacePoints(new ArrayList<>());
        //when
        result = hillValidator.validateHillServicePoints(hill);
        //then
        Assert.assertFalse(result);

        //given
        hill.setSurfacePoints(Arrays.asList(1,-2,4,5,-6));
        //when
        result = hillValidator.validateHillServicePoints(hill);
        //then
        Assert.assertFalse(result);
    }
}
