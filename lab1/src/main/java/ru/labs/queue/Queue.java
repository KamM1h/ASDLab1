package ru.labs.queue;

import java.util.LinkedList;

public abstract class Queue<T> {
    private int size;

    public abstract Boolean enqueue(T newObject);
    public abstract T dequeue();

    public int getSize(){
        return size;
    }

    public abstract Boolean isEmpty();
    public abstract Boolean isFull();
    public abstract T front();
    public void increaseSize(){
        size++;
    }
    public void decreaseSize(){
        size--;
    }
    public abstract LinkedList<T> getAllObjectsInQueue(LinkedList<T> list);
}
