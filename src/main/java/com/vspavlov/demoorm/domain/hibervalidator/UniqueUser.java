package com.vspavlov.demoorm.domain.hibervalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vasiliy on 02.06.15.
 */

@Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserValidator.class)
@Documented
public @interface UniqueUser {
    String message() default "Such user allready exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
