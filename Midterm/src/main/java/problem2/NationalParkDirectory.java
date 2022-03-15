package problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park Midterm problem2 NationalParkDirectory.java
 * <p>
 * NationalParkDirectory stores information about National Parks in a LinkedList.
 */

public class NationalParkDirectory implements INationalParkDirectory {

  private Node head;
  private int numNodes;

  /**
   * Constructor of NationalParkDirectory head - head node of the linked list numNodes - the number
   * of nodes in the linked list
   */
  public NationalParkDirectory() {
    this.head = null;
    this.numNodes = 0;
  }

  /**
   * Count the number of National Parks in the list
   *
   * @return the number of National Parks in the list
   */
  @Override
  public Integer count() {
    return this.numNodes;
  }

  /**
   * Checks if the given park is in the list
   *
   * @return True if the given park is in the list, otherwise false
   */
  @Override
  public Boolean check(NationalPark park) {
    if (this.numNodes == 0) {
      return Boolean.FALSE;
    } else {
      Node currentNode = this.head;
      while (currentNode != null) {
        if (currentNode.getPark().equals(park)) {
          return Boolean.TRUE;
        }
        currentNode = currentNode.getNextNode();
      }
    }
    return Boolean.FALSE;
  }

  /**
   * Adds the given park into the list
   *
   * @param park - the National Park to be added to the list
   * @throws NationalParkAlreadyExistException - throws exception when the given park already exists
   *                                           in the list
   */
  @Override
  public void add(NationalPark park) throws NationalParkAlreadyExistException {
      if (this.check(park)) {
          throw new NationalParkAlreadyExistException(
              "The park to be added already exist in the list");
      }

    Node newNode = new Node(park, null);
    if (this.numNodes == 0) {
      this.head = newNode;
    } else {
      Node currentNode = this.head;
      while (currentNode.getNextNode() != null) {
        currentNode = currentNode.getNextNode();
      }
      currentNode.setNextNode(newNode);
    }
    this.numNodes++;
  }

  /**
   * Modifies the information of a park. Finds the park to be modified with the park's unique
   * identifier ID, and replace it with the given park.
   *
   * @param park - the park to be modified
   * @throws NationalParkNotFoundException - throws an exception when the given park does not exist
   *                                       in the list
   */
  @Override
  public void modify(NationalPark park) throws NationalParkNotFoundException {
    Boolean modified = Boolean.FALSE;
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getPark().getNationalParkID().equals(park.getNationalParkID())) {
        currentNode.setPark(park);
        modified = Boolean.TRUE;
      }
      currentNode = currentNode.getNextNode();
    }
      if (!modified) {
          throw new NationalParkNotFoundException("The park does not exist in the collection.");
      }
  }

  /**
   * Removes a park from the list
   *
   * @param park - a park to be removed from the list
   * @throws NationalParkNotFoundException - throws exception when the park to be modified does not
   *                                       exist in the list
   */
  @Override
  public void remove(NationalPark park) throws NationalParkNotFoundException {
      if (!this.check(park)) {
          throw new NationalParkNotFoundException("The park does not exist in the collection.");
      }
    if (this.head.getPark().equals(park)) {
      this.head = this.head.getNextNode();
      this.numNodes--;
    } else {
      Node currentNode = this.head;
      while (currentNode.getNextNode() != null) {
        if (currentNode.getNextNode().getPark().equals(park)) {
          currentNode.setNextNode(currentNode.getNextNode().getNextNode());
          this.numNodes--;
        }
        currentNode = currentNode.getNextNode();
      }
    }

  }

  /**
   * Find and return one National Park from the list that is located within the given state
   *
   * @param state - a state in String
   * @return one National Park from the list that is located within the given state
   */
  @Override
  public NationalPark findOneParkInSameState(String state) {
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getPark().getState().equals(state)) {
        return currentNode.getPark();
      }
      currentNode = currentNode.getNextNode();
    }
    return null;
  }

  /**
   * Find and return all National Parks from the list that are located within the given state
   *
   * @param state - a state in String
   * @return an ArrayList of National Parks from the list that are located within the given state
   */
  @Override
  public ArrayList<NationalPark> findMultipleParksInSameState(String state) {
    ArrayList<NationalPark> parks = new ArrayList<>();
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getPark().getState().equals(state)) {
        parks.add(currentNode.getPark());
      }
      currentNode = currentNode.getNextNode();
    }
    return parks;
  }

  /**
   * Find and return all National Parks from the list that are opened year round
   *
   * @return an ArrayList of National Parks from the list that opened year round
   */
  @Override
  public ArrayList<NationalPark> findParksOpenedInYear() {
    ArrayList<NationalPark> parks = new ArrayList<>();
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getPark().getOpenYearRound()) {
        parks.add(currentNode.getPark());
      }
      currentNode = currentNode.getNextNode();
    }
    return parks;
  }

  /**
   * Find a National Park by its unique identifier, NationalParkID.
   *
   * @param id - a National Park's unique identifier, NationalParkID in String
   * @return a National Park that matches with the given ID
   * @throws NationalParkNotFoundException - throws an exception when there is no park with the
   *                                       given ID.
   */
  @Override
  public NationalPark findParkByID(String id) throws NationalParkNotFoundException {
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.getPark().getNationalParkID().equals(id)) {
        return currentNode.getPark();
      }
      currentNode = currentNode.getNextNode();
    }
    throw new NationalParkNotFoundException("The park does not exist in the collection.");
  }

  /**
   * equals method of NationalParkDirectory
   */
  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    NationalParkDirectory that = (NationalParkDirectory) o;
    return numNodes == that.numNodes && Objects.equals(head, that.head);
  }

  /**
   * hashCode method of NationalParkDirectory
   */
  @Override
  public int hashCode() {
    return Objects.hash(head, numNodes);
  }

  /**
   * toString method of NationalParkDirectory
   */
  @Override
  public String toString() {
    return "NationalParkDirectory{" +
        "head=" + head +
        ", numNodes=" + numNodes +
        '}';
  }
}
