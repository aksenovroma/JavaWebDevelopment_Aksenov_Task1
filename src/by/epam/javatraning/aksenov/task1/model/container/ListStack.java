package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

import java.util.Objects;

/**
 * @author aksenov
 * @version 1.0
 *
 * Entity class for storing information
 * Class storing data in stack based on linked list
 */

public class ListStack<T> implements Stack<T> {
    private int count;

    private class Node {
        private T element;
        private Node next;
    }

    private Node first;

    public ListStack() {
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    @Override
    public void push(T element) {
        Node current = first;
        first = new Node();
        first.element = element;
        first.next = current;
        count++;
    }

    @Override
    public T pop() throws TechnicalProjectException {
        if (first == null) {
            throw new TechnicalProjectException();
        }
        T element = first.element;
        first = first.next;
        count--;
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListStack<?> listStack = (ListStack<?>) o;
        return count == listStack.count &&
                Objects.equals(first, listStack.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListStack{");
        Node temp = first;

        while (temp != null) {
            sb.append(temp.element).append(", ");
            temp = temp.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
