package ru.kashlev.calculator_holiday.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kashlev.calculator_holiday.models.Calculator;
import ru.kashlev.calculator_holiday.service.CalculateOperation;


@Controller
public class CalculatorController {

    Calculator calculator = new Calculator();
    private final CalculateOperation calculateOperation;

    public CalculatorController(CalculateOperation calculateOperation) {
        this.calculateOperation = calculateOperation;
    }

    @RequestMapping("/calculate")
    public String getCalculatorHomePage(Model model) {
        model.addAttribute("calculator", calculator);
        return "/calculate";
    }

    @RequestMapping(value = "/calculate", params = "calculate", method = RequestMethod.POST)
    public String add(@ModelAttribute("calculator") @Validated Calculator calculator, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/calculate";
        }
        model.addAttribute("result", calculateOperation.calculate(calculator));
        model.addAttribute("countDays", calculateOperation.countDayHoliday(calculator));
        return "/calculate";
    }

    @RequestMapping(value = "/calculate", params = "clear", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("calculator") Calculator calculator, Model model) {
        model.addAttribute("calculator", calculateOperation.clear(calculator));
        model.addAttribute("result", 0);
        return "/calculate";
    }
}
