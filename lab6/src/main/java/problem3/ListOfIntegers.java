package problem3;

public interface ListOfIntegers {
    Boolean contains(Integer element);
    Integer elementAt(Integer index);
    Integer count();
    Integer sumElements();
    ListOfIntegers remove(Integer element);
}
