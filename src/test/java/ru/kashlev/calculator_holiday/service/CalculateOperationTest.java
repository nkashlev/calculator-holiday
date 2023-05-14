package ru.kashlev.calculator_holiday.service;

import org.junit.jupiter.api.Test;
import ru.kashlev.calculator_holiday.models.Calculator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateOperationTest {
    Calculator calculator = new Calculator();
    CalculateOperation calculateOperation = new CalculateOperation();

    {
        calculator.setSalary(70000.0);
        calculator.setStart(LocalDate.of(2023, 4, 17));
        calculator.setEnd(LocalDate.of(2023, 4, 30));
    }

    @Test
    public void calculateTest() {
        String result = calculateOperation.calculate(calculator);
        assertEquals("33447,1", result);
    }

    @Test
    void countDayHolidayTest() {
        assertEquals(14, calculateOperation.countDayHoliday(calculator));
    }

    @Test
    void clearTest() {
        calculator.setSalary(0);
        calculator.setCountDays(0);
        calculator.setStart(LocalDate.of(2023, 1, 1));
        calculator.setEnd(LocalDate.of(2023, 12, 31));
        assertEquals(calculator, calculateOperation.clear(calculator));
    }
}