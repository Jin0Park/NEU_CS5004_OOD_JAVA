package problem1;

import java.util.Objects;

public class TripReport {

    private Vehicle vehicleThatTookTheTrip;
    private float speed;
    private float distance;
    private int tripDuration;

    public TripReport(Vehicle vehicleThatTookTheTrip, float speed, float distance, int tripDuration) {
        this.vehicleThatTookTheTrip = vehicleThatTookTheTrip;
        this.speed = speed;
        this.distance = distance;
        this.tripDuration = tripDuration;
    }

    public Vehicle getVehicleThatTookTheTrip() {
        return vehicleThatTookTheTrip;
    }

    public float getSpeed() {
        return speed;
    }

    public float getDistance() {
        return distance;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripReport that = (TripReport) o;
        return Float.compare(that.speed, speed) == 0 && Float.compare(that.distance, distance) == 0 && tripDuration == that.tripDuration && Objects.equals(vehicleThatTookTheTrip, that.vehicleThatTookTheTrip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleThatTookTheTrip, speed, distance, tripDuration);
    }
}
