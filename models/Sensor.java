package main.models;

public interface Sensor {
    double getCurrentReading();
    String getSensorType();
    String getLocation();
}