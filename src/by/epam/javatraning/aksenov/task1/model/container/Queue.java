package by.epam.javatraning.aksenov.task1.model.container;

import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;

/**
 * @author aksenov
 * @version 1.0
 *
 * Interface for implementation data structure - queue
 */

public interface Queue<T> extends MyCollection<T>{
    void enqueue(T t);
    T dequeue();
}
