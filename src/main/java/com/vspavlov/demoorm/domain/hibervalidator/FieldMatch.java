package com.vspavlov.demoorm.domain.hibervalidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vasiliy on 26.05.2015.
 */

@Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FieldMatch {
}
