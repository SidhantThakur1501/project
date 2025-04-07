package main.services;

import main.models.*;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<Building> buildings;
    private List<User> users;

    public DataService() {
        this.buildings = new ArrayList<>();
        this.users = new ArrayList<>();
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample user
        users.add(new User("USR-001", "admin", "admin@energy.com"));

        // Sample building
        Building sampleHome = new Building("BLD-001", "Sample Home");
        Room livingRoom = new Room("RM-101", "Living Room");
        livingRoom.addDevice(new Lighting("LGT-101", "Ceiling Light", "Living Room", 60, 4, "LED"));
        sampleHome.addRoom(livingRoom);
        buildings.add(sampleHome);
    }

    public List<Building> getAllBuildings() {
        return new ArrayList<>(buildings);
    }

    public User authenticateUser(String username) {
        return users.stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}