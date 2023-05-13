package ru.kashlev.calculator_holiday.service.date_range_annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // указываем, что аннотация может использоваться только для классов
@Retention(RetentionPolicy.RUNTIME) // указываем, что аннотация будет доступна во время выполнения программы
@Constraint(validatedBy = DateRangeValidator.class) // указываем класс валидатора, который будет обрабатывать данную аннотацию
public @interface DateRange {
    String message() default "Invalid date range"; // сообщение об ошибке по умолчанию
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
