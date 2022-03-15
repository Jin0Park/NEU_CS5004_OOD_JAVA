package problem1;

import java.util.Arrays;

public abstract class MediaArtists extends AbstractArtist{

  protected String[] movies;
  protected String[] series;
  protected String[] otherMultimedia;

  public MediaArtists(Name artistName, int age, String[] genres, Award[] awards,
      String[] movies, String[] series, String[] otherMultimedia) {
    super(artistName, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public void setMovies(String[] movies) {
    this.movies = movies;
  }

  public String[] getSeries() {
    return series;
  }

  public void setSeries(String[] series) {
    this.series = series;
  }

  public String[] getOtherMultimedia() {
    return otherMultimedia;
  }

  public void setOtherMultimedia(String[] otherMultimedia) {
    this.otherMultimedia = otherMultimedia;
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
    MediaArtists that = (MediaArtists) o;
    return Arrays.equals(movies, that.movies) && Arrays.equals(series,
        that.series) && Arrays.equals(otherMultimedia, that.otherMultimedia);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(otherMultimedia);
    return result;
  }

  @Override
  public String toString() {
    return "problem1.MediaArtists{" +
        "artistName=" + artistName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", otherMultimedia=" + Arrays.toString(otherMultimedia) +
        '}';
  }
}
