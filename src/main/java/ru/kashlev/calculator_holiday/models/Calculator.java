package ru.kashlev.calculator_holiday.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class Calculator {
    public static final double AVERAGE_MONTHLY_NUMBER_OF_DAYS_IN_YEAR = 29.3;
    @Min(value = 0, message = "Salary should be greater than 0")
    @NotEmpty(message = "Name should not be empty")
    private double salary;
    private int countDays;
    @NotEmpty(message = "Name should not be empty")
    private LocalDate start;
    @NotEmpty(message = "Name should not be empty")
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
