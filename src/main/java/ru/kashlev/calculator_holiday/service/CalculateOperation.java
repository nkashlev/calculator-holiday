package ru.kashlev.calculator_holiday.service;

import org.springframework.stereotype.Service;
import ru.kashlev.calculator_holiday.models.Calculator;
import ru.kashlev.calculator_holiday.service.parse_json.HolidayCount;

import java.text.DecimalFormat;

@Service
public class CalculateOperation {
    HolidayCount holidayCount = new HolidayCount();

    public String calculate(Calculator calculator) {
        double value = calculator.getSalary() / calculator.getAverageMonthlyNumberOfDaysInYear() *
                (holidayCount.diffDays(calculator.getStart(), calculator.getEnd()) - holidayCount.countDays(calculator.getStart(), calculator.getEnd()));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);

    }

    public int countDayHoliday(Calculator calculator) {
        calculator.setCountDays(holidayCount.diffDays(calculator.getStart(), calculator.getEnd()));
        return calculator.getCountDays();
    }

    public Calculator clear(Calculator model) {
        model.setSalary(0);
        model.setCountDays(0);
        return model;
    }
}
