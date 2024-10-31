package ru.labs.queue;

public abstract class Queue<T> {
    private T head;
    private T back;
    private T next;

    public void enqueue(T newObject){
        if (next != null) {
            enqueue(newObject);
            back = newObject;
        }
        else {
            next = newObject;
            back = newObject;
        }
    }

    public T dequeue(){

    }

    private Boolean isEmpty(){

    }

    /*public boolean add(T newElement){

        return true;
    }
    public T delete(int id){
        return null;
    }


    //next model time
    public void goNext(){

    }*/

}
