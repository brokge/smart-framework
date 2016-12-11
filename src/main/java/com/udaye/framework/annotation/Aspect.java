package com.udaye.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by chenlw on 16-8-10.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     *
     * @return
     */
    Class<? extends Annotation> value();
}
