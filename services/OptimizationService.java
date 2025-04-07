package main.services;

import main.models.*;

public class OptimizationService {
    
    public void optimizeForTargetBill(Building building, double targetMonthlyBill, EnergyPlan plan) {
        double currentMonthlyBill = calculateCurrentMonthlyBill(building, plan);
        
        if (targetMonthlyBill >= currentMonthlyBill) {
            System.out.println("\nYour current usage is already below your target bill!");
            return;
        }

        double reductionFactor = targetMonthlyBill / currentMonthlyBill;
        
        System.out.println("\n=== OPTIMIZED USAGE PLAN ===");
        System.out.printf("To achieve $%.2f monthly bill:%n", targetMonthlyBill);
        
        for (Room room : building.getRooms()) {
            for (Device device : room.getDevices()) {
                double originalHours = device.getDailyUsageHours();
                double newHours = originalHours * reductionFactor;
                
                System.out.printf("- %s: %.1f → %.1f hrs/day (%.0f%% reduction)%n",
                    device.getName(),
                    originalHours,
                    newHours,
                    (1 - reductionFactor) * 100);
                
                device.setDailyUsageHours(newHours);
            }
        }
    }

    private double calculateCurrentMonthlyBill(Building building, EnergyPlan plan) {
        return plan.calculateCost(building.calculateTotalDailyConsumption()) * 30;
    }
}