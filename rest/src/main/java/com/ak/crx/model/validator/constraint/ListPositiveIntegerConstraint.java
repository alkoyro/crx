package com.ak.crx.model.validator.constraint;

import com.ak.crx.model.validator.ListPositiveIntegerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * constraint can be used on {@link java.util.List<String>} fields/setters on request model
 * to verify if it acceptable to be converted into {@link java.util.List<Integer>} type
 * See {@link ListPositiveIntegerValidator} to get the rules applied by validator
 */
@Documented
@Constraint(validatedBy = ListPositiveIntegerValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListPositiveIntegerConstraint {
    String message() default "validation.constraint.ListPositiveIntegerConstraint.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
