package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

/**
 * @author aksenov
 * @version 1.0
 *
 * Interface for implementation data structure - stack
 */

public interface Stack<T> extends MyCollection<T>{
    void push(T t);
    T pop();
}
