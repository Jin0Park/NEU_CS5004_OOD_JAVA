package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SingleArtistTest {
  private Author testAuthor;
  private RecordingArtist testRecordingArtist;
  private Creator testCreator;
  private Creator testNewCreator;

  @BeforeEach
  void setUp() {
    testAuthor = new Author("George Orwell");
    testRecordingArtist = new RecordingArtist("Michael Jackson");
    testCreator = new Author("Good Author");
    testNewCreator = new RecordingArtist("Good Singer");
  }

  @Test
  void getFirstname() {
    assertEquals("George", testAuthor.getFirstname());
    assertEquals("Michael", testRecordingArtist.getFirstname());
  }

  @Test
  void setFirstname() {
    testAuthor.setFirstname("Arthur");
    testRecordingArtist.setFirstname("Thomas");
    assertEquals("Arthur", testAuthor.getFirstname());
    assertEquals("Thomas", testRecordingArtist.getFirstname());
  }

  @Test
  void getLastname() {
    assertEquals("Orwell", testAuthor.getLastname());
    assertEquals("Jackson", testRecordingArtist.getLastname());
  }

  @Test
  void setLastname() {
    testAuthor.setLastname("Jordan");
    testRecordingArtist.setLastname("Peterson");
    assertEquals("Jordan", testAuthor.getLastname());
    assertEquals("Peterson", testRecordingArtist.getLastname());
  }

  @Test
  void getName() {
    assertEquals("George Orwell", testAuthor.getName());
    assertEquals("Michael Jackson", testRecordingArtist.getName());
  }

  @Test
  void setName() {
    testAuthor.setName("Jin Park");
    testRecordingArtist.setName("Dominic Park");
    assertEquals("Jin Park", testAuthor.getName());
    assertEquals("Dominic Park", testRecordingArtist.getName());
  }

  @Test
  void matchedCreator() {
    Author newAuthor = new Author ("George Orwell");
    RecordingArtist newRecordingArtist = new RecordingArtist ("Michael Jackson");
    assertEquals(true, testAuthor.matchedCreator(newAuthor));
    assertEquals(true, testRecordingArtist.matchedCreator(newRecordingArtist));
    Author wrongAuthor = new Author ("Jin Park");
    RecordingArtist wrongRecordingArtist = new RecordingArtist ("Dominic Park");
    assertEquals(false, testAuthor.matchedCreator(wrongAuthor));
    assertEquals(false, testRecordingArtist.matchedCreator(wrongRecordingArtist));
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testAuthor.equals(testAuthor));
    assertTrue(testRecordingArtist.equals(testRecordingArtist));
    assertTrue(testCreator.equals(testCreator));
    assertTrue(testNewCreator.equals(testNewCreator));
  }

  @Test
  void testEquals_DifferentObject() {
    ArrayList<RecordingArtist> bandMems = new ArrayList<>();
    Band newBand = new Band("coolband", bandMems);
    assertFalse(testAuthor.equals(newBand));
    assertFalse(testRecordingArtist.equals(newBand));
    assertFalse(testCreator.equals(newBand));
    assertFalse(testNewCreator.equals(newBand));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testAuthor.equals(null));
    assertFalse(testRecordingArtist.equals(null));
    assertFalse(testCreator.equals(null));
    assertFalse(testNewCreator.equals(null));
  }

  @Test
  void testEquals_DifferentFirstname() {
    Author newAuthor = new Author("Christian Orwell");
    RecordingArtist newSinger = new RecordingArtist("Douglas Jackson");
    assertFalse(testAuthor.equals(newAuthor));
    assertFalse(testRecordingArtist.equals(newSinger));
  }

  @Test
  void testEquals_DifferentLastname() {
    Author newAuthor = new Author("George Henderson");
    RecordingArtist newSinger = new RecordingArtist("Michael Mane");
    assertFalse(testAuthor.equals(newAuthor));
    assertFalse(testRecordingArtist.equals(newSinger));
  }

  @Test
  void testEquals_DifferentName() {
    Author newAuthor = new Author("Oliver Henderson");
    RecordingArtist newSinger = new RecordingArtist("Sadio Mane");
    assertFalse(testAuthor.equals(newAuthor));
    assertFalse(testRecordingArtist.equals(newSinger));
  }

  @Test
  void testEquals_DifferentObjectsSameAttribute() {
    Author newAuthor = new Author ("George Orwell");
    RecordingArtist newRecordingArtist = new RecordingArtist ("Michael Jackson");
    assertTrue(testAuthor.equals(newAuthor));
    assertTrue(testRecordingArtist.equals(newRecordingArtist));
  }
  @Test
  void testHashCode() {
    Author newAuthor = new Author ("George Orwell");
    RecordingArtist newRecordingArtist = new RecordingArtist ("Michael Jackson");
    assertTrue(testAuthor.hashCode() == newAuthor.hashCode());
    assertTrue(testRecordingArtist.hashCode() == newRecordingArtist.hashCode());
  }

  @Test
  void testToString() {
    String expectedAuthor = "Author{" +
        "firstname='" + "George" + '\'' +
        ", lastname='" + "Orwell" + '\'' +
        '}';

    String expectedRecordingArtist = "RecordingArtist{" +
        "firstname='" + "Michael" + '\'' +
        ", lastname='" + "Jackson" + '\'' +
        '}';
    assertEquals(expectedAuthor, testAuthor.toString());
    assertEquals(expectedRecordingArtist, testRecordingArtist.toString());
  }
}