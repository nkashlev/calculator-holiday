package ru.kashlev.calculator_holiday.service.parse_json;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HolidayCount {
    private static final String URL_JSON = "https://api.bf5.ru/weekend/2023";
    private final Map<LocalDate, String> dateHashMap = new HashMap<>();

    private List<List<String>> listDate() {
        return new Connect().getJson(URL_JSON).getDay();
    }

    private int diffDays(LocalDate date1, LocalDate date2) {
        return date2.getDayOfYear() - date1.getDayOfYear();
    }

    private void stringToDate() {
        listDate().stream().forEach(x -> dateHashMap.put(LocalDate.parse(x.get(0), DateTimeFormatter.ofPattern("d.M.yyyy")), x.get(1)));
    }

    public int countDays(String startOfVacationString, String endOfVacationString) {
        stringToDate();
        int count = 0;
        LocalDate startOfVacationDate = LocalDate.parse(startOfVacationString, DateTimeFormatter.ofPattern("d.M.yyyy"));
        LocalDate endOfVacationDate = LocalDate.parse(endOfVacationString, DateTimeFormatter.ofPattern("d.M.yyyy"));
        for (int i = 0; i < diffDays(startOfVacationDate, endOfVacationDate); i++) {
            if (dateHashMap.get(startOfVacationDate.plusDays(i)) != null) {
                if (dateHashMap.get(startOfVacationDate.plusDays(i)).equals("holiday")) {
                    count++;
                }
            }
        }
        return count;
    }
}
