package main.models;

public class ReportFactory {
    public static EnergyReport createReport(String type, String reportId) {
        switch (type.toLowerCase()) {
            case "monthly":
                return new MonthlyEnergyReport(reportId);
            case "daily":
                return new DailyEnergyReport(reportId); // Assume exists
            default:
                throw new IllegalArgumentException("Invalid report type: " + type);
        }
    }
}