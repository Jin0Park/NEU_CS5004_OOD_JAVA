package problem3;

public interface ListOfLists {
    Integer size();
    Integer length();
    Integer sum();
    Boolean isEmpty();
    ListOfLists add(ListOfIntegers list);
    ListOfLists removeInteger(Integer element);
    ListOfLists removeAllIntegers(Integer element);
}
