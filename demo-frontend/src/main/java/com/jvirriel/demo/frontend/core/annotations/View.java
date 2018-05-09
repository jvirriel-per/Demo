package com.jvirriel.demo.frontend.core.annotations;

import com.jvirriel.demo.frontend.core.views.ViewMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface View {
    String name() default "";

    String uri() default "";

    String title() default "";

    Class target();

    ViewMode mode() default ViewMode.BROWSE;

    NavigationMode navMode() default NavigationMode.DETAIL;

    boolean isPrincipal() default false;
}