package ru.kashlev.calculator_holiday.service.parse_json;

import java.util.List;

public class CalendarYear {
    private List<List<String>> day;
    private List<Integer> year;

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public List<List<String>> getDay() {
        return day;
    }

    public void setDay(List<List<String>> day) {
        this.day = day;
    }
}
