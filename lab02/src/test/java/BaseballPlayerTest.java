import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  private BaseballPlayer testBaseballPlayer;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedTeam;
  private String expectedLeague;
  private Double expectedAverageBatting;
  private Integer expectedSeasonHomeRuns;

  @BeforeEach
  void setUp() {
    Name name = new Name("Lionel", "Andres", "Messi");
    testBaseballPlayer = new BaseballPlayer(name, 169.0, 67.0, "France League 1",
        "Paris Saint German", 0.8, 70);
    expectedName = new Name("Lionel", "Andres", "Messi");
    expectedHeight = 169.0;
    expectedWeight = 67.0;
    expectedTeam = "Paris Saint German";
    expectedLeague = "France League 1";
    expectedAverageBatting = 0.8;
    expectedSeasonHomeRuns = 70;
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testBaseballPlayer.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testBaseballPlayer.getHeight());
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testBaseballPlayer.getWeight());
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testBaseballPlayer.getLeague());
  }

  @Test
  void getTeam() {
    assertEquals(expectedTeam, testBaseballPlayer.getTeam());
  }

  @Test
  void setTeam() {
    testBaseballPlayer.setTeam("Barcelona FC");
    assertEquals("Barcelona FC", testBaseballPlayer.getTeam());
  }

  @Test
  void getAverageBatting() {
    assertEquals(expectedAverageBatting, testBaseballPlayer.getAverageBatting());
  }

  @Test
  void setAverageBatting() {
    testBaseballPlayer.setAverageBatting(0.5);
    assertEquals(0.5, testBaseballPlayer.getAverageBatting());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(expectedSeasonHomeRuns, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void setSeasonHomeRuns() {
    testBaseballPlayer.setSeasonHomeRuns(100);
    assertEquals(100, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void testEquals_SameMemoryLocation() {
    assertTrue(testBaseballPlayer.equals(testBaseballPlayer));
  }

  @Test
  void testEquals_NullObject() {
    BaseballPlayer newTestBaseballPlayer;
    assertFalse(testBaseballPlayer.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    Runner testRunner = new Runner(expectedName, 195.0, 165.0, "NFC", 75.0, 150.0,
        "Boston Marathon");
    assertFalse(testBaseballPlayer.equals(testRunner));
  }

  @Test
  void testEquals_DifferentInheritedFields() {
    Name newName = new Name("Sergio", "Leonel", "Aguero");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 168.0, 70.0, "La Liga",
        "Barcelona FC", 0.30, 35);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.8, 70);
    assertTrue(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentTeam() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Barcelona FC", 0.8, 70);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentAverageBatting() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.5, 70);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testEquals_DifferentSeasonHomeRuns() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.8, 90);
    assertFalse(testBaseballPlayer.equals(newTestBaseballPlayer));
  }

  @Test
  void testHashCode_SameFieldsOverall() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.8, 70);
    assertTrue(testBaseballPlayer.hashCode() == newTestBaseballPlayer.hashCode());
  }

  @Test
  void testHashCode_DifferentTeam() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Barcelona FC", 0.8, 70);
    assertFalse(testBaseballPlayer.hashCode() == newTestBaseballPlayer.hashCode());
  }

  @Test
  void testHashCode_DifferentAverageBatting() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.5, 70);
    assertFalse(testBaseballPlayer.hashCode() == newTestBaseballPlayer.hashCode());
  }

  @Test
  void testHashCode_DifferentSeasonHomeRuns() {
    Name newName = new Name("Lionel", "Andres", "Messi");
    BaseballPlayer newTestBaseballPlayer = new BaseballPlayer(newName, 169.0, 67.0,
        "France League 1",
        "Paris Saint German", 0.8, 90);
    assertFalse(testBaseballPlayer.hashCode() == newTestBaseballPlayer.hashCode());
  }
}
