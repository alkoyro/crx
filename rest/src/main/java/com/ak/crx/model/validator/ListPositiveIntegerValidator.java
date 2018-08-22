package com.ak.crx.model.validator;

import com.ak.crx.model.validator.constraint.ListPositiveIntegerConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * custom validator to verify
 * 1) if {@link List<String>} can be converted into {@link List<Integer>} type
 * 2) positive or zero integers
 */
public class ListPositiveIntegerValidator implements ConstraintValidator<ListPositiveIntegerConstraint, List<String>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListPositiveIntegerValidator.class);

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        LOGGER.debug("validation value: " + value);
        return value.stream().allMatch(val -> {
            try {
                Integer intVal = Integer.valueOf(val);
                return intVal >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }
}
