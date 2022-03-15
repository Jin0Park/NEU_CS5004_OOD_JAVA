package problem2;

import java.util.List;
import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 Band.java
 * <p>
 * Band class stores information of a band of a music. Inherits GroupArtist class.
 */
public class Band extends GroupArtist {

  protected List<RecordingArtist> bandMember;

  /**
   * Constructor of Band class
   *
   * @param name       - the name of the Creator, as String.
   * @param bandMember - the names of the band members, as List
   */
  public Band(String name, List<RecordingArtist> bandMember) {
    super(name);
    this.bandMember = bandMember;
  }

  /**
   * getter of bandMember
   *
   * @return the list of names of bandMembers
   */
  public List<RecordingArtist> getBandMember() {
    return bandMember;
  }

  /**
   * adds a RecordingArtist into the list of names of bandMembers
   *
   * @param r - a RecordingArtist to be added to bandMember list
   */
  public void addBandMember(RecordingArtist r) {
    this.bandMember.add(r);
  }

  /**
   * removes a RecordingArtist into the list of names of bandMembers
   *
   * @param r - a RecordingArtist to be removed from bandMember list
   * @throws BandMemberNotFoundException - throws exception when there is no given recording artist
   * in the band.
   */
  public void removeBandMember(RecordingArtist r) throws BandMemberNotFoundException {
    if (!this.bandMember.contains(r)) {
      throw new BandMemberNotFoundException("There is no such person in the band!");
    } else {
      this.bandMember.remove(r);
    }
  }

  /**
   * checks if a given Creator matches with the creator of a library collection. iterates through
   * the bandMember list and checks if there is a matching member with given Creator.
   *
   * @param c - Creator of a library collection
   * @return true if there is a matching member, false otherwise.
   */
  @Override
  public boolean matchedCreator(Creator c) {
    for (int i = 0; i < this.bandMember.size(); i++) {
      if (this.bandMember.get(i).equals(c)) {
        return true;
      }
    }
    return false;
  }

  /**
   * equals method of Band class
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(bandMember, band.bandMember);
  }

  /**
   * hashCode method of Band class
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), bandMember);
  }

  /**
   * toString method of Band class
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        ", bandMember=" + bandMember +
        '}';
  }
}