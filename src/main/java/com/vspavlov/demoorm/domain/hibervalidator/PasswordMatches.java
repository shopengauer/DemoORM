package com.vspavlov.demoorm.domain.hibervalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vasiliy on 03.06.15.
 */
@Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {

    String message() default "{notmatch.passwords}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
