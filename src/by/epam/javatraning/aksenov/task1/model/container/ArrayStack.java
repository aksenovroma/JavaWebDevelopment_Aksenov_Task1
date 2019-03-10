package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information
 * Class storing data in stack based on array
 */

public class ArrayStack<T> implements Stack<T>{
    private T[] elements;
    private int count;

    {
        elements = (T[]) new Object[5];
    }

    public ArrayStack() {
    }

    public ArrayStack(int size) {
        if (size >= 0) {
            elements = (T[]) new Object[size];
        }
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

    public int size() {
        return elements.length;
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

    @Override
    public void push(T element) {
        if (count == elements.length) {
            resize(elements.length * 2);
        }
        elements[count++] = element;
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStack<?> that = (ArrayStack<?>) o;
        return count == that.count &&
                Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "elements=" + Arrays.toString(elements) +
                ", count=" + count +
                '}';
    }
}
