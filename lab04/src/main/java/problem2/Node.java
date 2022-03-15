package ADT;

import java.util.Objects;

public class Node {

    private String element;
    private Node pointerToNextElement;

    public Node(String element, Node pointerToNextElement) {
        this.element = element;
        this.pointerToNextElement = pointerToNextElement;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Node getPointerToNextElement() {
        return pointerToNextElement;
    }

    public void setPointerToNextElement(Node pointerToNextElement) {
        this.pointerToNextElement = pointerToNextElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(element, node.element) && Objects.equals(pointerToNextElement, node.pointerToNextElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, pointerToNextElement);
    }

    @Override
    public String toString() {
        return "Node{" +
                "element='" + element + '\'' +
                ", pointerToNextElement=" + pointerToNextElement +
                '}';
    }
}
