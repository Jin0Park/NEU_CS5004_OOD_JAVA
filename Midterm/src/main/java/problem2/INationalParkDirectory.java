package problem2;

import java.util.ArrayList;

public interface INationalParkDirectory {

  Integer count();
  Boolean check(NationalPark park);
  void add(NationalPark park) throws NationalParkAlreadyExistException;
  void modify(NationalPark park) throws NationalParkNotFoundException;
  void remove(NationalPark park) throws NationalParkNotFoundException;
  NationalPark findOneParkInSameState(String state);
  ArrayList<NationalPark> findMultipleParksInSameState(String state);
  ArrayList<NationalPark> findParksOpenedInYear();
  NationalPark findParkByID(String id) throws NationalParkNotFoundException;
}
