package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * csvを取込後以下の順に並び替えて標準出力する
 * 最高気温の高い順, 最低気温の高い順, 平均気温の高い順, 日付の新しい順
 */
public class WeatherForecast {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    static List<WeatherData> weatherDataList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File file = new File("../JavaProgrammingTraining/src/main/java/com/example/csv/wf.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            while (str != null) {
                WeatherData weatherData = new WeatherData(str.split(","));
                weatherDataList.add(weatherData);
                str = br.readLine();
            }

            sortedData().forEach(v -> {
                System.out.println(getLineData(v).stream().collect(Collectors.joining(",")));
            });

            br.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    static Stream<WeatherData> sortedData() {
        return weatherDataList.stream().sorted(comparing(WeatherData::getMaxTemperature)
                .thenComparing(WeatherData::getMinTemperature)
                .thenComparing(WeatherData::getAvgTemperature)
                .thenComparing(WeatherData::getDate).reversed());
    }

    static List<String> getLineData(WeatherData data) {
        return Arrays.asList(String.valueOf(data.getMaxTemperature()),
                String.valueOf(data.getMinTemperature()),
                String.valueOf(data.getAvgTemperature()),
                sdf.format(data.getDate()));
    }

    @Data
    @NoArgsConstructor
    static class WeatherData {
        Date date;
        int maxTemperature;
        int minTemperature;
        double avgTemperature;

        WeatherData(String[] lineData) throws ParseException {
            this.date = sdf.parse(lineData[0]);
            this.maxTemperature = Integer.parseInt(lineData[1]);
            this.minTemperature = Integer.parseInt(lineData[2]);
            this.avgTemperature = Double.parseDouble(lineData[3]);
        }
    }
}
