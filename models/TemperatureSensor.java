package main.models;

public class TemperatureSensor implements Sensor {
    private String id;
    private String location;

    public TemperatureSensor(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public double getCurrentReading() {
        // Simulated temperature reading
        return 20 + (Math.random() * 10); // 20-30°C
    }

    @Override
    public String getSensorType() {
        return "Temperature";
    }

    @Override
    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}