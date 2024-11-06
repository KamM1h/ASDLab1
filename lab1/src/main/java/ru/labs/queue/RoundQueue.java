package ru.labs.queue;

import java.util.LinkedList;

public class RoundQueue<T> extends Queue<T>{

    @Override
    public void enqueue(T newObject) {
        if (isEmpty()){
            head = new ObjectList<T>(newObject, new ObjectList<T>(null, null));
            tail = head.getNext();
            increaseSize();
        }else if (getSize()<5){
            increaseSize();
            tail.setObject(newObject);
            if(getSize() == 5){
                tail.setNext(head);
                tail = head;
            }else{
                tail.setNext(new ObjectList<T>(null, null));
                tail = tail.getNext();
            }
        }
        else{
            System.out.println("Невозможно добавить в очередь");
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            System.out.println("Список пуст");
            return null;
        }
        else if(isFull()){
            T object = head.getObject();
            head.setObject(null);
            head = head.getNext();
            tail.setNext(null);
            decreaseSize();
            return object;
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


    private Boolean isFull(){
        return tail == head;
    }

    @Override
    public LinkedList<T> getAllObjectsInQueue(){
        if(isEmpty()){
            System.out.println("Очередь пуста!!!\n");
            return null;
        }
        if(isFull()){
            LinkedList<T> list = new LinkedList<>(getAll(head.getNext()));
            return list;
        }
        else return getAll(head);

    }

    private LinkedList<T> getAll(ObjectList<T> el){
        if(el.getNext().getObject() != null && el!=tail){
            LinkedList<T> list = new LinkedList<>(getAll(el.getNext()));
            list.add(el.getObject());
            return list;
        } else{
            LinkedList<T> list = new LinkedList<>();
            list.add(el.getObject());
            return list;
        }
    }
}
