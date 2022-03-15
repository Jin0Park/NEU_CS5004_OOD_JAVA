import java.util.Objects;

/**
 * Class BaseballPlayer stores information about the baseball player - their team name, average batting score,
 * and the number of season home runs.
 */

public class BaseballPlayer extends Athlete{
  private String team;
  private double averageBatting;
  private int seasonHomeRuns;

  /**
   * Constructor for the BaseballPlayer.
   * @param athletesName - athlete's name, encoded as a data type Name
   * @param height - athlete's height, stored as a Double
   * @param weight - athlete's weight, stored as a Double
   * @param league - baseball player's league, stored as a String
   * @param team baseball player's team, stored as a String
   * @param averageBatting - baseball player's avg batting score, stored as a Double
   * @param seasonHomeRuns - baseball player's season home runs, stored as Integer
   */

  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, double averageBatting, int seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Getter for team
   * @return the name of the team, as String
   */
  public String getTeam() {
    return team;
  }
  /**
   * Setter for team
   * @param team - team name, encoded as String
   */
  public void setTeam(String team) {
    this.team = team;
  }
  /**
   * Getter for average batting score
   * @return average batting score, as a Double
   */
  public double getAverageBatting() {
    return averageBatting;
  }
  /**
   * Setter for average batting score.
   * @param averageBatting - avg batting score, encoded as Double
   */
  public void setAverageBatting(double averageBatting) {
    this.averageBatting = averageBatting;
  }
  /**
   * Getter for season home runs
   * @return number of season home runs, as an Integer
   */
  public int getSeasonHomeRuns() {
    return seasonHomeRuns;
  }
  /**
   * Setter for season home runs.
   * @param seasonHomeRuns - number of season home runs, encoded as an Integer
   */
  public void setSeasonHomeRuns(int seasonHomeRuns) {
    this.seasonHomeRuns = seasonHomeRuns;
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Double.compare(that.averageBatting, averageBatting) == 0
        && seasonHomeRuns == that.seasonHomeRuns && Objects.equals(team, that.team);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, averageBatting, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "athletesName=" + this.athletesName +
        ", height=" + this.height +
        ", weight=" + this.weight +
        ", league='" + this.league + '\'' +
        ", team='" + this.team + '\'' +
        ", averageBatting=" + this.averageBatting +
        ", seasonHomeRuns=" + this.seasonHomeRuns +
        '}';
  }
}
