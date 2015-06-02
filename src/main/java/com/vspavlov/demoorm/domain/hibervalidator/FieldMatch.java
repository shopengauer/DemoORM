package com.vspavlov.demoorm.domain.hibervalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Vasiliy on 26.05.2015.
 */

@Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {

    String message() default "{notmatch.passwords}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String firstValue();
    String secondValue();

    @Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE})
    @Retention(value = RetentionPolicy.RUNTIME)
    @Documented
    @interface List{

        FieldMatch[] value();
    }


}
