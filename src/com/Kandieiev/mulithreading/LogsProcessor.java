package com.Kandieiev.mulithreading;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LogsProcessor {
    private String date;
    private final String FILE = "logs.txt";

    public LogsProcessor() {
    }

    public LogsProcessor(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFILE() {
        return FILE;
    }

    public int getLogsByDateCount(String date) throws IOException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(date + " - " + start+ " started");

        List<String> stringList = Files.lines(Paths.get(FILE))
                .filter(line -> line.contains(date))
                .filter(line -> line.contains("ERROR"))
                .collect(Collectors.toList());
        String out = "";
        for (int i = 0; i < stringList.size(); i++) {
            out +=  stringList.get(i) + System.lineSeparator();
        }
        int counts = stringList.size();
        Path pathOut = Paths.get("D:/Лабораторные/Slovak/module4/ERROR" + date + ".log");
        Files.write(pathOut, out.getBytes(StandardCharsets.UTF_8));

                System.out.println(date + " - " + LocalDateTime.now().toString() + " - " +
                ChronoUnit.MILLIS.between(start, LocalDateTime.now()) + " ms. Finished!");
        return counts;
    }
}
