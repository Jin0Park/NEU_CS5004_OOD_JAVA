package problem2;

import java.util.Objects;

public class Node {

  private NationalPark park;
  private Node nextNode;

  public Node(NationalPark park, Node nextNode) {
    this.park = park;
    this.nextNode = nextNode;
  }

  public NationalPark getPark() {
    return park;
  }

  public void setPark(NationalPark park) {
    this.park = park;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Node node = (Node) o;
    return Objects.equals(park, node.park) && Objects.equals(nextNode, node.nextNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(park, nextNode);
  }

  @Override
  public String toString() {
    return "Node{" +
        "park=" + park +
        ", nextNode=" + nextNode +
        '}';
  }
}