package com.Kandieiev.mulithreading;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    static class MyThread extends Thread{
        private String date;

        public MyThread(String date) {
            this.date = date;
        }

        @Override
        public void run(){
            LogsProcessor processor = new LogsProcessor();
            try {
                processor.getLogsByDateCount(date);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {

        LogsProcessor processor = new LogsProcessor();

        LocalDateTime start = LocalDateTime.now();
        System.out.println("========================================");
        System.out.println(processor.getLogsByDateCount("2019-10-21"));
        System.out.println(processor.getLogsByDateCount("2019-10-22"));
        System.out.println(processor.getLogsByDateCount("2019-10-23"));
        System.out.println(processor.getLogsByDateCount("2019-10-24"));
        System.out.println("========================================");
        System.out.println("TOTAL: " + ChronoUnit.MILLIS.between(start, LocalDateTime.now()));


        new MyThread("2019-10-21").start();
        new MyThread("2019-10-22").start();
        new MyThread("2019-10-23").start();
        new MyThread("2019-10-24").start();

    }
}
