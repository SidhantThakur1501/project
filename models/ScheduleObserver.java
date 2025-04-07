package main.models;

public interface ScheduleObserver {
    void update(String scheduleId, String message);
}