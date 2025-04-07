package main.models;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String id;
    private String name;
    private List<Room> rooms;

    public Building(String id, String name) {
        this.id = id;
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        for (Room room : rooms) {
            devices.addAll(room.getDevices());
        }
        return devices;
    }

    public double calculateTotalDailyConsumption() {
        double total = 0;
        for (Room room : rooms) {
            for (Device device : room.getDevices()) {
                total += device.calculateDailyConsumption();
            }
        }
        return total;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public List<Room> getRooms() { return rooms; }
}