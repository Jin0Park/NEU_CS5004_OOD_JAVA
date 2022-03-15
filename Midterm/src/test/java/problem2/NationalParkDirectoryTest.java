package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.DigitalArt;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NationalParkDirectoryTest {
    private NationalPark testParkA;
    private NationalPark testParkB;
    private NationalPark testParkC;
    private NationalPark testParkD;
    private NationalPark testParkModified;
    private NationalPark testFailPark;
    private NationalParkDirectory testNationalParkDir;
    private String[] centers;

    @BeforeEach
    void setUp() {
        centers = new String[]{"toilet", "customer service"};
        testParkA = new NationalPark("1", "Seattle Park", "WA", 5000.0, LocalDate.of(2020, 12, 30), centers, true);
        testParkB = new NationalPark("2", "LA Park", "CA", 100000.0, LocalDate.of(2005, 5, 28), centers, false);
        testParkC = new NationalPark("3", "Bellevue Park", "WA", 2500.0, LocalDate.of(2010, 3, 5), centers, true);
        testParkD = new NationalPark("4", "NY Park", "NY", 3500.0, LocalDate.of(2015, 12, 5), centers, false);
        testParkModified = new NationalPark("1", "Downtown Park", "WA", 6800.0, LocalDate.of(2022, 1, 30), centers, true);
        testFailPark = new NationalPark("8", "Fail", "WA", 100.0, LocalDate.of(2022, 3, 11), centers, false);
        testNationalParkDir = new NationalParkDirectory();
    }

    @Test
    void count() throws NationalParkAlreadyExistException {
        assertEquals(0, testNationalParkDir.count());
        testNationalParkDir.add(testParkA);
        assertEquals(1, testNationalParkDir.count());
    }

    @Test
    void check() throws NationalParkAlreadyExistException {
        assertEquals(false, testNationalParkDir.check(testParkA));
        testNationalParkDir.add(testParkA);
        assertEquals(true, testNationalParkDir.check(testParkA));
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        assertEquals(true, testNationalParkDir.check(testParkB));
        assertEquals(false, testNationalParkDir.check(testParkD));
    }

    @Test
    void add() throws NationalParkAlreadyExistException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        assertEquals(true, testNationalParkDir.check(testParkA));
        assertEquals(true, testNationalParkDir.check(testParkB));
        assertEquals(true, testNationalParkDir.check(testParkC));
        assertEquals(3, testNationalParkDir.count());

        // exception case where the park to be added already exist in the list
        Exception NationalParkAlreadyExistException = assertThrows(Exception.class,
                () -> testNationalParkDir.add(testParkA));
        assertEquals("The park to be added already exist in the list", NationalParkAlreadyExistException.getMessage());
    }

    @Test
    void modify() throws NationalParkAlreadyExistException, NationalParkNotFoundException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.modify(testParkModified);
        assertEquals(3, testNationalParkDir.count());
        assertEquals(true, testNationalParkDir.check(testParkModified));

        // exception case where the park to be modified does not exist in the list
        Exception NationalParkNotFoundException = assertThrows(Exception.class,
                () -> testNationalParkDir.modify(testFailPark));
        assertEquals("The park does not exist in the collection.", NationalParkNotFoundException.getMessage());
    }

    @Test
    void remove() throws NationalParkAlreadyExistException, NationalParkNotFoundException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.remove(testParkA);
        assertEquals(2, testNationalParkDir.count());
        assertEquals(false, testNationalParkDir.check(testParkA));

        // exception case where the park to be removed does not exist in the list
        Exception NationalParkNotFoundException = assertThrows(Exception.class,
                () -> testNationalParkDir.remove(testFailPark));
        assertEquals("The park does not exist in the collection.", NationalParkNotFoundException.getMessage());
    }

    @Test
    void findOneParkInSameState() throws NationalParkAlreadyExistException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.add(testParkD);
        assertEquals(testParkA, testNationalParkDir.findOneParkInSameState("WA"));
    }

    @Test
    void findMultipleParksInSameState() throws NationalParkAlreadyExistException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.add(testParkD);
        ArrayList<NationalPark> result = new ArrayList<>();
        result.add(testParkA);
        result.add(testParkC);
        assertEquals(result, testNationalParkDir.findMultipleParksInSameState("WA"));
        ArrayList<NationalPark> anotherResult = new ArrayList<>();
        anotherResult.add(testParkB);
        assertEquals(anotherResult, testNationalParkDir.findMultipleParksInSameState("CA"));
    }

    @Test
    void findParksOpenedInYear() throws NationalParkAlreadyExistException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.add(testParkD);
        ArrayList<NationalPark> result = new ArrayList<>();
        result.add(testParkA);
        result.add(testParkC);
        assertEquals(result, testNationalParkDir.findParksOpenedInYear());
    }

    @Test
    void findParkByID() throws NationalParkAlreadyExistException, NationalParkNotFoundException {
        testNationalParkDir.add(testParkA);
        testNationalParkDir.add(testParkB);
        testNationalParkDir.add(testParkC);
        testNationalParkDir.add(testParkD);
        assertEquals(testParkA, testNationalParkDir.findParkByID("1"));
        assertEquals(testParkB, testNationalParkDir.findParkByID("2"));
        assertEquals(testParkC, testNationalParkDir.findParkByID("3"));
        assertEquals(testParkD, testNationalParkDir.findParkByID("4"));

        // exception case where the park with the given ID does not exist in the list
        Exception NationalParkNotFoundException = assertThrows(Exception.class,
                () -> testNationalParkDir.findParkByID("135"));
        assertEquals("The park does not exist in the collection.", NationalParkNotFoundException.getMessage());
    }
}