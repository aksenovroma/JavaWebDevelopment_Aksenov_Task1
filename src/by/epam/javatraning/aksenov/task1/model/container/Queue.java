package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

public interface Queue<T> {
    void enqueue(T t);
    T dequeue() throws TechnicalProjectException;
}
