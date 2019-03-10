package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

public class ArrayStack<T> implements Stack<T>{
    private T[] elements;
    private int count;

    private final int n = 5;

    public ArrayStack() {
        this.elements = (T[]) new Object[n];
    }

    public ArrayStack(T[] elements) {
        if (elements != null) {
            this.elements = elements;
            count = elements.length;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public void push(T element) {
        if (count == elements.length) {
            resize(elements.length * 2);
        }
        elements[count++] = element;
    }

    public T pop() throws TechnicalProjectException{
        if (isEmpty()) {
            throw new TechnicalProjectException("Стек пуст");
        }
        T element = elements[--count];
        elements[count] = null;

        if (count > 0 && count == elements.length / 4){
            resize(elements.length / 2);
        }

        return element;
    }

    public T peek() {
        return elements[count - 1];
    }

    public void resize(int size) {
        if (size > elements.length) {
            T[] tempElements = (T[]) new Object[size];
            for (int i = 0; i < count; i++) {
                tempElements[i] = elements[i];
            }
            elements = tempElements;
        }
    }

    public int size() {
        return elements.length;
    }

}
