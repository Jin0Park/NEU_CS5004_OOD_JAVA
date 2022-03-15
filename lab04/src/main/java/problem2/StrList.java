package ADT;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Objects;
import java.util.*;

public class StrList implements ListOfStrings {

    private int listSize;
    private String[] container;
    private static final int INITIAL_CAPACITY = 10;

    public StrList(int listSize, String[] container) {
        this.listSize = listSize;
        this.container = container;
    }

    public StrList() {
        this.listSize = 0;
        this.container = new String[INITIAL_CAPACITY];
    }

    @Override
    public Boolean isEmpty() {
        return (this.listSize == 0);
    }

    @Override
    public Integer size() {
        return this.listSize;
    }

    @Override
    public Boolean contains(String element) {
        for (int index = 0; index < this.listSize; index++) {
            if (this.container[index].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean containsAll(String[] elements) {
        boolean hasit = true;
        for (int outerIndex = 0; outerIndex < elements.length; outerIndex ++) {
            for (int innerIndex = 0; innerIndex < this.listSize; innerIndex++){
                if(this.container[innerIndex].equals(elements[outerIndex])) {
                    hasit = true;
                    break;
                } else {
                    hasit = false;
                }
            }
            if (hasit == false) {
                return false;
            }
        }
        return true;
    }

    private String getElement(int index){
        if (index >= 0 && index <= this.listSize) {
            return this.container[index];
        }
        return null;
    }

    @Override
    public ListOfStrings filterLargerThan(int largerThanbound) {
        String[] newArray = new String[this.listSize];
        int newArrayIndex = 0;
        for (int index = 0; index < this.listSize; index++){
            if(this.container[index].length() > largerThanbound) {
                newArray[newArrayIndex] = container[index];
                newArrayIndex ++;
            }
        }
        this.container = newArray;
        this.listSize = newArrayIndex;
        // subtype polymorphism. will talk about it in week 5.
        return this;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrList strList = (StrList) o;
        return listSize == strList.listSize && Arrays.equals(container, strList.container);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(listSize);
        result = 31 * result + Arrays.hashCode(container);
        return result;
    }
}
