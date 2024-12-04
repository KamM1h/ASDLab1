package ru.labs.queue;

import java.util.LinkedList;

public class RoundQueue<T> extends Queue<T>{
    private int front, rear;
    private T[] array;

    public RoundQueue(){
        array = (T[]) new Object[6];
        front = 0;
        rear = 0;
    }

    @Override
    public Boolean isEmpty() {
        return rear == front;
    }
    @Override
    public Boolean isFull(){
        return (rear + 1) % 6 == front;
    }

    @Override
    public Boolean enqueue(T newObject) {
        if(isFull()){
            return false;
        }else{
            array[rear] = newObject;
            rear = (rear == 5) ? 0 : rear + 1;
            increaseSize();
            return true;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            return null;
        }else {
            int x = front;
            T object = array[x];
            front = (front == 5) ? 0 : front + 1;
            array[x] = null;
            decreaseSize();
            return object;
        }
    }

    @Override
    public T front() {
        if(isEmpty()) {
            return null;
        }else {
            return array[front];
        }
    }

    @Override
    public LinkedList<T> getAllObjectsInQueue(LinkedList<T> list){
        if(isEmpty()) return null;
        else {
            for (int i = 0; i<getSize(); i++){
                if(front + i > 5){
                    list.add(array[front + i - 6]);
                } else {
                    list.add(array[front + i]);
                }
            }
            return list;
        }

    }
}
