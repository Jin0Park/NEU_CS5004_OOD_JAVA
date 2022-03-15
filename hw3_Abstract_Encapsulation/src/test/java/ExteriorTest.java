import static org.junit.jupiter.api.Assertions.*;

import hw3exceptions.ExceedMaxFloorException;
import java.awt.Window;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExteriorTest {
  private Gardening testGardening;
  private WindowCleaning testWindowCleaning;
  private RoofGutterCleaning testRoofGutterCleaning;

  @BeforeEach
  void setUp() throws ExceedMaxFloorException {
    testGardening = new Gardening("house with garden", PropertySize.LARGE, true, 5);
    testWindowCleaning = new WindowCleaning("house with windows", PropertySize.MEDIUM, false, 8, 2);
    testRoofGutterCleaning = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 8, 2500.00, TypeOfRoof.HIPROOF);
    // Throws exception when the number of floor exceeds 3
    Exception ExceedMaxFloorException = assertThrows(Exception.class, () -> testWindowCleaning = new WindowCleaning("house with windows", PropertySize.LARGE, false, 8, 5));
    assertEquals("Not available!", ExceedMaxFloorException.getMessage());
  }

  @Test
  void getNumOfFloors() {
    assertEquals(2, testWindowCleaning.getNumOfFloors());
  }

  @Test
  void setNumOfFloors() throws ExceedMaxFloorException {
    testWindowCleaning.setNumOfFloors(3);
    assertEquals(3, testWindowCleaning.getNumOfFloors());

    // Throws exception when the number of floor exceeds 3
    Exception ExceedMaxFloorException = assertThrows(Exception.class, () -> testWindowCleaning.setNumOfFloors(4));
    assertEquals("Not available!", ExceedMaxFloorException.getMessage());
  }

  @Test
  void getSquareFootageOfRoof() {
    assertEquals(2500.0, testRoofGutterCleaning.getSquareFootageOfRoof());
  }

  @Test
  void setSquareFootageOfRoof() {
    testRoofGutterCleaning.setSquareFootageOfRoof(10000.00);
    assertEquals(10000.0, testRoofGutterCleaning.getSquareFootageOfRoof());
  }

  @Test
  void getTypeOfRoof() {
    assertEquals(testRoofGutterCleaning.getTypeOfRoof(), TypeOfRoof.HIPROOF);
  }

  @Test
  void setTypeOfRoof() {
    testRoofGutterCleaning.setTypeOfRoof(TypeOfRoof.MANSARD);
    assertEquals(testRoofGutterCleaning.getTypeOfRoof(), TypeOfRoof.MANSARD);
  }

  @Test
  void calculatePrice() throws ExceedMaxFloorException {
    // test Gardening
    assertEquals(340.0, testGardening.calculatePrice());

    // test WindowCleaning
    assertEquals(168.0, testWindowCleaning.calculatePrice());
    // case when the number of floors is 1
    testWindowCleaning.setNumOfFloors(1);
    assertEquals(160.0, testWindowCleaning.calculatePrice());

    // test RoofGutterCleaning
    assertEquals(80.0, testRoofGutterCleaning.calculatePrice());
    testRoofGutterCleaning.setSquareFootageOfRoof(3600.00);
    assertEquals(130.0, testRoofGutterCleaning.calculatePrice());
    testRoofGutterCleaning.setTypeOfRoof(TypeOfRoof.MANSARD);
    assertEquals(330.0, testRoofGutterCleaning.calculatePrice());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testGardening.equals(testGardening));
    assertTrue(testWindowCleaning.equals(testWindowCleaning));
    assertTrue(testRoofGutterCleaning.equals(testRoofGutterCleaning));
  }

  @Test
  void testEquals_DifferentObject() {
    Painting testPainting = new Painting("home", PropertySize.LARGE, true, 8, 2);
    assertFalse(testGardening.equals(testPainting));
    assertFalse(testWindowCleaning.equals(testPainting));
    assertFalse(testRoofGutterCleaning.equals(testPainting));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testGardening.equals(null));
    assertFalse(testWindowCleaning.equals(null));
    assertFalse(testRoofGutterCleaning.equals(null));
  }

  @Test
  void testEquals_DifferentPropertyAddress() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("home", PropertySize.LARGE, true, 5);
    WindowCleaning newWindow = new WindowCleaning("home", PropertySize.MEDIUM, false, 8, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("home", PropertySize.SMALL, true, 8, 2500.00, TypeOfRoof.HIPROOF);
    assertFalse(testGardening.equals(newGarden));
    assertFalse(testWindowCleaning.equals(newWindow));
    assertFalse(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testEquals_DifferentPropertySize() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("house with garden", PropertySize.SMALL, true, 5);
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.LARGE, false, 8, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.MEDIUM, true, 8, 2500.00, TypeOfRoof.HIPROOF);
    assertFalse(testGardening.equals(newGarden));
    assertFalse(testWindowCleaning.equals(newWindow));
    assertFalse(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testEquals_DifferentIsMonthlyService() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("house with garden", PropertySize.LARGE, false, 5);
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.MEDIUM, true, 8, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, false, 8, 2500.00, TypeOfRoof.HIPROOF);
    assertFalse(testGardening.equals(newGarden));
    assertFalse(testWindowCleaning.equals(newWindow));
    assertFalse(testRoofGutterCleaning.equals(newRoof));  }

  @Test
  void testEquals_DifferentNumOfServiceReceived() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("house with garden", PropertySize.LARGE, true, 8);
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.MEDIUM, false, 1, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 2, 2500.00, TypeOfRoof.HIPROOF);
    assertFalse(testGardening.equals(newGarden));
    assertFalse(testWindowCleaning.equals(newWindow));
    assertFalse(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testEquals_DifferentNumOfFloors() throws ExceedMaxFloorException {
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.MEDIUM, false, 8, 1);
    assertFalse(testWindowCleaning.equals(newWindow));
  }

  @Test
  void testEquals_DifferentTypeOfRoof() {
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 8, 800.00, TypeOfRoof.FLAT);
    assertFalse(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testEquals_DifferentRoofFootage() {
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 8, 800.30, TypeOfRoof.HIPROOF);
    assertFalse(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("house with garden", PropertySize.LARGE, true, 5);
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.MEDIUM, false, 8, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 8, 2500.00, TypeOfRoof.HIPROOF);
    assertTrue(testGardening.equals(newGarden));
    assertTrue(testWindowCleaning.equals(newWindow));
    assertTrue(testRoofGutterCleaning.equals(newRoof));
  }

  @Test
  void testHashCode() throws ExceedMaxFloorException {
    Gardening newGarden = new Gardening("house with garden", PropertySize.LARGE, true, 5);
    WindowCleaning newWindow = new WindowCleaning("house with windows", PropertySize.MEDIUM, false, 8, 2);
    RoofGutterCleaning newRoof = new RoofGutterCleaning("house with roof", PropertySize.SMALL, true, 8, 2500.00, TypeOfRoof.HIPROOF);
    assertTrue(testGardening.hashCode() == newGarden.hashCode());
    assertTrue(testWindowCleaning.hashCode() == newWindow.hashCode());
    assertTrue(testRoofGutterCleaning.hashCode() == newRoof.hashCode());
  }

  @Test
  void testToString() {
    String expectedStringGardening = "PropertyService{" +
        "propertyAddress='" + "house with garden" + '\'' +
        ", propertySize=" + "LARGE" +
        ", isMonthlyService=" + "true" +
        ", numOfServiceReceived=" + "5" +
        '}';

    String expectedStringWindowCleaning = "WindowCleaning{" +
        "propertyAddress='" + "house with windows" + '\'' +
        ", propertySize=" + "MEDIUM" +
        ", isMonthlyService=" + "false" +
        ", numOfServiceReceived=" + "8" +
        ", numOfFloors=" + "2" +
        '}';

    String expectedStringRoofGutterCleaning = "RoofGutterCleaning{" +
        "propertyAddress='" + "house with roof" + '\'' +
        ", propertySize=" + "SMALL" +
        ", isMonthlyService=" + "true" +
        ", numOfServiceReceived=" + "8" +
        ", TypeOfRoof=" + "HIPROOF" +
        ", SquareFootageOfRoof=" + "2500.0" +
        '}';

    assertEquals(expectedStringGardening, testGardening.toString());
    assertEquals(expectedStringWindowCleaning, testWindowCleaning.toString());
    assertEquals(expectedStringRoofGutterCleaning, testRoofGutterCleaning.toString());
  }
}