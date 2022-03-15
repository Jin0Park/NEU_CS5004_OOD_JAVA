package problem2;

import java.util.Objects;

/**
 * CS5004 Spring2022 Jin Young Park hw5 SingleArtist.java
 * <p>
 * SingleArtist class stores information of a single artist of a library collection. It is super
 * class of Author and RecordingArtist. Inherits Creator class.
 */
public abstract class SingleArtist extends Creator {

  protected String firstname;
  protected String lastname;

  /**
   * Constructor of SingleArtist class Also has firstname and lastname fields which is from the
   * given name of the Creator.
   *
   * @param name - the name of the Creator, as String.
   */
  public SingleArtist(String name) {
    super(name);
    String names[] = super.name.split(" ", 2);
    firstname = names[0];
    lastname = names[1];
  }

  /**
   * getter of firstname
   *
   * @return firstname of the creator
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * setter of firstname
   *
   * @param firstname - sets firstname of the creator, encoded as String
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * getter of lastname
   *
   * @return lastname of the creator
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * setter of lastname
   *
   * @param lastname - sets lastname of the creator, encoded as String
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * equals method of SingleArtist
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
    SingleArtist that = (SingleArtist) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname,
        that.lastname);
  }

  /**
   * hashCode method of SingleArtist
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), firstname, lastname);
  }
}