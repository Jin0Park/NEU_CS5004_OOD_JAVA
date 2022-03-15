package problem2;
/**
 * CS5004 Spring2022 Jin Young Park hw4 QueueInterface.java
 *
 * Interface of Queue class.
 */
public interface QueueInterface {
    QueueInterface emptyQueue();
    boolean isEmpty();
    QueueInterface add(int n);
    boolean contains(int n);
    QueueInterface remove();
    QueueInterface removeElement(int n);
    int size();
    int getIndex();
}
