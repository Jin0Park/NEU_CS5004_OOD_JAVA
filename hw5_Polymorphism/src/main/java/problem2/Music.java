package problem2;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Music.java
 * <p>
 * Music class stores information of a music. It inherits LibraryCollection class. It has two
 * constructors as the creator of a music can be a RecordingArtist or a Band.
 */
public class Music extends LibraryCollection {

  /**
   * Constructor of Music class
   *
   * @param title           - title of a library collection, as String
   * @param yearOut         - year published or released of a library collection, as integer
   * @param recordingArtist - creator of a library collection, as recordingArtist
   */
  public Music(String title, int yearOut, RecordingArtist recordingArtist) {
    super(title, yearOut, recordingArtist);
  }

  /**
   * Constructor of Music class
   *
   * @param title   - title of a library collection, as String
   * @param yearOut - year published or released of a library collection, as integer
   * @param band    - creator of a library collection, as Band
   */
  public Music(String title, int yearOut, Band band) {
    super(title, yearOut, band);
  }

  /**
   * toString method of Music
   */
  @Override
  public String toString() {
    return "Music{" +
        "title='" + title + '\'' +
        ", yearOut=" + yearOut +
        ", creator=" + creator +
        '}';
  }
}