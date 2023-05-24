package ru.kashlev.calculator_holiday.service.date_range_annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true; // если значение равно null, то пропускаем валидацию
        }

        try {
            // парсим значения дат из объекта
            Field fromDateField = value.getClass().getDeclaredField("start");
            fromDateField.setAccessible(true);
            LocalDate fromDate = LocalDate.parse(fromDateField.get(value).toString());

            Field toDateField = value.getClass().getDeclaredField("end");
            toDateField.setAccessible(true);
            LocalDate toDate = LocalDate.parse(toDateField.get(value).toString());


            // проверяем, что дата "от" меньше, чем дата "до" или даты равны
            if (fromDate.isBefore(toDate) || fromDate.equals(toDate)) {
                return true;
            } else {
                constraintValidatorContext.buildConstraintViolationWithTemplate("Invalid  end date range")
                        .addPropertyNode("end")
                        .addConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("Invalid start date range")
                        .addPropertyNode("start")
                        .addConstraintViolation();
                return false;
            }
        } catch (Exception e) {
            return false; // если произошла ошибка, то возвращаем false
        }
    }

}

