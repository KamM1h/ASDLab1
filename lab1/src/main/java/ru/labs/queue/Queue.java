package ru.labs.queue;

public abstract class Queue<List, T> {
    protected List head;
    protected List tail;
    private int size = 0;

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
        size++;
    }
}
