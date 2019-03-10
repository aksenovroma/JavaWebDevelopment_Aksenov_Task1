package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

import java.util.Objects;

public class ListQueue<T> implements Queue<T> {
    private int count;

    private class Node {
        private T element;
        private Node next;
    }

    private Node first;
    private Node last;

    public ListQueue() {
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    @Override
    public void enqueue(T element) {
        Node current = last;
        last = new Node();
        last.element = element;

        if (count++ == 0) {
            first = last;
        } else {
            current.next = last;
        }
    }

    @Override
    public T dequeue() throws TechnicalProjectException {
        if (count == 0) {
            throw new TechnicalProjectException();
        }
        T element = first.element;
        first = first.next;

        if (--count == 0) {
            last = null;
        }
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListQueue<?> listQueue = (ListQueue<?>) o;
        return count == listQueue.count &&
                Objects.equals(first, listQueue.first) &&
                Objects.equals(last, listQueue.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, first, last);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListQueue{");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element).append(", ");
            temp = temp.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
