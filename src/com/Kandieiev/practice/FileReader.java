package com.Kandieiev.practice;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {

    private static final String pathIn = "D:/Лабораторные/Slovak/module4/logs.txt";
    public static void main(String[] args) throws IOException {
        LocalDateTime start = LocalDateTime.now();

//        String logsAsString = new String(Files.readAllBytes(Paths.get(pathIn)));
//        String[] lines = logsAsString.split(System.lineSeparator());
//        List<String> stringList = Arrays.stream(lines)
//                .filter(line -> line.contains("2019-10-13"))
//                .collect(Collectors.toList());
        String out = "";
//        for (int i = 0; i < stringList.size(); i++) {
//            out +=  stringList.get(i) + System.lineSeparator();
//        }
//        Path pathOut = Paths.get("D:/Лабораторные/Slovak/module4/logsOut.txt");
//        Files.write(pathOut, out.getBytes(StandardCharsets.UTF_8));
//        System.out.println(ChronoUnit.MILLIS.between(start, LocalDateTime.now()));

        // ==================================================
        start = LocalDateTime.now();
        StringBuilder sb = new StringBuilder("");
        Files.lines(Paths.get(pathIn))
                .filter(line -> line.contains("2019-10-13"))
                .forEach(line-> sb.append(line + System.lineSeparator()));
        Path pathOut = Paths.get("D:/Лабораторные/Slovak/module4/logsOut.txt");
        Files.write(pathOut, sb.toString().getBytes(StandardCharsets.UTF_8));
        System.out.println(ChronoUnit.MILLIS.between(start, LocalDateTime.now()));

        System.out.println(Files.lines(Paths.get(pathIn))
                .filter(line -> line.contains("ERROR"))
                .count() + " lines with ERROR");

        //==================================================

        start = LocalDateTime.now();
        Scanner scaner = new Scanner(new File(pathIn));
        List<String> linesByScanner = new ArrayList<>();
        while (scaner.hasNext()){
            String line = scaner.nextLine();
            if (line.contains("2019-10-13")){
                out += line + System.lineSeparator();
            }
        }
        Files.write(pathOut, out.getBytes(StandardCharsets.UTF_8));

        System.out.println(ChronoUnit.MILLIS.between(start, LocalDateTime.now()));



    }


}
