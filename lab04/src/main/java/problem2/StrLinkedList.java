package ADT;

public class StrLinkedList implements ListOfStrings {
    private Node head;

    public StrLinkedList(Node head) {
        this.head = head;
    }

    public StrLinkedList(){
        this.head = null;
    }

    @Override
    public Boolean isEmpty() {
        return (this.head == null);
    }

    @Override
    public Integer size() {
        if (isEmpty())
            return 0;
        else {
            int counter = 0;
            Node currentNode = this.head;

            while (currentNode.getPointerToNextElement() != null) {
                counter++;
                currentNode = currentNode.getPointerToNextElement();
            }
            return counter;
        }
    }

    @Override
    public Boolean contains(String element) {
        if (!isEmpty()){
            Node currentNode = this.head;
            while (currentNode.getPointerToNextElement() != null) {
                if(currentNode.getElement().equals(element))
                    return true;
                currentNode = currentNode.getPointerToNextElement();
            }
        }
        return false;
    }

    @Override
    public Boolean containsAll(String[] elements) {
        return null;
    }

    @Override
    public ListOfStrings filterLargerThan(int largerThanbound) {
        StrLinkedList filteredList = new StrLinkedList();
        if (!isEmpty()){
            Node currentNode = this.head;
            while (currentNode.getPointerToNextElement() != null) {
                if(currentNode.getElement().length() < largerThanbound) {
                    filteredList.add(currentNode);
                }
            }
       }
        return filteredList;
    }

    private StrLinkedList add(Node nodeToAdd){
        if(this.isEmpty())
            return new StrLinkedList(nodeToAdd);
        else{
            Node newNode = new Node(nodeToAdd.getElement(), this.head);
            return new StrLinkedList(newNode);
        }

    }

    @Override
    public Boolean hasDuplicates() {
        return null;
    }

    @Override
    public ListOfStrings removeDuplicates() {
        return null;
    }

    @Override
    public String toString() {
        return "StrLinkedList{" +
                "head=" + head +
                '}';
    }
}
