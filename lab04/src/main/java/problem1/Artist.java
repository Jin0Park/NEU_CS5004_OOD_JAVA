package problem1;

public interface Artist {
  //problem1.Artist receiveAward(String award); // this method being immutalbe is a rather non-ideal design choice, make
  boolean receiveAward(String award);
}
