package problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractArtist implements Artist{
  protected Name artistName;
  protected int age;
  protected String[] genres;
  protected Award[] awards;

  public AbstractArtist(Name artistName, int age, String[] genres, Award[] awards) {
    this.artistName = artistName;
    this.age = age;
    this.genres = genres;
    this.awards = awards;
  }


  public boolean receiveAward(String award){
    if (award!=null) {
      Award myAward = new Award("this award", "problem1.Award category", "award committee", LocalDate.now());
      this.awards[this.awards.length] = myAward;
      return true;
    }
    else return false;
  }

  public Name getArtistName() {
    return artistName;
  }

  public void setArtistName(Name artistName) {
    this.artistName = artistName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String[] getGenres() {
    return genres;
  }

  public void setGenres(String[] genres) {
    this.genres = genres;
  }

  public Award[] getAwards() {
    return awards;
  }

  public void setAwards(Award[] awards) {
    this.awards = awards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractArtist that = (AbstractArtist) o;
    return age == that.age && Objects.equals(artistName, that.artistName)
        && Arrays.equals(genres, that.genres) && Arrays.equals(awards,
        that.awards);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(artistName, age);
    result = 31 * result + Arrays.hashCode(genres);
    result = 31 * result + Arrays.hashCode(awards);
    return result;
  }

  @Override
  public String toString() {
    return "problem1.AbstractArtist{" +
        "artistName=" + artistName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        '}';
  }
}
