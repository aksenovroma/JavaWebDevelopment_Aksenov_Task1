package by.epam.javatraning.aksenov.task1.model.container.queue;

import by.epam.javatraning.aksenov.task1.model.container.array.ArrayStructure;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information
 * Class storing data in queue based on array
 */

public class ArrayQueue<T> implements Queue<T>, ArrayStructure {
    private static final int SIZE_DEFAULT = 5;

    private T[] elements;
    private int head;
    private int next;
    private int count;

    public ArrayQueue() {
        elements = (T[]) new Object[SIZE_DEFAULT];
    }

    public ArrayQueue(int size) {
        if (size >= 0) {
            elements = (T[]) new Object[size];
        }
    }

    public ArrayQueue(T[] elements) {
        if (elements != null) {
            this.elements = elements;
            count = elements.length;
        }
    }

    public void resize(int capacity) {
        if (capacity >= 0) {
            T[] temp = (T[]) new Object[capacity];

            for (int i = 0; i < count; i++) {
                temp[i] = elements[(head + i) % elements.length];
            }

            elements = temp;
            head = 0;
            next = count;
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

    @Override
    public void enqueue(T t) {
        if (elements.length == count) {
            resize(elements.length * 2);
        }
        elements[next++] = t;
        if (next == elements.length) {
            next = 0;
        }
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {

        }
        T element = elements[head];
        elements[head] = null;
        if (++head == elements.length) {
            head = 0;
        }
        if (--count > 0 && count == elements.length / 4) {
            resize(elements.length / 2);
        }
        return element;
    }
}
