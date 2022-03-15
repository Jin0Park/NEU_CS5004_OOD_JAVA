package problem1;

import java.time.LocalDate;
import java.util.Objects;

public class Award {

  private String awardName;
  private String awardCategory;
  private String awardCommittee;
  private LocalDate dateofTheAward;

  public Award(String awardName, String awardCategory, String awardCommittee,
      LocalDate dateofTheAward) {
    this.awardName = awardName;
    this.awardCategory = awardCategory;
    this.awardCommittee = awardCommittee;
    this.dateofTheAward = dateofTheAward;
  }

  public String getAwardName() {
    return awardName;
  }

  public void setAwardName(String awardName) {
    this.awardName = awardName;
  }

  public String getAwardCategory() {
    return awardCategory;
  }

  public void setAwardCategory(String awardCategory) {
    this.awardCategory = awardCategory;
  }

  public String getAwardCommittee() {
    return awardCommittee;
  }

  public void setAwardCommittee(String awardCommittee) {
    this.awardCommittee = awardCommittee;
  }

  public LocalDate getDateofTheAward() {
    return dateofTheAward;
  }

  public void setDateofTheAward(LocalDate dateofTheAward) {
    this.dateofTheAward = dateofTheAward;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Award award = (Award) o;
    return Objects.equals(awardName, award.awardName) && Objects.equals(
        awardCategory, award.awardCategory) && Objects.equals(awardCommittee,
        award.awardCommittee) && Objects.equals(dateofTheAward, award.dateofTheAward);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awardName, awardCategory, awardCommittee, dateofTheAward);
  }

  @Override
  public String toString() {
    return "problem1.Award{" +
        "awardName='" + awardName + '\'' +
        ", awardCategory='" + awardCategory + '\'' +
        ", awardCommittee='" + awardCommittee + '\'' +
        ", dateofTheAward=" + dateofTheAward +
        '}';
  }
}
