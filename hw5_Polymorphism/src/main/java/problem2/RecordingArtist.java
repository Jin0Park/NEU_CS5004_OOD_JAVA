package problem2;

/**
 * CS5004 Spring2022 Jin Young Park hw5 RecordingArtist.java
 * <p>
 * RecordingArtist class stores information of a recordingArtist of a music. Inherits SingleArtist
 * class.
 */
public class RecordingArtist extends SingleArtist {

  /**
   * Constructor of RecordingArtist class
   *
   * @param name - the name of the Creator, as String.
   */
  public RecordingArtist(String name) {
    super(name);
  }

  /**
   * toString method of RecordingArtist class
   */
  @Override
  public String toString() {
    return "RecordingArtist{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        '}';
  }
}