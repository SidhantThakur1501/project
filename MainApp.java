package main;

import main.models.*;
import main.services.*;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Building currentBuilding = new Building("HOME-001", "My Home");
    private static EnergyPlan currentPlan = new FixedRatePlan(0.15);
    private static AnalyticsService analytics = new AnalyticsService(currentPlan);
    private static OptimizationService optimizer = new OptimizationService();
    private static RecommendationService recommender = new RecommendationService();
    private static DataService dataService = new DataService();

    public static void main(String[] args) {
        showWelcomeMessage();
        showMainMenu();
    }

    private static void showWelcomeMessage() {
        System.out.println("============================================");
        System.out.println("    ENERGY CONSUMPTION OPTIMIZER v2.0      ");
        System.out.println("============================================");
        System.out.println("Track and optimize your home energy usage");
        System.out.println();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Add Devices & Usage");
            System.out.println("2. Generate Energy Report");
            System.out.println("3. Optimize for Target Bill");
            System.out.println("4. View Recommendations");
            System.out.println("5. Show Report History");
            System.out.println("6. View Annual Projection");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice (1-7): ");
            int choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1: addDevicesWithUsage(); break;
                case 2: generateEnergyReport(); break;
                case 3: optimizeForTargetBill(); break;
                case 4: showRecommendations(); break;
                case 5: showReportHistory(); break;
                case 6: showAnnualProjection(); break;
                case 7: exitProgram();
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDevicesWithUsage() {
        System.out.println("\n=== ADD DEVICES ===");
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        Room room = new Room("RM-" + System.currentTimeMillis(), roomName);
        
        System.out.print("How many devices in this room? ");
        int deviceCount = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < deviceCount; i++) {
            System.out.println("\nDevice #" + (i+1));
            System.out.print("Device name: ");
            String name = scanner.nextLine();
            
            System.out.print("Power rating (Watts): ");
            double power = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Daily usage hours: ");
            double hours = Double.parseDouble(scanner.nextLine());
            
            Device device = new Appliance(
                "DEV-" + System.currentTimeMillis(),
                name, roomName, power, quantity, "General", 3
            );
            device.setDailyUsageHours(hours);
            room.addDevice(device);
            
            System.out.printf("Added %d x %s (%.0fW) @ %.1f hrs/day%n",
                quantity, name, power, hours);
        }
        
        currentBuilding.addRoom(room);
        System.out.println("\n✓ Devices added successfully!");
    }

    private static void generateEnergyReport() {
        System.out.println("\n=== ENERGY REPORT ===");
        System.out.println("1. Daily Report");
        System.out.println("2. Monthly Report");
        System.out.print("Choose report type: ");
        
        int reportType = Integer.parseInt(scanner.nextLine());
        
        if (reportType == 1) {
            analytics.generateDailyReport(currentBuilding);
        } else if (reportType == 2) {
            analytics.generateMonthlyReport(currentBuilding);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private static void optimizeForTargetBill() {
        System.out.println("\n=== TARGET BILL OPTIMIZATION ===");
        System.out.print("Enter your target monthly bill ($): ");
        double target = Double.parseDouble(scanner.nextLine());
        
        optimizer.optimizeForTargetBill(currentBuilding, target, currentPlan);
        
        System.out.println("\nUse updated usage hours to achieve your target!");
    }

    private static void showRecommendations() {
        System.out.println("\n=== ENERGY SAVING TIPS ===");
        List<String> tips = recommender.generateRecommendations(currentBuilding);
        
        if (tips.isEmpty()) {
            System.out.println("No specific recommendations available.");
        } else {
            tips.forEach(tip -> System.out.println("- " + tip));
        }
    }

    private static void showReportHistory() {
        analytics.showReportHistory();
    }

    private static void showAnnualProjection() {
        analytics.calculateProjectedAnnualCost(currentBuilding);
    }

    private static void exitProgram() {
        System.out.println("\nThank you for using Energy Optimizer!");
        System.out.println("Saving your data...");
        System.out.println("Goodbye!");
        System.exit(0);
    }
}