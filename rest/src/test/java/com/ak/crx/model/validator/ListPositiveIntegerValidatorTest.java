package com.ak.crx.model.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.validation.ConstraintValidatorContext;

import java.util.Arrays;

import static org.mockito.Answers.RETURNS_MOCKS;

public class ListPositiveIntegerValidatorTest {

    private ListPositiveIntegerValidator validator;

    @Mock(answer = RETURNS_MOCKS)
    private ConstraintValidatorContext constraintValidatorContext;

    @Before
    public void setup() {
        validator = new ListPositiveIntegerValidator();
    }

    @Test
    public void testIsNotValidForStrings() {
        Assert.assertFalse(validator.isValid(Arrays.asList("adsad", "a", "c"), constraintValidatorContext));
    }

    @Test
    public void testIsNotValidForNegativeValues() {
        Assert.assertFalse(validator.isValid(Arrays.asList("0", "5", "-1"), constraintValidatorContext));
    }

    @Test
    public void testIsValidForZeroAndPositiveValues() {
        Assert.assertTrue(validator.isValid(Arrays.asList("0", "0", "1"), constraintValidatorContext));
    }
}
