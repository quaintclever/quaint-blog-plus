package com.quaint.blog.annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @author: qi cong
 * @Date: Created in 2019-12-11 10:25
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckLogin {

    boolean value() default true;

}
