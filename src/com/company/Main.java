package com.company;

//Создать массив потоков . Для вычисления факториала N . каждый вычисляет факториал 10
//(Если компьютер не тянет - возьмите меньше).
//Сделать с помощью потоков и без помощи потоков. Замерить время выполнения
//(найти в интернете измерить время работы программы).
public class Main {
    public static int getFactorial(int f) {
        int res = 1;
        for (int i = 1; i <= f; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) throws InterruptedException {
        double start1 = System.nanoTime();
        Thread[] threads = new Thread[3];

        Runnable task = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " = " + getFactorial(i));

                }
            }
        };
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        double finish1 = System.nanoTime() - start1;


        double start2 = System.nanoTime();
        for (int i = 0; i <= 10; i++) {
            System.out.println("Я не поток! " + getFactorial(i));
        }
        double finish2 = System.nanoTime() - start2;

        System.out.println("\nTime 1 = " + finish1 / 1000);
        System.out.println("Time 2 = " + finish2 / 1000);
    }
}

