package ru.ifmo.base.lesson16.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // аннотировать можно только классы
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassConfig {
    // в качестве параметров можно использовать строки,
    // примитивы, enum
    // обязательно указать значение при использовании аннотации
    String prefix();
    long version() default 1;
}
