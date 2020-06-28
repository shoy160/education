package org.shay.education.test;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author shay
 * @date 2020/6/9
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EducationTest {
    @AliasFor("appName")
    String value() default "blade-test";

    @AliasFor("value")
    String appName() default "blade-test";

    String profile() default "dev";

    boolean enableLoader() default false;
}
