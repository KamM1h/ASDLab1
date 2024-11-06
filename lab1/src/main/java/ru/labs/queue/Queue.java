package ru.labs.queue;

import java.util.LinkedList;

public abstract class Queue<T> {
    protected ObjectList<T> head;
    protected ObjectList<T> tail;
    private int size;

    public abstract void enqueue(T newObject);
    public abstract T dequeue();

    public int getSize(){
        return size;
    }

    public Boolean isEmpty(){
        return head == null;
    }
    public abstract T front();
    public void increaseSize(){
        size++;
    }
    public void decreaseSize(){
        size--;
    }
    public abstract LinkedList<T> getAllObjectsInQueue();
}
