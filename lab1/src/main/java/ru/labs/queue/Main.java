package ru.labs.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int globalTime = 0;
        RoundQueue<ElType> queue = new RoundQueue<>();

        do {
            System.out.println("Выберите действие: ");
            System.out.println("1. Поставить новую деталь на обработку");
            System.out.println("2. Переход к следующему моменту модельного времени");
            System.out.println("3. Снять деталь с обработки до ее завершения");
            System.out.println("4. Показать содержимое очереди");
            System.out.println("5. Переключить модуль");
            System.out.println("0. Выход");

            switch (keyboard.nextInt()) {
                case 1:
                    System.out.println("Введите код детали:");
                    keyboard.nextLine();
                    String id = keyboard.nextLine();
                    System.out.println("Введите время обработки детали:");
                    int time = keyboard.nextInt();
                    System.out.println("Вы ввели: " + id + " " + time);
                    queue.enqueue(new ElType(id, time));
                    break;
                case 2:
                    System.out.println("Переход к следующему модельному времени");
                    globalTime++;
                    if(queue.front().getTimeForProcessing() == globalTime) {
                        queue.dequeue();
                        globalTime = 0;
                    }
                    break;
                case 3:
                    System.out.println("Деталь " + queue.dequeue().getDetailCode() + " снята с обработки");
                    break;
                case 4:
                    System.out.println("Содержимое очереди: ");
                    LinkedList<ElType> list = queue.getAllObjectsInQueue();
                    for(int i = 0; i < queue.getSize(); i++) {
                        ElType element = list.get(i);
                        System.out.println(i + ". " + element.getDetailCode() + " " + element.getTimeForProcessing());
                    }
                    break;
                case 5:
                    System.out.println("Модуль переключен");

                    //реализация
                default:
                    keyboard.close();
                    return;
            }
        } while (true);

    }
}