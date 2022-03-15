import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  private Runner testRunner;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private Double expected5kTime;
  private Double expectedHalfMarathonTime;
  private String expectedLeague;
  private String expectedFavoriteEvent;

  @BeforeEach
  void setUp() {
    Name name = new Name("Allyson", "Michelle", "Felix");
    testRunner = new Runner(name, 168.0, 95.0, "US Track and Field",
        35.0, 178.00, "Olympics");
    expectedName = new Name("Allyson", "Michelle", "Felix");
    expectedHeight = 168.0;
    expectedWeight = 95.0;
    expected5kTime = 35.0;
    expectedHalfMarathonTime = 178.0;
    expectedLeague = "US Track and Field";
    expectedFavoriteEvent = "Olympics";
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testRunner.getAthletesName());

  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testRunner.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testRunner.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testRunner.getLeague());
  }

  @Test
  void getBest5KTime() {
    assertEquals(expected5kTime, testRunner.getBest5KTime());
  }

  @Test
  void getBestHalfMarathonTime() {
    assertEquals(expectedHalfMarathonTime, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals(expectedFavoriteEvent, testRunner.getFavoriteRunningEvent());
  }

  @Test
  void setBest5KTime() {
    testRunner.setBest5KTime(150.0);
    assertEquals(150.0, testRunner.getBest5KTime());
  }

  @Test
  void setBestHalfMarathonTime() {
    testRunner.setBestHalfMarathonTime(175.0);
    assertEquals(175.0, testRunner.getBestHalfMarathonTime());
  }

  @Test
  void setFavoriteRunningEvent() {
    testRunner.setFavoriteRunningEvent("Boston Marathon");
    assertEquals("Boston Marathon", testRunner.getFavoriteRunningEvent());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  void testEquals_NullObject() {
    Runner newTestRunner;
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    BaseballPlayer testBaseballPlayer = new BaseballPlayer(expectedName, 195.0, 165.0, "NFC",
        "Mariners", 5, 5);
    assertFalse(testRunner.equals(testBaseballPlayer));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Name newName = new Name("Hussain", "NA", "Bolt");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 35.0, 178.0, "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field",
        35.0, 178.00, "Olympics");
    assertTrue(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_Different5KTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 25.0, 178.0, "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_DifferentHalfMarathonTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 35.0, 165.0, "Olympics");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testEquals_DifferentVenue() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 35.0, 178.0,
        "Rock'n'Roll Marathon");
    assertFalse(testRunner.equals(newTestRunner));
  }

  @Test
  void testHashCode_SameFieldsOverall() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track and Field",
        35.0, 178.00, "Olympics");
    assertTrue(testRunner.hashCode() == newTestRunner.hashCode());
  }

  @Test
  void testHashCode_Different5KTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 25.0, 178.0, "Olympics");
    assertFalse(testRunner.hashCode() == newTestRunner.hashCode());
  }

  @Test
  void testHashCode_DifferentHalfMarathonTime() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 35.0, 165.0, "Olympics");
    assertFalse(testRunner.hashCode() == newTestRunner.hashCode());
  }

  @Test
  void testHashCode_DifferentVenue() {
    Name newName = new Name("Allyson", "Michelle", "Felix");
    Runner newTestRunner = new Runner(newName, 168.0, 95.0, "US Track", 35.0, 178.0,
        "Rock'n'Roll Marathon");
    assertFalse(testRunner.hashCode() == newTestRunner.hashCode());
  }
}
