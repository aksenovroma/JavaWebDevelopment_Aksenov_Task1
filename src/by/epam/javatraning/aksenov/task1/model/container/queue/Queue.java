package by.epam.javatraning.aksenov.task1.model.container.queue;

import by.epam.javatraning.aksenov.task1.model.container.MyCollection;

/**
 * @author aksenov
 * @version 1.0
 *
 * Interface for implementation data structure - queue
 */

public interface Queue<T> extends MyCollection<T> {
    void enqueue(T t);
    T dequeue();
}
