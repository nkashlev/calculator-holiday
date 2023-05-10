package ru.kashlev.calculator_holiday.service;

import org.springframework.stereotype.Service;
import ru.kashlev.calculator_holiday.models.Calculator;
import ru.kashlev.calculator_holiday.service.parse_json.HolidayCount;


import java.text.DecimalFormat;

@Service
public class CalculateOperation {

    public String calculate(Calculator calculator) {
        HolidayCount holidayCount = new HolidayCount();
        double value = calculator.getSalary() / calculator.getAverageMonthlyNumberOfDaysInYear() * (calculator.getCountDays() - holidayCount.countDays(calculator.getStart(), calculator.getEnd()));
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        return decimalFormat.format(value);
    }

    public Calculator clear(Calculator model) {
        model.setSalary(0);
        model.setCountDays(0);
        model.setAverageMonthlyNumberOfDaysInYear(0);
        return model;
    }
}
