package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

public interface Stack<T> {
    void push(T t);
    T pop() throws TechnicalProjectException;
}
