package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GroupArtistTest {
    private RecordingArtist member1;
    private RecordingArtist member2;
    private RecordingArtist member3;
    private RecordingArtist foreigner;
    private Band testBand;
    private Creator creatorBand;

    @BeforeEach
    void setUp() {
        member1 = new RecordingArtist("John Lennon");
        member2 = new RecordingArtist("Paul McCartney");
        member3 = new RecordingArtist("George Harrison");
        foreigner = new RecordingArtist("Liam Gallagher");
        ArrayList<RecordingArtist> bandMembers = new ArrayList<>();
        bandMembers.add(member1);
        bandMembers.add(member2);
        bandMembers.add(member3);
        testBand = new Band("RockBand", bandMembers);
        creatorBand = new Band("CreatorBand", bandMembers);
    }

    @Test
    void matchedCreator() {
        RecordingArtist artistToFind = new RecordingArtist("John Lennon");
        assertEquals(true, testBand.matchedCreator(artistToFind));
        RecordingArtist wrongArtist = new RecordingArtist("Liam Gallagher");
        assertEquals(false, testBand.matchedCreator(wrongArtist));
    }

    @Test
    void getBandMember() {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        assertEquals(newBand, testBand.getBandMember());
    }

    @Test
    void addBandMember() {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        RecordingArtist dude4 = new RecordingArtist("Liam Gallagher");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        newBand.add(dude4);
        testBand.addBandMember(dude4);
        assertEquals(newBand, testBand.getBandMember());
    }

    @Test
    void removeBandMember() throws BandMemberNotFoundException {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        testBand.removeBandMember(member3);
        assertEquals(newBand, testBand.getBandMember());

        // Throws exception when the processing date is before the creation date
        Exception BandMemberNotFoundException = assertThrows(Exception.class,
                () -> testBand.removeBandMember(foreigner));
        assertEquals("There is no such person in the band!",
                BandMemberNotFoundException.getMessage());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testBand.equals(testBand));
        assertTrue(creatorBand.equals(creatorBand));
    }

    @Test
    void testEquals_DifferentObject() {
        Author newAuthor = new Author("Christian Orwell");
        assertFalse(testBand.equals(newAuthor));
        assertFalse(creatorBand.equals(newAuthor));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testBand.equals(null));
        assertFalse(creatorBand.equals(null));
    }

    @Test
    void testEquals_DifferentBandName() {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("NoBand", newBand);
        assertFalse(testBand.equals(newTestBand));
    }

    @Test
    void testEquals_DifferentBandMembers() {
        RecordingArtist dude1 = new RecordingArtist("Liam Gallagher");
        RecordingArtist dude2 = new RecordingArtist("Noel Gallagher");
        RecordingArtist dude3 = new RecordingArtist("Paul Arthurs");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);
        assertFalse(testBand.equals(newTestBand));
    }

    @Test
    void testEquals_DifferentObjectsSameAttribute() {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);
        assertTrue(testBand.equals(newTestBand));
    }

    @Test
    void testHashCode() {
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);
        assertTrue(testBand.hashCode() == newTestBand.hashCode());
    }

    @Test
    void testToString() {
        String expectedBand = "Band{" +
                "name='" + "RockBand" + '\'' +
                ", bandMember=" + "[RecordingArtist{firstname='John', lastname='Lennon'}, RecordingArtist{firstname='Paul', lastname='McCartney'}, RecordingArtist{firstname='George', lastname='Harrison'}]" +
                '}';
        assertEquals(expectedBand, testBand.toString());
    }
}