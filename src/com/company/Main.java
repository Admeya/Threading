package com.company;
// 1. Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии,
// а другой ее поток выводит сообщение каждые 5 секунд. Предусмотрите возможность ежесекундного оповещения потока,
// воспроизводящего сообщение, потоком, отсчитывающим время.

//2.Не внося изменений в код потока-"хронометра",добавьте еще один поток,который выводит на экран другое сообщение
// каждые 7 секунд.Предполагается использование методов wait(),notifyAll().

import java.io.IOException;
import java.util.Date;

public class Main {



    public static void main(String[] args) {
        long startMs = 1000;

        Thread myThr1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(startMs);
                    System.out.println("Первый поток " + (Chronometer.getTimeSinceStartSession() + startMs));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
        });

        Thread myThr2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("Второй поток " + (Chronometer.getTimeSinceStartSession() + startMs));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        while(true) {
            myThr1.start();
            myThr2.start();
        }
    }
}
