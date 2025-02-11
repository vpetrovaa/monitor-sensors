package com.agsr.monitor_sensors.web.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {

    String message() default "Range from must be less than range to";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
