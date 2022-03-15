package problem02;

/**
 * CS5004 Spring2022 Jin Young Park HW1 Time.java
 * Time is a class that keeps track of the time (hour, minute, second), and
   checks if the values for each unit of time are valid.
   The hour should not be lower than 0 and higher than 23.
   The minute should not be lower than 0 and higher than 59.
   The second should not be lower than 0 and higher than 59.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;
    private final int MAXHOUR;
    private final int MAXMINSEC;
    /**
     * Constructor, creating a new Time object, with the provided
     hour, minute, and second.
     MAXHOUR is the maximum number that hour can have
     MAXMINSEC is the maximum number that minute or second can have
     * @param hour - the value for hour, encoded as integer
     * @param minute - the value for minute, encoded as integer
     * @param second - the value for second, encoded as integer
     * Throws exception if the given hour or minute or second is invalid.
     */
    public Time(int hour, int minute, int second) throws Exception {
        MAXHOUR = 24;
        MAXMINSEC = 60;
        if (hour < MAXHOUR && hour >= 0) {
            this.hour = hour;
        } else {
            throw new Exception("Invalid time.");
        }
        if (minute < MAXMINSEC && minute >= 0){
            this.minute = minute;
        } else {
            throw new Exception("Invalid time.");
        }
        if (second < MAXMINSEC && second >= 0){
            this.second = second;
        } else {
            throw new Exception("Invalid time.");
        }
    }
    /**
     * Sets hour to the given hour.
     * Throws exception if the given hour is invalid.
     * @param hour
     */
    public void setHour(int hour) throws Exception {
        if (hour < MAXHOUR && hour >= 0) {
            this.hour = hour;
        } else {
            throw new Exception("Invalid time.");
        }
    }
    /**
     * Sets minute to the given minute.
     * Throws exception if the given minute is invalid.
     * @param minute
     */
    public void setMinute(int minute) throws Exception {
        if (minute < MAXMINSEC && minute >= 0){
            this.minute = minute;
        } else {
            throw new Exception("Invalid time.");
        }
    }
    /**
     * Sets second to the given second.
     * Throws exception if the given second is invalid.
     * @param second
     */
    public void setSecond(int second) throws Exception {
        if (second < MAXMINSEC && second >= 0){
            this.second = second;
        } else {
            throw new Exception("Invalid time.");
        }
    }
    /**
     * Returns the hour.
     * @return the hour
     */
    public int getHour() {
        return hour;
    }
    /**
     * Returns the minute.
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }
    /**
     * Returns the second.
     * @return the second
     */
    public int getSecond() {
        return second;
    }
}
