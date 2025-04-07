package main.services;

import main.models.*;
import java.util.ArrayList;
import java.util.List;

public class RecommendationService {
    
    public List<String> generateRecommendations(Building building) {
        List<String> recommendations = new ArrayList<>();
        
        // Check for old lighting
        boolean hasOldLighting = building.getAllDevices().stream()
            .filter(d -> d instanceof Lighting)
            .anyMatch(d -> ((Lighting) d).getLightingType().equalsIgnoreCase("Incandescent"));
        
        if (hasOldLighting) {
            recommendations.add("Replace incandescent bulbs with LEDs to save up to 80% on lighting");
        }

        // Check high consumption devices
        boolean hasHighPowerDevices = building.getAllDevices().stream()
            .anyMatch(d -> d.getPowerRating() > 1000);
        
        if (hasHighPowerDevices) {
            recommendations.add("Consider using high-power appliances during off-peak hours");
        }

        if (recommendations.isEmpty()) {
            recommendations.add("Your energy usage is already efficient! Keep up the good work!");
        }

        return recommendations;
    }
}