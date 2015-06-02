package com.vspavlov.demoorm.domain.hibervalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vasiliy on 02.06.15.
 */
@Target(value = {ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    String message() default "Such email allready exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
