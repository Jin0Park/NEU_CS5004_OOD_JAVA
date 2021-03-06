package problem1;

public class EmptyNode implements ListOfIntegers{

    public EmptyNode() {
    }

    @Override
    public Boolean contains(Integer element) {
        return Boolean.FALSE;
    }

    @Override
    public Integer elementAt(Integer index) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException("This list of Integers is empty");
    }

    @Override
    public Integer count() {
        return 0;
    }
}
