package com.shimizu.jpa.annotion;

import java.lang.annotation.*;

/**
 * @author Shimizu
 * @description
 * @date 2021-02-22 07:57
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface LogAnnotation {
    String value() default "";
}
