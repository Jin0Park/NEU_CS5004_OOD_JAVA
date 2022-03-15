package problem02;
/**
 * CS5004 Spring2022 Jin Young Park HW1 Delivery.java
   Delivery is a class that keeps track of how much time their
   employees spend on a single delivery. Computes the duration
   of the delivery.
 */
public class Delivery {
    private String startLoc;
    private String endLoc;
    private Time startTime;
    private Time endTime;
    private Time duration;
    private final int MAXMINSEC;
    private final int MAXHOUR;
    private int hourDiff;
    private int minDiff;
    private int secDiff;
    /**
     * Constructor, creating a new Time object, with the provided
     hour, minute, and second. Checks if the value is valid with
     checkHour, checkMinute, checkSecond methods before create the object.
     MAXHOUR is the maximum number that hour can have
     MAXMINSEC is the maximum number that minute or second can have
     * @param startLoc - the value for start location, encoded as String
     * @param endLoc - the value for end location, encoded as String
     * @param startTime - the value of start time from Time class
     * @param endTime - the value of end time from Time class
     */
    public Delivery(String startLoc, String endLoc, Time startTime, Time endTime) {
        this.startLoc = startLoc;
        this.endLoc = endLoc;
        MAXMINSEC = 60;
        MAXHOUR = 24;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    /**
     * Returns startLoc.
     * @return startLoc
     */
    public String getStartLoc() {
        return startLoc;
    }
    /**
     * Sets startLoc with the given start location.
     * @param startLoc
     */
    public void setStartLoc(String startLoc) {
        this.startLoc = startLoc;
    }
    /**
     * Returns endLoc.
     * @return endLoc
     */
    public String getEndLoc() {
        return endLoc;
    }
    /**
     * Sets endLoc with the given end location.
     * @param endLoc
     */
    public void setEndLoc(String endLoc) {
        this.endLoc = endLoc;
    }
    /**
     * Computes duration of the delivery.
     * Gets start hour/minute/second and end hour/minute/second and
     * subtract end time from start time.
     * Returns the duration.
     * Throws exception if the computation is invalid.
     * @return duration
     */
    public Time getDuration() throws Exception {
        hourDiff = endTime.getHour() - startTime.getHour();
        minDiff = endTime.getMinute() - startTime.getMinute();
        secDiff = endTime.getSecond() - startTime.getSecond();

        // if the computed second difference is lower than 0
        if (secDiff < 0) {
            secDiff += MAXMINSEC;
            minDiff -= 1;
        }
        // if the computed minute difference is lower than 0
        if (minDiff < 0) {
            minDiff += MAXMINSEC;
            hourDiff -= 1;
        }
        // if the computed hour difference is lower than 0
        if (hourDiff < 0) {
            hourDiff += MAXHOUR;
        }
        duration = new Time(hourDiff, minDiff, secDiff);
    return duration;
    }
}
