package com.ak.crx.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * represents the field expected representation (if request fails to be translated)
 * see {@link com.ak.crx.exception.handling.DefaultExceptionHandler} how it used
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldView {
    /**
     * description of the field
     *
     * @return description
     */
    String value();

    /**
     * example of usage
     *
     * @return example
     */
    String example();
}
