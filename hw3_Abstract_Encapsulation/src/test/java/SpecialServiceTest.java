import static org.junit.jupiter.api.Assertions.*;

import hw3exceptions.ExceedMaxFloorException;
import hw3exceptions.ExceedMaxLicensedEmployeeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialServiceTest {
  private Electrical testElectrical;
  private InternetTVComputing testInternetTVComputing;
  private Plumbing testPlumbing;
  private Electrical testElecNeedMoreWorker;
  private Electrical zeroWorkerHarshWork;
  private Electrical zeroWorkerSmoothWork;

  @BeforeEach
  void setUp() throws ExceedMaxLicensedEmployeeException {
    testElectrical = new Electrical("house without electricity", PropertySize.LARGE, true, 5, true, 3);
    testInternetTVComputing = new InternetTVComputing("house without internet", PropertySize.MEDIUM, true, 5, true, 2);
    testPlumbing = new Plumbing("house without good toilet", PropertySize.LARGE, true, 5, true, 3);
    testElecNeedMoreWorker = new Electrical("house without electricity", PropertySize.LARGE, true, 5, true, 1);
    zeroWorkerHarshWork = new Electrical("house without electricity", PropertySize.SMALL, true, 5, true, 0);
    zeroWorkerSmoothWork = new Electrical("house without electricity", PropertySize.SMALL, true, 5, false, 0);

    // Throws exception when the number of licensed employee for electrical service exceeds 4
    Exception ExceedMaxFloorException = assertThrows(Exception.class, () -> testElectrical = new Electrical("house without electricity", PropertySize.LARGE, true, 5, true, 8));
    assertEquals("Not Available!", ExceedMaxFloorException.getMessage());
    // Throws exception when the number of licensed employee for InternetTVComputing service exceeds 2
    Exception ExceedMaxFloorException1 = assertThrows(Exception.class, () -> testInternetTVComputing = new InternetTVComputing("house with windows", PropertySize.LARGE, false, 8, true, 8));
    assertEquals("Not Available!", ExceedMaxFloorException1.getMessage());
  }

  @Test
  void getNumOfSpecialistRequired() {
    assertEquals(3, testElectrical.getNumOfSpecialistRequired());
    assertEquals(2, testInternetTVComputing.getNumOfSpecialistRequired());
    assertEquals(3, testPlumbing.getNumOfSpecialistRequired());
    assertEquals(2, zeroWorkerHarshWork.getNumOfSpecialistRequired());
    assertEquals(1, zeroWorkerSmoothWork.getNumOfSpecialistRequired());
    assertEquals(3, testElecNeedMoreWorker.getNumOfSpecialistRequired());
  }

  @Test
  void setNumOfSpecialistRequired() throws ExceedMaxLicensedEmployeeException {
    testElectrical.setNumOfSpecialistRequired(4);
    assertEquals(4, testElectrical.getNumOfSpecialistRequired());
    testInternetTVComputing.setNumOfSpecialistRequired(1);
    assertEquals(1, testInternetTVComputing.getNumOfSpecialistRequired());
    testPlumbing.setNumOfSpecialistRequired(5);
    assertEquals(5, testPlumbing.getNumOfSpecialistRequired());

    assertEquals(4, testElectrical.getNumOfSpecialistRequired());
    // Throws exception when the number of licensed employee for electrical service exceeds 4
    Exception ExceedMaxFloorException = assertThrows(Exception.class, () -> testElectrical.setNumOfSpecialistRequired(8));
    assertEquals("Not Available!", ExceedMaxFloorException.getMessage());
    // Throws exception when the number of licensed employee for InternetTVComputing service exceeds 2
    Exception ExceedMaxFloorException1 = assertThrows(Exception.class, () -> testInternetTVComputing.setNumOfSpecialistRequired(8));
    assertEquals("Not Available!", ExceedMaxFloorException1.getMessage());
  }

  @Test
  void isComplex() {
    assertEquals(true, testElectrical.isComplex());
    assertEquals(true, testInternetTVComputing.isComplex());
    assertEquals(true, testPlumbing.isComplex());
  }

  @Test
  void setComplex() {
    testElectrical.setComplex(false);
    assertEquals(false, testElectrical.isComplex());
    testInternetTVComputing.setComplex(false);
    assertEquals(false, testInternetTVComputing.isComplex());
    testPlumbing.setComplex(false);
    assertEquals(false, testPlumbing.isComplex());
  }

  @Test
  void calculatePrice() {
    assertEquals(650.0, testElectrical.calculatePrice());
    assertEquals(415.0, testInternetTVComputing.calculatePrice());
    assertEquals(620.0, testPlumbing.calculatePrice());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testElectrical.equals(testElectrical));
    assertTrue(testInternetTVComputing.equals(testInternetTVComputing));
    assertTrue(testPlumbing.equals(testPlumbing));
  }

  @Test
  void testEquals_DifferentObject() {
    Painting testPainting = new Painting("home", PropertySize.LARGE, true, 8, 2);
    assertFalse(testElectrical.equals(testPainting));
    assertFalse(testInternetTVComputing.equals(testPainting));
    assertFalse(testPlumbing.equals(testPainting));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testElectrical.equals(null));
    assertFalse(testInternetTVComputing.equals(null));
    assertFalse(testPlumbing.equals(null));
  }

  @Test
  void testEquals_DifferentPropertyAddress() throws ExceedMaxLicensedEmployeeException {
    Electrical newElec = new Electrical("house with electricity", PropertySize.LARGE, true, 5, true, 3);
    InternetTVComputing newInternet = new InternetTVComputing("house with internet", PropertySize.MEDIUM, true, 5, true, 2);
    Plumbing newPlumbing = new Plumbing("house with good toilet", PropertySize.LARGE, true, 5, true, 3);
    assertFalse(testElectrical.equals(newElec));
    assertFalse(testInternetTVComputing.equals(newInternet));
    assertFalse(testPlumbing.equals(newPlumbing));
  }

  @Test
  void testEquals_DifferentPropertySize() throws ExceedMaxLicensedEmployeeException {
    Electrical newElec = new Electrical("house without electricity", PropertySize.SMALL, true, 5, true, 3);
    InternetTVComputing newInternet = new InternetTVComputing("house without internet", PropertySize.SMALL, true, 5, true, 2);
    Plumbing newPlumbing = new Plumbing("house without good toilet", PropertySize.SMALL, true, 5, true, 3);
    assertFalse(testElectrical.equals(newElec));
    assertFalse(testInternetTVComputing.equals(newInternet));
    assertFalse(testPlumbing.equals(newPlumbing));
  }

  @Test
  void testEquals_DifferentIsMonthlyService()
      throws ExceedMaxFloorException, ExceedMaxLicensedEmployeeException {
    Electrical newElec = new Electrical("house without electricity", PropertySize.LARGE, false, 5, true, 3);
    InternetTVComputing newInternet = new InternetTVComputing("house without internet", PropertySize.MEDIUM, false, 5, true, 2);
    Plumbing newPlumbing = new Plumbing("house without good toilet", PropertySize.LARGE, false, 5, true, 3);
    assertFalse(testElectrical.equals(newElec));
    assertFalse(testInternetTVComputing.equals(newInternet));
    assertFalse(testPlumbing.equals(newPlumbing));  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() throws ExceedMaxLicensedEmployeeException {
    Electrical newElec = new Electrical("house without electricity", PropertySize.LARGE, true, 5, true, 3);
    InternetTVComputing newInternet = new InternetTVComputing("house without internet", PropertySize.MEDIUM, true, 5, true, 2);
    Plumbing newPlumbing = new Plumbing("house without good toilet", PropertySize.LARGE, true, 5, true, 3);
    assertTrue(testElectrical.equals(newElec));
    assertTrue(testInternetTVComputing.equals(newInternet));
    assertTrue(testPlumbing.equals(newPlumbing));
  }

  @Test
  void testHashCode() throws ExceedMaxLicensedEmployeeException {
    Electrical newElec = new Electrical("house without electricity", PropertySize.LARGE, true, 5, true, 3);
    InternetTVComputing newInternet = new InternetTVComputing("house without internet", PropertySize.MEDIUM, true, 5, true, 2);
    Plumbing newPlumbing = new Plumbing("house without good toilet", PropertySize.LARGE, true, 5, true, 3);
    assertTrue(testElectrical.hashCode() == newElec.hashCode());
    assertTrue(testInternetTVComputing.hashCode() == newInternet.hashCode());
    assertTrue(testPlumbing.hashCode() == newPlumbing.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "SpecialService{" +
        "propertyAddress='" + "house without electricity" + '\'' +
        ", propertySize=" + "LARGE" +
        ", isMonthlyService=" + "true" +
        ", numOfServiceReceived=" + "5" +
        ", numOfSpecialistRequired=" + "3" +
        ", isComplex=" + "true" +
        '}';

    assertEquals(expectedString, testElectrical.toString());
  }
}
