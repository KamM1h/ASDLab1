package ru.labs.queue;

import java.util.LinkedList;

public class ListQueue<T> extends Queue<T>{

    protected ObjectList<T> head;
    protected ObjectList<T> tail;

    @Override
    public Boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Boolean isFull(){return false;}
    @Override
    public Boolean enqueue(T newObject) {
        try {
            if (isEmpty()) {
                head = new ObjectList<T>(newObject, new ObjectList<T>(null, null));
                tail = head.getNext();
                increaseSize();
            } else {
                increaseSize();
                tail.setObject(newObject);
                tail.setNext(new ObjectList<T>(null, null));
                tail = tail.getNext();
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            return null;
        }
        else{
            T object = head.getObject();
            head.setObject(null);
            head = head.getNext();
            decreaseSize();
            return object;
        }
    }

    @Override
    public T front() {
        if(isEmpty()) {
            return null;
        }else {
            return head.getObject();
        }
    }

    @Override
    public LinkedList<T> getAllObjectsInQueue(LinkedList<T> list){
        return getAll(head, list);
    }

    public LinkedList<T> getAll(ObjectList<T> el, LinkedList<T> list){
        if(el.getNext() != tail){
            list.add(el.getObject());
            return getAll(el.getNext(), list);
        }
        else{
            list.add(el.getObject());
            return list;
        }
    }
}
