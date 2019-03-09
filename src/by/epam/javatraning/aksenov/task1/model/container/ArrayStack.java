package by.epam.javatraning.aksenov.task1.model.container;

public class ArrayStack<T> {
    private T[] elements;
    private int count;

    private final int n = 10;

    public ArrayStack() {
        this.elements = (T[]) new Object[n];
    }

    public ArrayStack(T[] elements) {
        this.elements = elements;
        this.count = elements.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public void push(T element) throws Exception{
        if (count == elements.length) {
            resize(elements.length + 10);
        }
        elements[count++] = element;
    }

    public T pop() throws Exception{
        if (isEmpty()) {
            throw new Exception("Стек пуст");
        }
        T element = elements[--count];
        elements[count] = null;

        if (count > 0 && count < elements.length - 10){
            resize(elements.length - 10);
        }

        return element;
    }

    public T peek() {
        return elements[count - 1];
    }

    public void resize(int max) {
        T[] tempElements = (T[]) new Object[max];
        for (int i = 0; i < count; i++) {
            tempElements[i] = elements[i];
        }
        elements = tempElements;

    }

}
