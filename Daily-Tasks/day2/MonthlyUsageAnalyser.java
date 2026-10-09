
public class MonthlyUsageAnalyser {

    public static void main(String[] args) {
        double[] dailyUsage = {
            12.5, 14.0, 11.5, 15.0, 16.5,
            13.0, 12.0, 17.5, 18.0, 14.5,
            13.5, 16.0, 19.0, 15.5, 12.5,
            14.0, 20.0, 18.5, 16.5, 13.0,
            11.0, 15.0, 17.0, 19.5, 16.0,
            14.5, 13.5, 18.0, 21.0, 15.5
        };

        int days = dailyUsage.length;
        double totalUsage = 0.0;
        double highestUsage = dailyUsage[0];
        double lowestUsage = dailyUsage[0];

        int highestDay = 1;
        int lowestDay = 1;

        for (int i = 0; i < days; i++) {
            double usage = dailyUsage[i];

            totalUsage += usage;

            if (usage > highestUsage) {
                highestUsage = usage;
                highestDay = i + 1;
            }

            if (usage < lowestUsage) {
                lowestUsage = usage;
                lowestDay = i + 1;
            }
        }

        double averageUsage = totalUsage / days;

        int daysAboveAverage = 0;

        for (double usage : dailyUsage) {
            if (usage > averageUsage) {
                daysAboveAverage++;
            }
        }

        double ratePerUnit = 8.0;
        double monthlyBill = totalUsage * ratePerUnit;

        int roundedAverage = (int) averageUsage;

        System.out.println("===== MONTHLY USAGE REPORT =====");
        System.out.println("Number of days: " + days);
        System.out.printf("Total usage: %.2f kWh%n", totalUsage);
        System.out.printf("Average daily usage: %.2f kWh%n",
                averageUsage);
        System.out.println("Average usage (int cast): "
                + roundedAverage + " kWh");

        System.out.printf("Highest usage: %.2f kWh on day %d%n",
                highestUsage, highestDay);

        System.out.printf("Lowest usage: %.2f kWh on day %d%n",
                lowestUsage, lowestDay);

        System.out.println("Days above average: "
                + daysAboveAverage);

        System.out.printf("Rate per unit: Rs. %.2f%n", ratePerUnit);
        System.out.printf("Estimated monthly bill: Rs. %.2f%n",
                monthlyBill);
    }
}