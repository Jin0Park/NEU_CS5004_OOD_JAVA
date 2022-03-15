package problem2;

import java.util.Arrays;
import java.util.Objects;
/**
 * CS5004 Spring2022 Jin Young Park hw4 Queue.java
 *
 * Using an array, Queue stores integers and has queue functions. It contains getIndex, emptyQueue,
 * isEmpty, add, contains, remove, removeElement, and size methods.
 */
public class Queue implements QueueInterface {

  private final int[] container;
  private final int index;
  private final int newArrayLen = 10;

  /**
   * Constructor of Queue
   * @param container - an array to store integer values.
   * @param index - the index of queue.
   */
  public Queue(int[] container, int index) {
    this.container = container;
    this.index = index;
  }

  @Override
  /**
   * Gets the last index of the queue.
   * @return the last index as integer.
   */
  public int getIndex() {
    return index;
  }

  @Override
  /**
   * Creates and returns an empty Queue.
   */
  public QueueInterface emptyQueue() {
    int[] newContainer = new int[newArrayLen];
    return new Queue(newContainer, -1);
  }

  @Override
  /**
   * Checks if the Queue is empty. Returns true if the Queue contains no items, false otherwise.
   */
  public boolean isEmpty() {
    if (this.index == -1) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Adds the given Integer to the end of the Queue.
   */
  public QueueInterface add(int n) {
    int[] newContainer = Arrays.copyOf(this.container, this.container.length + 1);
    newContainer[this.container.length] = n;
    return new Queue(newContainer, getIndex() + 1);
  }

  @Override
  /**
   * Returns true if the given Integer is in the Queue, false otherwise.
   */
  public boolean contains(int n) {
    for (int i = 0; i < this.container.length; i++) {
      if (this.container[i] == n) {
        return true;
      }
    }
    return false;
  }

  @Override
  /**
   * Returns a copy of the Queue with the first element removed.
   */
  public QueueInterface remove() {
    int[] newContainer = Arrays.copyOfRange(this.container, 1, this.container.length);
    return new Queue(newContainer, this.index - 1);
  }

  @Override
  /**
   * Returns a copy of the Queue with the given Integer removed.
   * If the given Integer is not in the Queue, returns the Queue as is.
   */
  public QueueInterface removeElement(int n) {
    if (!contains(n)) {
      return new Queue(this.container, this.index);
    }
    boolean removed = false;
    int[] newContainer = new int[this.container.length - 1];
    int i = 0;
    while (i < this.container.length - 1) {
      if (removed == false && this.container[i] == n) {
        removed = true;
        i -= 1;
      } else {
        if (removed == false) {
          newContainer[i] = this.container[i];
        } else {
          newContainer[i] = this.container[i + 1];
        }
      }
      i += 1;
    }
    return new Queue(newContainer, this.index - 1);
  }

  @Override
  /**
   *  Gets the number of items in the Queue.
   */
  public int size() {
    return this.container.length;
  }

  @Override
  /**
   * equals method of Queue
   */
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Queue queue = (Queue) o;
    return index == queue.index && Arrays.equals(container, queue.container);
  }

  @Override
  /**
   * hashCode method of Queue
   */
  public int hashCode() {
    int result = Objects.hash(index);
    result = 31 * result + Arrays.hashCode(container);
    return result;
  }

  @Override
  /**
   * toString method of Queue
   */
  public String toString() {
    return "Queue{" +
        "container=" + Arrays.toString(container) +
        ", index=" + index +
        '}';
  }
}
