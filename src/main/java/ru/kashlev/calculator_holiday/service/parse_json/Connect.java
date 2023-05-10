package ru.kashlev.calculator_holiday.service.parse_json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {
    public CalendarYear getJson(String urlStr) {
        CalendarYear calendarYear = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                calendarYear = objectMapper.readValue(conn.getInputStream(), CalendarYear.class);
            } else {
                System.out.println("GET request not worked");
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendarYear;
    }
}
