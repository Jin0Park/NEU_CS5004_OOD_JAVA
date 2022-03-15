package problem1;

import java.util.Arrays;

public abstract class VisualArtist extends AbstractArtist {
  protected String[] exhibits;

  public VisualArtist(Name artistName, int age, String[] genres, Award[] awards,
      String[] exhibits) {
    super(artistName, age, genres, awards);
    this.exhibits = exhibits;
  }

  public String[] getExhibits() {
    return exhibits;
  }

  public void setExhibits(String[] exhibits) {
    this.exhibits = exhibits;
  }

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
    VisualArtist that = (VisualArtist) o;
    return Arrays.equals(exhibits, that.exhibits);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(exhibits);
    return result;
  }

  @Override
  public String toString() {
    return "problem1.VisualArtist{" +
        "artistName=" + artistName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", exhibits=" + Arrays.toString(exhibits) +
        '}';
  }
}
