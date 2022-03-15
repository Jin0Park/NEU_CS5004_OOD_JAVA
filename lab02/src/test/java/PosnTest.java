import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosnTest {

  private Posn testPosn;

  @BeforeEach
  void setUp() {
    testPosn = new Posn(1, 2);
  }

  @Test
  void getX() {
    assertEquals(1, testPosn.getX());
  }

  @Test
  void getY() {
    assertEquals(2, testPosn.getY());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testPosn.equals(testPosn));
  }

  @Test
  void testEquals_NullObject() {
    Posn newTestPosn;
    assertFalse(testPosn.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Name testName = new Name("Jin", "NA", "Park");
    assertFalse(testPosn.equals(testName));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Posn newTestPosn = new Posn(3, 4);
    assertFalse(testPosn.equals(newTestPosn));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Posn newTestPosn = new Posn(1, 2);
    assertTrue(testPosn.equals(newTestPosn));
  }

  @Test
  void testEquals_DifferentX() {
    Posn newTestPosn = new Posn(5, 2);
    assertFalse(testPosn.equals(newTestPosn));
  }

  @Test
  void testEquals_DifferentY() {
    Posn newTestPosn = new Posn(1, 5);
    assertFalse(testPosn.equals(newTestPosn));
  }

  @Test
  void testHashCode_BothNull() {
    Posn newTestPosn = new Posn(null, null);
    assertTrue(newTestPosn.hashCode() == 0);
  }

  @Test
  void testHashCode_NullX() {
    Posn newTestPosn = new Posn(null, 2);
    assertTrue(newTestPosn.hashCode() == 2);
  }

  @Test
  void testHashCode_NullY() {
    Posn newTestPosn = new Posn(1, null);
    assertTrue(newTestPosn.hashCode() == 31);
  }
}