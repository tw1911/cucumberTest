package ru.tw1911.testforsber.util;

import java.util.Deque;
import java.util.LinkedList;

public class SimpleStack <T> {
    Deque<T> deque = new LinkedList<>();
    public void push(T value){
        deque.push(value);
    }

    public T pop(){
        return deque.pop();
    }

    public T peek(){
        return deque.peek();
    }
}
