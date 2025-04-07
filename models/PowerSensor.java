package main.models;

public class PowerSensor implements Sensor {
    private String id;
    private String location;

    public PowerSensor(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public double getCurrentReading() {
        // Simulated power reading
        return Math.random() * 2000; // 0-2000W
    }

    @Override
    public String getSensorType() {
        return "Power";
    }

    @Override
    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}