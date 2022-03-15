package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    private Music testSingleMusic1;
    private Music testBandMusic1;
    private Book testBook1;
    private Author testAuthor1;
    private RecordingArtist testRecordingArtist1;
    private RecordingArtist member1;
    private RecordingArtist member2;
    private RecordingArtist member3;
    private Band testBand1;
    private Music testSingleMusic2;
    private Book testBook2;
    private Author testAuthor2;
    private RecordingArtist testRecordingArtist2;
    private Catalog testCatalog;
    private Catalog emptyCatalog;
    private Author AuthorNotInList;
    private RecordingArtist SingerNotInList;

    @BeforeEach
    void setUp() throws ItemNullException {
        testAuthor1 = new Author("George Orwell");
        testAuthor2 = new Author("Jin Park");
        AuthorNotInList = new Author("Ernest Hemingway");

        testRecordingArtist1 = new RecordingArtist("Michael Jackson");
        testRecordingArtist2 = new RecordingArtist("Dominic Park");
        SingerNotInList = new RecordingArtist("Bruce Lee");

        member1 = new RecordingArtist("Michael Jackson");
        member2 = new RecordingArtist("Paul Jackson");
        member3 = new RecordingArtist("George Park");
        ArrayList<RecordingArtist> bandMembers = new ArrayList<>();
        bandMembers.add(member1);
        bandMembers.add(member2);
        bandMembers.add(member3);
        testBand1 = new Band("RockBand", bandMembers);

        testSingleMusic1 = new Music("Good Music", 1995, testRecordingArtist1);
        testSingleMusic2 = new Music("Very Good Song", 1995, testRecordingArtist2);
        testBandMusic1 = new Music("Band Music", 1980, testBand1);
        testBook1 = new Book("Good Book", 1970, testAuthor1);
        testBook2 = new Book("Very Good Novel", 1970, testAuthor2);

        ArrayList<LibraryCollection> collections = new ArrayList<>();
        ArrayList<LibraryCollection> emptyCollection = new ArrayList<>();
        emptyCatalog = new Catalog(emptyCollection);
        testCatalog = new Catalog(collections);
        testCatalog.collectItem(testSingleMusic1);
        testCatalog.collectItem(testSingleMusic2);
        testCatalog.collectItem(testBandMusic1);
        testCatalog.collectItem(testBook1);
        testCatalog.collectItem(testBook2);
    }

    @Test
    void getCollectionList() {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        assertEquals(collections, emptyCatalog.getCollectionList());
    }

    @Test
    void collectItem() throws ItemNullException {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        collections.add(testSingleMusic1);
        emptyCatalog.collectItem(testSingleMusic1);
        assertEquals(collections, emptyCatalog.getCollectionList());

        // Throws exception when the given item is null
        Exception ItemNullException = assertThrows(Exception.class, () -> emptyCatalog.collectItem(null));
        assertEquals("Invalid item!", ItemNullException.getMessage());
    }

    @Test
    void removeItem() throws ItemNullException, ItemNotFoundException {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        emptyCatalog.collectItem(testSingleMusic1);
        emptyCatalog.removeItem(testSingleMusic1);
        assertEquals(collections, emptyCatalog.getCollectionList());

        // Throws exception when the item is not in the list
        Exception ItemNotFoundException = assertThrows(Exception.class, () -> emptyCatalog.removeItem(testBook1));
        assertEquals("Item does not exist!", ItemNotFoundException.getMessage());
    }

    @Test
    void searchKeyword() throws ItemNotFoundException {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        collections.add(testSingleMusic1);
        collections.add(testBandMusic1);
        assertEquals(collections, testCatalog.search("music"));

        // Throws exception when the item is not in the list
        Exception ItemNotFoundException = assertThrows(Exception.class, () -> testCatalog.search("Great"));
        assertEquals("Item does not exist!", ItemNotFoundException.getMessage());
    }

    @Test
    void searchAuthor() throws ItemNotFoundException {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        collections.add(testBook1);
        assertEquals(collections, testCatalog.search(testAuthor1));

        collections.remove(testBook1);
        collections.add(testBook2);
        assertEquals(collections, testCatalog.search(testAuthor2));

        // Throws exception when the item is not in the list
        Exception ItemNotFoundException = assertThrows(Exception.class, () -> testCatalog.search(AuthorNotInList));
        assertEquals("Item does not exist!", ItemNotFoundException.getMessage());
    }

    @Test
    void searchArtist() throws ItemNotFoundException {
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        collections.add(testSingleMusic1);
        collections.add(testBandMusic1);
        assertEquals(collections, testCatalog.search(testRecordingArtist1));

        collections.remove(testSingleMusic1);
        collections.remove(testBandMusic1);
        collections.add(testSingleMusic2);
        assertEquals(collections, testCatalog.search(testRecordingArtist2));

        // Throws exception when the item is not in the list
        Exception ItemNotFoundException = assertThrows(Exception.class, () -> testCatalog.search(SingerNotInList));
        assertEquals("Item does not exist!", ItemNotFoundException.getMessage());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(testCatalog.equals(testCatalog));
    }

    @Test
    void testEquals_DifferentObject() {
        Author newAuthor = new Author("Christian Orwell");
        assertFalse(testCatalog.equals(newAuthor));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(testCatalog.equals(null));
    }

    @Test
    void testEquals_DifferentCollectionItems() throws ItemNullException {
        Author newAuthor1 = new Author("Good Author");
        RecordingArtist newSinger1 = new RecordingArtist("Good Singer");
        Music newMusic1 = new Music("Bad Music", 2010, newSinger1);
        Book newBook1 = new Book("Bad Song", 2020, newAuthor1);
        ArrayList<LibraryCollection> collections = new ArrayList<>();
        Catalog newCatalog = new Catalog(collections);
        newCatalog.collectItem(newMusic1);
        newCatalog.collectItem(newBook1);

        assertFalse(testCatalog.equals(newCatalog));
    }

    @Test
    void testEquals_DifferentObjectsSameAttribute() throws ItemNullException {
        Author newAuthor1 = new Author("George Orwell");
        Author newAuthor2 = new Author("Jin Park");
        RecordingArtist newSinger1 = new RecordingArtist("Michael Jackson");
        RecordingArtist newSinger2 = new RecordingArtist("Dominic Park");

        RecordingArtist member1 = new RecordingArtist("Michael Jackson");
        RecordingArtist member2 = new RecordingArtist("Paul Jackson");
        RecordingArtist member3 = new RecordingArtist("George Park");
        ArrayList<RecordingArtist> bandMembers = new ArrayList<>();
        bandMembers.add(member1);
        bandMembers.add(member2);
        bandMembers.add(member3);
        Band newBand = new Band("RockBand", bandMembers);

        Music newMusic1 = new Music("Good Music", 1995, newSinger1);
        Music newMusic2 = new Music("Very Good Song", 1995, newSinger2);
        Music newMusic3 = new Music("Band Music", 1980, newBand);
        Book newBook1 = new Book("Good Book", 1970, newAuthor1);
        Book newBook2 = new Book("Very Good Novel", 1970, newAuthor2);

        ArrayList<LibraryCollection> collections = new ArrayList<>();
        Catalog newCatalog = new Catalog(collections);
        newCatalog.collectItem(newMusic1);
        newCatalog.collectItem(newMusic2);
        newCatalog.collectItem(newMusic3);
        newCatalog.collectItem(newBook1);
        newCatalog.collectItem(newBook2);

        assertTrue(testCatalog.equals(newCatalog));
    }

    @Test
    void testHashCode() throws ItemNullException {
        Author newAuthor1 = new Author("George Orwell");
        Author newAuthor2 = new Author("Jin Park");
        RecordingArtist newSinger1 = new RecordingArtist("Michael Jackson");
        RecordingArtist newSinger2 = new RecordingArtist("Dominic Park");

        RecordingArtist member1 = new RecordingArtist("Michael Jackson");
        RecordingArtist member2 = new RecordingArtist("Paul Jackson");
        RecordingArtist member3 = new RecordingArtist("George Park");
        ArrayList<RecordingArtist> bandMembers = new ArrayList<>();
        bandMembers.add(member1);
        bandMembers.add(member2);
        bandMembers.add(member3);
        Band newBand = new Band("RockBand", bandMembers);

        Music newMusic1 = new Music("Good Music", 1995, newSinger1);
        Music newMusic2 = new Music("Very Good Song", 1995, newSinger2);
        Music newMusic3 = new Music("Band Music", 1980, newBand);
        Book newBook1 = new Book("Good Book", 1970, newAuthor1);
        Book newBook2 = new Book("Very Good Novel", 1970, newAuthor2);

        ArrayList<LibraryCollection> collections = new ArrayList<>();
        Catalog newCatalog = new Catalog(collections);
        newCatalog.collectItem(newMusic1);
        newCatalog.collectItem(newMusic2);
        newCatalog.collectItem(newMusic3);
        newCatalog.collectItem(newBook1);
        newCatalog.collectItem(newBook2);

        assertTrue(testCatalog.hashCode() == newCatalog.hashCode());
    }

    @Test
    void testToString() {
        String expectedCatalog = "Catalog{" +
                "collectionList=" + "[Music{title='Good Music', yearOut=1995, creator=RecordingArtist{firstname='Michael', lastname='Jackson'}}, Music{title='Very Good Song', yearOut=1995, creator=RecordingArtist{firstname='Dominic', lastname='Park'}}, Music{title='Band Music', yearOut=1980, creator=Band{name='RockBand', bandMember=[RecordingArtist{firstname='Michael', lastname='Jackson'}, RecordingArtist{firstname='Paul', lastname='Jackson'}, RecordingArtist{firstname='George', lastname='Park'}]}}, Book{title='Good Book', yearOut=1970, creator=Author{firstname='George', lastname='Orwell'}}, Book{title='Very Good Novel', yearOut=1970, creator=Author{firstname='Jin', lastname='Park'}}]" +
                '}';

        assertEquals(expectedCatalog, testCatalog.toString());
    }
}