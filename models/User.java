package main.models;

public class User implements ScheduleObserver {
    private String id;
    private String username;
    private String email;

    public User(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    @Override
    public void update(String scheduleId, String message) {
        System.out.printf("User %s notified - Schedule %s: %s%n", 
            username, scheduleId, message);
    }

    // Getters
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}