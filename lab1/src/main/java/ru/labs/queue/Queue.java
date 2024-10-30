package ru.labs.queue;

public abstract class Queue<T> {

    private T next;

    public boolean add(T newElement){

        return true;
    }
    public T delete(int id){
        return null;
    }


    //next model time
    public void goNext(){

    }

}
