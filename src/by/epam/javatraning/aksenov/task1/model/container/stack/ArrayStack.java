package by.epam.javatraning.aksenov.task1.model.container.stack;

import by.epam.javatraning.aksenov.task1.model.container.array.ArrayStructure;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information
 * Class storing data in stack based on array
 */

public class ArrayStack<T> implements Stack<T>, ArrayStructure {
    private static final int SIZE_DEFAULT = 5;

    private T[] elements;
    private int count;

    public ArrayStack() {
        elements = (T[]) new Object[SIZE_DEFAULT];
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

    @Override
    public void push(T element) {
        if (count == elements.length) {
            resize(elements.length * 2);
        }
        elements[count++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T element = elements[--count];
        elements[count] = null;

        if (count > 0 && count == elements.length / 4){
            resize(elements.length / 2);
        }

        return element;
    }
}
