package problem1;
package problem1;

public class FleetManager {
    int tripDuration = 0;

    public TripReport drive(float distance, Vehicle vehicle) {
        if (vehicle.getAvgSpeed() > 0)
            tripDuration = Math.round(distance / vehicle.getAvgSpeed());
        return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, tripDuration);
    }

    public TripReport drive(float distance, float avgSpeed, Vehicle vehicle) {
        int tripDuration = 0;
        if (avgSpeed > 0 && avgSpeed <= vehicle.avgSpeed) {
            tripDuration = Math.round(distance / vehicle.getAvgSpeed());
            return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, tripDuration);
        } else throw new IllegalArgumentException("Provided average speed is invalid!");
    }

    public TripReport drive(float distance, Vehicle vehicle, float speed, int duration){
        if(distance > 0 && speed > 0 && speed <= vehicle.getMaxSpeed() && duration >= 0)
            return new TripReport(vehicle, speed, distance, duration);
        else throw new IllegalArgumentException("The trip information is not correct!");
    }

    public TripReport drive(Vehicle vehicle, int duration){
        float distance = 0;
        if(distance >= 0){
            distance =- duration * vehicle.getAvgSpeed();
        return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, duration);
        }
    }
}
