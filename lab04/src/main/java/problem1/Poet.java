package problem1;

import java.util.Arrays;
import java.util.Objects;

public class Poet extends AbstractArtist{

    private String publishingCompany;
    private String lastPublishedCollection;

  public Poet(Name artistName, int age, String[] genres, Award[] awards,
      String publishingCompany, String lastPublishedCollection) {
    super(artistName, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  public String getPublishingCompany() {
    return publishingCompany;
  }

  public void setPublishingCompany(String publishingCompany) {
    this.publishingCompany = publishingCompany;
  }

  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }

  public void setLastPublishedCollection(String lastPublishedCollection) {
    this.lastPublishedCollection = lastPublishedCollection;
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
    Poet poet = (Poet) o;
    return Objects.equals(publishingCompany, poet.publishingCompany)
        && Objects.equals(lastPublishedCollection, poet.lastPublishedCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishingCompany, lastPublishedCollection);
  }

  @Override
  public String toString() {
    return "problem1.Poet{" +
        "artistName=" + artistName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", awards=" + Arrays.toString(awards) +
        ", publishingCompany='" + publishingCompany + '\'' +
        ", lastPublishedCollection='" + lastPublishedCollection + '\'' +
        '}';
  }
}
