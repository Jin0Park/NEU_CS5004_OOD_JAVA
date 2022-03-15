import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InteriorTest {
  private Cleaning testCleaning;
  private Painting testPainting;

  @BeforeEach
  void setUp() {
    testCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, false, 9, 0);
    testPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, true, 5, 0);
  }

  @Test
  void getNumOfPets() {
    assertEquals(0, testCleaning.getNumOfPets());
    assertEquals(0, testPainting.getNumOfPets());
  }

  @Test
  void setNumOfPets() {
    testCleaning.setNumOfPets(8);
    assertEquals(8, testCleaning.getNumOfPets());
  }

  @Test
  void getPropertyAddress() {
    assertEquals("2022 Seattle Ave NE", testCleaning.getPropertyAddress());
    assertEquals("2023 Seattle Ave NE", testPainting.getPropertyAddress());
  }

  @Test
  void setPropertyAddress() {
    testCleaning.setPropertyAddress("2022 Bellevue Ave SE");
    assertEquals("2022 Bellevue Ave SE", testCleaning.getPropertyAddress());
  }

  @Test
  void getPropertySize() {
    assertEquals(PropertySize.LARGE, testCleaning.getPropertySize());
    assertEquals(PropertySize.MEDIUM, testPainting.getPropertySize());
  }

  @Test
  void setPropertySize() {
    testCleaning.setPropertySize(PropertySize.MEDIUM);
    assertEquals(PropertySize.MEDIUM, testCleaning.getPropertySize());
  }

  @Test
  void isMonthlyService() {
    assertEquals(false, testCleaning.isMonthlyService());
    assertEquals(true, testPainting.isMonthlyService());
  }

  @Test
  void setMonthlyService() {
    testCleaning.setMonthlyService(true);
    assertEquals(true, testCleaning.isMonthlyService());
  }

  @Test
  void getNumOfServiceReceived() {
    assertEquals(9, testCleaning.getNumOfServiceReceived());
    assertEquals(5, testPainting.getNumOfServiceReceived());
  }

  @Test
  void setNumOfServiceReceived() {
    testCleaning.setNumOfServiceReceived(15);
    assertEquals(15, testCleaning.getNumOfServiceReceived());
  }

  @Test
  void calculatePrice() {
    Painting testPaintingLarge = new Painting("large home", PropertySize.LARGE, true, 5, 0);
    // when there is no pet
    assertEquals(320.0, testCleaning.calculatePrice());
    assertEquals(1280.0, testPainting.calculatePrice()); // painting for MEDIUM property
    assertEquals(1920.0, testPaintingLarge.calculatePrice()); // painting for LARGE property
    // when there are two pets
    testCleaning.setNumOfPets(2);
    testPainting.setNumOfPets(2);
    testPaintingLarge.setNumOfPets(2);
    assertEquals(336.0, testCleaning.calculatePrice());
    assertEquals(1344.0, testPainting.calculatePrice());
    assertEquals(2016.0, testPaintingLarge.calculatePrice());
    // when there are more than or equal to 3 pets
    testCleaning.setNumOfPets(3);
    testPainting.setNumOfPets(3);
    testPaintingLarge.setNumOfPets(3);
    assertEquals(342.4, testCleaning.calculatePrice(), 2);
    assertEquals(1369.6, testPainting.calculatePrice(), 2);
    assertEquals(2054.4, testPaintingLarge.calculatePrice(), 2);
  }

  @Test
  void calculateHour() {
    Cleaning mediumClean = new Cleaning("home", PropertySize.MEDIUM, true, 2, 0);
    assertEquals(4, testCleaning.calculateHour());
    assertEquals(16, testPainting.calculateHour());
    assertEquals(2, mediumClean.calculateHour());
  }

  @Test
  void applyDiscount() {
    Cleaning newClean = new Cleaning("home", PropertySize.SMALL, false, 2, 0);
    Cleaning monthlyClean = new Cleaning("home", PropertySize.SMALL, true, 2, 0);
    assertEquals(160.0, testCleaning.applyDiscount());
    assertEquals(1152.0, testPainting.applyDiscount());
    assertEquals(80.0, newClean.applyDiscount());
    assertEquals(72.0, monthlyClean.applyDiscount());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testCleaning.equals(testCleaning));
    assertTrue(testPainting.equals(testPainting));
  }

  @Test
  void testEquals_DifferentObject() {
    //"home", PropertySize.LARGE, true, 18
    RoofGutterCleaning testRoofGutterCleaning = new RoofGutterCleaning("home", PropertySize.LARGE,true, 18, 1200.00, TypeOfRoof.HIPROOF);
    assertFalse(testCleaning.equals(testRoofGutterCleaning));
    assertFalse(testPainting.equals(testRoofGutterCleaning));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testCleaning.equals(null));
    assertFalse(testPainting.equals(null));
  }

  @Test
  void testEquals_DifferentPropertyAddress() {
    Cleaning newCleaning = new Cleaning("123 Seattle Ave NE", PropertySize.LARGE, false, 9, 0);
    Painting newPainting = new Painting("456 Seattle Ave NE", PropertySize.MEDIUM, true, 5, 0);
    assertFalse(testCleaning.equals(newCleaning));
    assertFalse(testPainting.equals(newPainting));
  }

  @Test
  void testEquals_DifferentPropertySize() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.SMALL, false, 9, 0);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.LARGE, true, 5, 0);
    assertFalse(testCleaning.equals(newCleaning));
    assertFalse(testPainting.equals(newPainting));
  }

  @Test
  void testEquals_DifferentIsMonthlyService() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, true, 9, 0);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, false, 5, 0);
    assertFalse(testCleaning.equals(newCleaning));
    assertFalse(testPainting.equals(newPainting));
  }

  @Test
  void testEquals_DifferentNumOfServiceReceived() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, false, 100, 0);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, true, 100, 0);
    assertFalse(testCleaning.equals(newCleaning));
    assertFalse(testPainting.equals(newPainting));

  }

  @Test
  void testEquals_DifferentNumOfPets() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, false, 9, 20);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, true, 5, 50);
    assertFalse(testCleaning.equals(newCleaning));
    assertFalse(testPainting.equals(newPainting));
  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, false, 9, 0);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, true, 5, 0);
    assertTrue(testCleaning.equals(newCleaning));
    assertTrue(testPainting.equals(newPainting));
  }

  @Test
  void testHashCode() {
    Cleaning newCleaning = new Cleaning("2022 Seattle Ave NE", PropertySize.LARGE, false, 9, 0);
    Painting newPainting = new Painting("2023 Seattle Ave NE", PropertySize.MEDIUM, true, 5, 0);
    assertTrue(newCleaning.hashCode() == testCleaning.hashCode());
    assertTrue(newPainting.hashCode() == testPainting.hashCode());
  }

  @Test
  void testToString() {
    String expectedStringCleaning = "Interior{" +
        "numOfPets=" + "0" +
        ", propertyAddress='" + "2022 Seattle Ave NE" + '\'' +
        ", propertySize=" + "LARGE" +
        ", isMonthlyService=" + "false" +
        ", numOfServiceReceived=" + "9" +
        '}';
    assertEquals(expectedStringCleaning, testCleaning.toString());
  }
}