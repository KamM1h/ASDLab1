package ru.labs.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int globalTime = 0;
        RoundQueue<ElType> queue = new RoundQueue<>();
        //ListQueue<ElType> queue = new ListQueue<>();

        do {
            try {
                System.out.println("Глобальное время: " + globalTime);
                System.out.println("Выберите действие: ");
                System.out.println("1. Поставить новую деталь на обработку");
                System.out.println("2. Переход к следующему моменту модельного времени");
                System.out.println("3. Снять деталь с обработки до ее завершения");
                System.out.println("4. Показать содержимое очереди");
                System.out.println("0. Выход");

                switch (keyboard.nextInt()) {
                    case 1 -> {
                        System.out.println("Введите код детали:");
                        keyboard.nextLine();
                        String id = keyboard.nextLine();
                        System.out.println("Введите время обработки детали:");
                        int time = keyboard.nextInt();
                        if(queue.enqueue(new ElType(id, time))){
                            System.out.println("Вы добавили: " + id + " " + time);
                        }else System.out.println("Не получилось добавить элемент");
                    }
                    case 2 -> {
                        System.out.println("Переход к следующему модельному времени");
                        globalTime++;
                        if (queue.front().getTimeForProcessing() == globalTime) {
                            queue.dequeue();
                            globalTime = 0;
                        }
                    }
                    case 3 -> {
                        String detailCode = queue.dequeue().getDetailCode();
                        System.out.println("Деталь " +
                                (detailCode != null ? detailCode: "список пуст")  + " снята с обработки");
                    }
                    case 4 -> {
                        System.out.println("Содержимое очереди: ");
                        LinkedList<ElType> list = new LinkedList<>();
                        if(queue.getAllObjectsInQueue(list)!= null) {
                            for (int i = 0; i < queue.getSize(); i++) {
                                ElType element = list.get(i);
                                System.out.println(i + ". " + element.getDetailCode() + " " + element.getTimeForProcessing());
                            }
                        } else System.out.println("Список пуст");
                    }
                    default -> {
                        keyboard.close();
                        return;
                    }
                }
            } catch (Exception e){
                System.out.println("Error");
            }
        } while (true);

    }
}