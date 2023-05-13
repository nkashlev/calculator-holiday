package ru.kashlev.calculator_holiday.models;



import ru.kashlev.calculator_holiday.service.date_range_annotation.DateRange;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@DateRange
public class Calculator {
    public static final double AVERAGE_MONTHLY_NUMBER_OF_DAYS_IN_YEAR = 29.3;
    @Min(value = 0, message = "Salary should be greater than 0")
    @NotNull(message = "Salary should not be empty")
    private double salary;
    private int countDays;

    @NotNull(message = "Date should not be empty")
    private LocalDate start;

    @NotNull(message = "Date should not be empty")
    private LocalDate end;

    public Calculator(double salary, int countDays, LocalDate start, LocalDate end) {
        this.salary = salary;
        this.countDays = countDays;
        this.start = start;
        this.end = end;
    }

    public Calculator() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCountDays() {
        return countDays;
    }

    public void setCountDays(int countDays) {
        this.countDays = countDays;
    }

    public double getAverageMonthlyNumberOfDaysInYear() {
        return AVERAGE_MONTHLY_NUMBER_OF_DAYS_IN_YEAR;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
