package ru.labs.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int detailTime = 0;
        int globalTime = 0;
        //RoundQueue<ElType> queue = new RoundQueue<>();
        ListQueue<ElType> queue = new ListQueue<>();

        do {
            try {
                System.out.println("Глобальное время: " + globalTime);
                System.out.println("Время детали: " + detailTime);
                System.out.println("Выберите действие: ");
                System.out.println("1. Поставить новую деталь на обработку");
                System.out.println("2. Переход к следующему моменту модельного времени");
                System.out.println("3. Снять деталь с обработки до ее завершения");
                System.out.println("4. Показать содержимое очереди");
                System.out.println("5. Сброс процесса моделирования");
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
                        if (!queue.isEmpty() && queue.front().getTimeForProcessing() == detailTime) {
                            queue.dequeue();
                            detailTime = 0;
                        }
                        else if(!queue.isEmpty() && queue.front().getTimeForProcessing() != detailTime) {
                            detailTime++;
                        }
                        else {
                            detailTime = 0;
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
                        if(!queue.isEmpty() && queue.getAllObjectsInQueue(list)!= null) {
                            for (int i = 0; i < queue.getSize(); i++) {
                                ElType element = list.get(i);
                                System.out.println(i + ". " + element.getDetailCode() + " " + element.getTimeForProcessing());
                            }
                        } else System.out.println("Список пуст");
                    }
                    case 5 -> {
                        System.out.println("Cброс процесса моделирования: ");
                        while(queue.dequeue() != null){
                            System.out.println("Деталь снята с обработки");
                        }
                        System.out.println("Все детали сняты с обработки");
                        detailTime = 0;
                        globalTime = 0;
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