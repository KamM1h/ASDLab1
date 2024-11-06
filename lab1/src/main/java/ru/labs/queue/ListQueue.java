package ru.labs.queue;

import java.util.LinkedList;

public class ListQueue<T> extends Queue<T>{

    @Override
    public void enqueue(T newObject) {
        if (isEmpty()){
            head = new ObjectList<T>(newObject, new ObjectList<T>(null, null));
            tail = head.getNext();
            increaseSize();
        }else{
            increaseSize();
            tail.setObject(newObject);
            tail.setNext(new ObjectList<T>(null, null));
            tail = tail.getNext();
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            System.out.println("Список пуст");
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

//    @Override
//    public T front() {
//        if(isEmpty()) {
//            return head.getObject();
//        }else {
//            return null;
//        }
//    }

    @Override
    public T front() {
        if(isEmpty()) {
            return null;
        }else {
            return head.getObject();
        }
    }

    @Override
    public LinkedList<T> getAllObjectsInQueue(){
        return getAll(head);
    }

    public LinkedList<T> getAll(ObjectList<T> el){
        if(el.getNext() != null){
            LinkedList<T> list = new LinkedList<>(getAll(el.getNext()));
            return list;
        }
        else{
            LinkedList<T> list = new LinkedList<>();
            list.add(el.getObject());
            return list;
        }
    }
}
