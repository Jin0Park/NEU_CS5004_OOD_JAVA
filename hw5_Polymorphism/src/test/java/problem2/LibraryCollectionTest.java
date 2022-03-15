package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LibraryCollectionTest {
    private Music testSingleMusic;
    private Music testBandMusic;
    private Book testBook;
    private Author testAuthor;
    private RecordingArtist testRecordingArtist;
    private RecordingArtist member1;
    private RecordingArtist member2;
    private RecordingArtist member3;
    private Band testBand;

    @BeforeEach
    void setUp() {
        testAuthor = new Author("George Orwell");
        testRecordingArtist = new RecordingArtist("Michael Jackson");
        member1 = new RecordingArtist("John Lennon");
        member2 = new RecordingArtist("Paul McCartney");
        member3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> bandMembers = new ArrayList<>();
        bandMembers.add(member1);
        bandMembers.add(member2);
        bandMembers.add(member3);
        testBand = new Band("RockBand", bandMembers);
        testSingleMusic = new Music("Single Music", 1995, testRecordingArtist);
        testBandMusic = new Music("Band Music", 1980, testBand);
        testBook = new Book("1984", 1970, testAuthor);
    }

    @Test
    void getTitle() {
        assertEquals("Single Music", testSingleMusic.getTitle());
        assertEquals("Band Music", testBandMusic.getTitle());
        assertEquals("1984", testBook.getTitle());
    }

    @Test
    void setTitle() {
        testSingleMusic.setTitle("Good Music");
        testBandMusic.setTitle("Very Good Music");
        testBook.setTitle("Animal Farm");
        assertEquals("Good Music", testSingleMusic.getTitle());
        assertEquals("Very Good Music", testBandMusic.getTitle());
        assertEquals("Animal Farm", testBook.getTitle());
    }

    @Test
    void getYearOut() {
        assertEquals(1995, testSingleMusic.getYearOut());
        assertEquals(1980, testBandMusic.getYearOut());
        assertEquals(1970, testBook.getYearOut());
    }

    @Test
    void setYearOut() {
        testSingleMusic.setYearOut(2010);
        testBandMusic.setYearOut(2000);
        testBook.setYearOut(1910);
        assertEquals(2010, testSingleMusic.getYearOut());
        assertEquals(2000, testBandMusic.getYearOut());
        assertEquals(1910, testBook.getYearOut());
    }

    @Test
    void getCreator() {
        assertEquals(testRecordingArtist, testSingleMusic.getCreator());
        assertEquals(testBand, testBandMusic.getCreator());
        assertEquals(testAuthor, testBook.getCreator());
    }

    @Test
    void setCreator() {
        Author newAuthor = new Author("Jin Park");
        RecordingArtist newSinger = new RecordingArtist("Dominic Park");
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);

        testSingleMusic.setCreator(newSinger);
        testBandMusic.setCreator(newTestBand);
        testBook.setCreator(newAuthor);

        assertEquals(newSinger, testSingleMusic.getCreator());
        assertEquals(newTestBand, testBandMusic.getCreator());
        assertEquals(newAuthor, testBook.getCreator());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testSingleMusic.equals(testSingleMusic));
        assertTrue(testBandMusic.equals(testBandMusic));
        assertTrue(testBook.equals(testBook));
    }

    @Test
    void testEquals_DifferentObject() {
        Author newAuthor = new Author("Christian Orwell");
        assertFalse(testSingleMusic.equals(newAuthor));
        assertFalse(testBandMusic.equals(newAuthor));
        assertFalse(testBook.equals(newAuthor));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testSingleMusic.equals(null));
        assertFalse(testBandMusic.equals(null));
        assertFalse(testBook.equals(null));
    }

    @Test
    void testEquals_DifferentTitle() {
        Book newBook = new Book("1990", 1970, testAuthor);
        Music newMusic = new Music("Band Music", 1995, testRecordingArtist);
        assertFalse(testSingleMusic.equals(newMusic));
        assertFalse(testBook.equals(newBook));
    }

    @Test
    void testEquals_DifferentYearOut() {
        Book newBook = new Book("1984", 1984, testAuthor);
        Music newMusic = new Music("Single Music", 1980, testRecordingArtist);
        assertFalse(testSingleMusic.equals(newMusic));
        assertFalse(testBook.equals(newBook));
    }

    @Test
    void testEquals_DifferentCreator() {
        Author newAuthor = new Author("Jin Park");
        RecordingArtist newSinger = new RecordingArtist("Dominic Park");
        Book newBook = new Book("1984", 1970, newAuthor);
        Music newMusic = new Music("Single Music", 1995, newSinger);
        assertFalse(testSingleMusic.equals(newMusic));
        assertFalse(testBook.equals(newBook));
    }

    @Test
    void testEquals_DifferentObjectsSameAttribute() {
        Author newAuthor = new Author("George Orwell");
        RecordingArtist newSinger = new RecordingArtist("Michael Jackson");
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);
        Music newSingleMusic = new Music("Single Music", 1995, newSinger);
        Music newBandMusic = new Music("Band Music", 1980, newTestBand);
        Book newBook = new Book("1984", 1970, newAuthor);
        assertTrue(testSingleMusic.equals(newSingleMusic));
        assertTrue(testBook.equals(newBook));
        assertTrue(testBandMusic.equals(newBandMusic));
    }

    @Test
    void testHashCode() {
        Author newAuthor = new Author("George Orwell");
        RecordingArtist newSinger = new RecordingArtist("Michael Jackson");
        RecordingArtist dude1 = new RecordingArtist("John Lennon");
        RecordingArtist dude2 = new RecordingArtist("Paul McCartney");
        RecordingArtist dude3 = new RecordingArtist("George Harrison");
        ArrayList<RecordingArtist> newBand = new ArrayList<>();
        newBand.add(dude1);
        newBand.add(dude2);
        newBand.add(dude3);
        Band newTestBand = new Band("RockBand", newBand);
        Music newSingleMusic = new Music("Single Music", 1995, newSinger);
        Music newBandMusic = new Music("Band Music", 1980, newTestBand);
        Book newBook = new Book("1984", 1970, newAuthor);

        assertTrue(testSingleMusic.hashCode() == newSingleMusic.hashCode());
        assertTrue(testBandMusic.hashCode() == newBandMusic.hashCode());
        assertTrue(testBook.hashCode() == newBook.hashCode());
    }

    @Test
    void testToString() {
        String expectedSingleMusic = "Music{" +
                "title='" + "Single Music" + '\'' +
                ", yearOut=" + "1995" +
                ", creator=" + "RecordingArtist{firstname='Michael', lastname='Jackson'}" +
                '}';
        String expectedBandMusic = "Music{" +
                "title='" + "Band Music" + '\'' +
                ", yearOut=" + "1980" +
                ", creator=" + "Band{name='RockBand', bandMember=[RecordingArtist{firstname='John', lastname='Lennon'}, RecordingArtist{firstname='Paul', lastname='McCartney'}, RecordingArtist{firstname='George', lastname='Harrison'}]}" +
                '}';
        String expectedBook = "Book{" +
                "title='" + "1984" + '\'' +
                ", yearOut=" + "1970" +
                ", creator=" + "Author{firstname='George', lastname='Orwell'}" +
                '}';
        assertEquals(expectedSingleMusic, testSingleMusic.toString());
        assertEquals(expectedBandMusic, testBandMusic.toString());
        assertEquals(expectedBook, testBook.toString());
    }
}