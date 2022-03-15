package ADT;

public interface ListOfStrings {
    Boolean isEmpty();
    Integer size();
    Boolean contains(String element);
    Boolean containsAll(String[] elements);
    ListOfStrings filterLargerThan(int largerThanbound);
    Boolean hasDuplicates();
    ListOfStrings removeDuplicates();

}
