package com.company;
// 1. Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии,
// а другой ее поток выводит сообщение каждые 5 секунд. Предусмотрите возможность ежесекундного оповещения потока,
// воспроизводящего сообщение, потоком, отсчитывающим время.

//2.Не внося изменений в код потока-"хронометра",добавьте еще один поток,который выводит на экран другое сообщение
// каждые 7 секунд.Предполагается использование методов wait(),notifyAll().

public class Main {
    public static void main(String[] args) {
        Chronometer.setPointOfStart(System.currentTimeMillis());

        Thread myThr1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.print("Первый поток ");
                        Chronometer.printTimeSinceStartSession();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           }
        });

        Thread myThr2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        System.out.print("Второй поток ");
                        Chronometer.printTimeSinceStartSession();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread myThr3 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(7000);
                        System.out.print("Третий поток ");
                        Chronometer.printTimeSinceStartSession();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
            myThr1.start();
            myThr2.start();
        myThr3.start();
    }
}
