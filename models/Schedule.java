package main.models;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private String id;
    private String deviceId;
    private boolean isActive;
    private List<ScheduleObserver> observers = new ArrayList<>();

    public Schedule(String id, String deviceId) {
        this.id = id;
        this.deviceId = deviceId;
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
        notifyObservers("Schedule activated");
    }

    public void deactivate() {
        this.isActive = false;
        notifyObservers("Schedule deactivated");
    }

    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (ScheduleObserver observer : observers) {
            observer.update(id, message);
        }
    }

    // Getters
    public String getId() { return id; }
    public String getDeviceId() { return deviceId; }
    public boolean isActive() { return isActive; }
}