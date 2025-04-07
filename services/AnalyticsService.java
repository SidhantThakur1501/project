package main.services;

import main.models.*;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsService {
    private List<EnergyReport> reportHistory;
    private ReportFactory reportFactory;
    private EnergyPlan currentPlan;

    public AnalyticsService(EnergyPlan plan) {
        this.reportHistory = new ArrayList<>();
        this.reportFactory = new ReportFactory();
        this.currentPlan = plan;
    }

    public EnergyReport generateDailyReport(Building building) {
        DailyEnergyReport report = (DailyEnergyReport) reportFactory.createReport("daily", "RPT-" + System.currentTimeMillis());
        report.generateReport(building);
        
        // Calculate and set estimated cost
        double ratePerKWh = getRatePerKWhFromPlan();
        report.setEstimatedCost(ratePerKWh);
        
        reportHistory.add(report);
        
        System.out.println("\n=== DAILY ENERGY REPORT GENERATED ===");
        System.out.println(report.getReportContent());
        System.out.println("====================================");
        
        return report;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public EnergyReport generateMonthlyReport(Building building) {
        EnergyReport report = reportFactory.createReport("monthly", "RPT-" + System.currentTimeMillis());
        report.generateReport(building);
        
        // Calculate and set estimated cost for monthly report
        if (report instanceof MonthlyEnergyReport) {
            MonthlyEnergyReport monthlyReport = (MonthlyEnergyReport) report;
            double ratePerKWh = getRatePerKWhFromPlan();
            monthlyReport.setEstimatedCost(ratePerKWh);
        }
        
        reportHistory.add(report);
        
        System.out.println("\n=== MONTHLY ENERGY REPORT GENERATED ===");
        System.out.println(report.getReportContent());
        System.out.println("======================================");
        
        return report;
    }

    public void showReportHistory() {
        System.out.println("\n=== REPORT HISTORY ===");
        if (reportHistory.isEmpty()) {
            System.out.println("No reports generated yet");
            return;
        }
        
        for (EnergyReport report : reportHistory) {
            System.out.println("\nReport ID: " + report.getReportId());
            System.out.println("Type: " + report.getReportType());
            System.out.println("Generated: " + report.getGeneratedDate());
            System.out.println("---------------------");
        }
    }

    public double calculateProjectedAnnualCost(Building building) {
        double monthlyCost = currentPlan.calculateCost(building.calculateTotalDailyConsumption() * 30);
        double annualCost = monthlyCost * 12;
        
        System.out.println("\n=== ANNUAL COST PROJECTION ===");
        System.out.printf("Monthly Average: $%.2f%n", monthlyCost);
        System.out.printf("Projected Annual: $%.2f%n", annualCost);
        System.out.println("Based on current usage patterns");
        System.out.println("==============================");
        
        return annualCost;
    }

    private double getRatePerKWhFromPlan() {
        // For FixedRatePlan, this returns the rate directly
        // For other plan types, you might need different logic
        if (currentPlan instanceof FixedRatePlan) {
            return ((FixedRatePlan) currentPlan).getRatePerKWh();
        }
        // Default fallback - calculate cost for 1 kWh to get the rate
        return currentPlan.calculateCost(1);
    }
}