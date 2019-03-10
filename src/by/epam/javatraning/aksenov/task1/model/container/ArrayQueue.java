package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

import java.util.Arrays;
import java.util.Objects;

public class ArrayQueue<T> implements Queue<T> {
    private T[] elements;
    private int head;
    private int next;
    private int count;

    {
         elements = (T[]) new Object[5];
    }

    public ArrayQueue() {
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

    private void resize(int capacity) {
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
    public T dequeue() throws TechnicalProjectException {
        if (isEmpty()) {
            throw new TechnicalProjectException();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayQueue<?> that = (ArrayQueue<?>) o;
        return head == that.head &&
                next == that.next &&
                count == that.count &&
                Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(head, next, count);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "elements=" + Arrays.toString(elements) +
                ", head=" + head +
                ", next=" + next +
                ", count=" + count +
                '}';
    }
}
