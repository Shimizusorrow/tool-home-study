package com.shimizu.jpa.annotion;

import java.lang.annotation.*;

/**
 * @author Shimizu
 * @description
 * @date 2021-02-22 08:40
 */
@LogAnnotation
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SuperAnnotation {
    String value() default "";
}
