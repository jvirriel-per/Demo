package com.jvirriel.demo.frontend.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Function:
 * Permite identificar las acciones en forma de anotacion.
 * Estas seran llamadas desde el/los menu(es)
 * Creado por bpena el 26/04/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Function {
    String action() default "";
}
