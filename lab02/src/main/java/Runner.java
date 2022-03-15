import java.util.Objects;
/**
 * Class Runner stores information about the runner - their best 5K time,
 * best Half Marathon Time, and favorite Running Event.
 */

public class Runner extends Athlete{
    private double best5KTime;
    private double bestHalfMarathonTime;
    private String favoriteRunningEvent;

    /**
     * Constructor for the Runner
     * @param athletesName - Athlete's name, encoded as a data type Name
     * @param height - Athlete's height, stored as a Double
     * @param weight - Athlete's weight, stored as a Double
     * @param league - Runner's league, stored as a String
     * @param best5KTime - Runner's best 5K Time, stored as a Double
     * @param bestHalfMarathonTime - Runner's best Half Marathon Time, stored as a Double
     * @param favoriteRunningEvent - Runner's favorite Running Event, stored as a String
     */
    public Runner(Name athletesName, Double height, Double weight, String league, double best5KTime,
        double bestHalfMarathonTime, String favoriteRunningEvent) {
        super(athletesName, height, weight, league);
        this.best5KTime = best5KTime;
        this.bestHalfMarathonTime = bestHalfMarathonTime;
        this.favoriteRunningEvent = favoriteRunningEvent;
    }

    /**
     * Getter for best 5K Time
     * @return the time, as Double
     */
    public double getBest5KTime() {
        return best5KTime;
    }
    /**
     * Setter for best 5K Time
     * @param best5KTime - 5K time, encoded as Double
     */
    public void setBest5KTime(double best5KTime) {
        this.best5KTime = best5KTime;
    }
    /**
     * Getter for best Half Marathon Time
     * @return the time, as Double
     */
    public double getBestHalfMarathonTime() {
        return bestHalfMarathonTime;
    }
    /**
     * Setter for best Half Marathon Time
     * @param bestHalfMarathonTime - Half Marathon time, encoded as Double
     */
    public void setBestHalfMarathonTime(double bestHalfMarathonTime) {
        this.bestHalfMarathonTime = bestHalfMarathonTime;
    }
    /**
     * Getter for favorite running event
     * @return running event, as a String
     */
    public String getFavoriteRunningEvent() {
        return favoriteRunningEvent;
    }
    /**
     * Setter for favorite running event
     * @param favoriteRunningEvent - favorite running event, encoded as String
     */
    public void setFavoriteRunningEvent(String favoriteRunningEvent) {
        this.favoriteRunningEvent = favoriteRunningEvent;
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
        Runner runner = (Runner) o;
        return Double.compare(runner.best5KTime, best5KTime) == 0
            && Double.compare(runner.bestHalfMarathonTime, bestHalfMarathonTime) == 0
            && Objects.equals(favoriteRunningEvent, runner.favoriteRunningEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), best5KTime, bestHalfMarathonTime,
            favoriteRunningEvent);
    }

    @Override
    public String toString() {
        return "Runner{" +
            "best5KTime=" + best5KTime +
            ", bestHalfMarathonTime=" + bestHalfMarathonTime +
            ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
            '}';
    }
}
