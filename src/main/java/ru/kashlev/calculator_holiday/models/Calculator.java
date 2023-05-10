package ru.kashlev.calculator_holiday.models;



public class Calculator {

    private String operation;

    private double salary;

    private int countDays;

    private String start;

    private String end;

    private double averageMonthlyNumberOfDaysInYear = 29.3;


    public Calculator(double salary, int countDays, String start, String end, double averageMonthlyNumberOfDaysInYear) {
        this.salary = salary;
        this.countDays = countDays;
        this.start = start;
        this.end = end;
        this.averageMonthlyNumberOfDaysInYear = averageMonthlyNumberOfDaysInYear;
    }

    public Calculator(String operation) {
        this.operation = operation;
    }

    public Calculator() {

    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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
        return averageMonthlyNumberOfDaysInYear;
    }

    public void setAverageMonthlyNumberOfDaysInYear(double averageMonthlyNumberOfDaysInYear) {
        this.averageMonthlyNumberOfDaysInYear = averageMonthlyNumberOfDaysInYear;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
