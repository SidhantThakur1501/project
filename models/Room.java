package main.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String id;
    private String name;
    private List<Device> devices;

    public Room(String id, String name) {
        this.id = id;
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public List<Device> getDevices() { return devices; }
}