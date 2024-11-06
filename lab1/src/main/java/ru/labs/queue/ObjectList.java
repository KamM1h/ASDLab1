package ru.labs.queue;

public class ObjectList<T>{
    private T object;
    private ObjectList<T> next;

    public ObjectList(T object, ObjectList<T> next){
        this.object = object;
        this.next = next;
    }

    public void setNext(ObjectList<T> next) {
        this.next = next;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public ObjectList<T> getNext() {
        return next;
    }
}