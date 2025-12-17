// Main.java — Students version
import java.io.*;
import java.util.*;

public class Main {

    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;

    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"};

    // [globalDay][commodity]
    static int[][] profits = new int[MONTHS * DAYS][COMMS];

    // ======== 2. COMMIT: LOAD DATA ========
    public static void loadData() {
        for (int m = 0; m < MONTHS; m++) {
            try {
                File file = new File("Data_Files/" + months[m] + ".txt");
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    String[] p = sc.nextLine().split(",");

                    int day = Integer.parseInt(p[0]); // 1–28
                    String comm = p[1];
                    int profit = Integer.parseInt(p[2]);

                    int cIndex = getCommodityIndex(comm);
                    if (cIndex != -1 && day >= 1 && day <= DAYS) {
                        int globalDay = m * DAYS + (day - 1);
                        profits[globalDay][cIndex] = profit;
                    }
                }
                sc.close();
            } catch (Exception e) {
                // robustness requirement
            }
        }
    }

    // ======== 3. COMMIT: BASIC QUERY METHODS ========

    public static String mostProfitableCommodityInMonth(int month) {
        if (month < 0 || month >= MONTHS) return "INVALID_MONTH";

        int maxProfit = Integer.MIN_VALUE;
        int bestIndex = -1;

        int start = month * DAYS;
        int end = start + DAYS;

        for (int c = 0; c < COMMS; c++) {
            int sum = 0;
            for (int g = start; g < end; g++) {
                sum += profits[g][c];
            }
            if (sum > maxProfit) {
                maxProfit = sum;
                bestIndex = c;
            }
        }
        return commodities[bestIndex] + " " + maxProfit;
    }

    public static int totalProfitOnDay(int month, int day) {
        if (month < 0 || month >= MONTHS || day < 1 || day > DAYS) return -99999;

        int globalDay = month * DAYS + (day - 1);
        int sum = 0;

        for (int c = 0; c < COMMS; c++) {
            sum += profits[globalDay][c];
        }
        return sum;
    }

    // ======== DUMMY METHODS (NOT IMPLEMENTED YET) ========

    public static int commodityProfitInRange(String commodity, int from, int to) {
        int cIndex = getCommodityIndex(commodity);
        if (cIndex == -1 || fromDay < 1 || toDay > DAYS || fromDay > toDay) return -99999;

        int sum = 0;
        for (int m = 0; m < MONTHS; m++) {
            int start = m * DAYS + (fromDay - 1);
            int end = m * DAYS + (toDay - 1);
            for (int g = start; g <= end; g++) {
                sum += profits[g][cIndex];
            }
        }
        return sum;
    }

    public static int bestDayOfMonth(int month) {
        if (month < 0 || month >= MONTHS) return -1;

        int bestDay = 1;
        int maxProfit = Integer.MIN_VALUE;

        int start = month * DAYS;
        for (int d = 0; d < DAYS; d++) {
            int sum = 0;
            for (int c = 0; c < COMMS; c++) {
                sum += profits[start + d][c];
            }
            if (sum > maxProfit) {
                maxProfit = sum;
                bestDay = d + 1;
            }
        }
        return bestDay;
    }

    public static String bestMonthForCommodity(String comm) {
        int cIndex = getCommodityIndex(commodity);
        if (cIndex == -1) return "INVALID_COMMODITY";

        int bestMonth = 0;
        int maxProfit = Integer.MIN_VALUE;

        for (int m = 0; m < MONTHS; m++) {
            int sum = 0;
            int start = m * DAYS;
            for (int d = 0; d < DAYS; d++) {
                sum += profits[start + d][cIndex];
            }
            if (sum > maxProfit) {
                maxProfit = sum;
                bestMonth = m;
            }
        }
        return months[bestMonth];
    }

    public static int consecutiveLossDays(String comm) {
        return 1234;
    }

    public static int daysAboveThreshold(String comm, int threshold) {
        return 1234;
    }

    public static int biggestDailySwing(int month) {
        return 1234;
    }

    public static String compareTwoCommodities(String c1, String c2) {
        return "DUMMY is better by 1234";
    }

    public static String bestWeekOfMonth(int month) {
        return "DUMMY";
    }

    // ======== HELPER ========
    static int getCommodityIndex(String comm) {
        for (int i = 0; i < COMMS; i++) {
            if (commodities[i].equals(comm)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}
