import java.io.*;
import java.util.*;

public class Main {
    static final int MONTHS = 12;
    static final int DAYS = 28;
    static final int COMMS = 5;
    static String[] commodities = {"Gold", "Oil", "Silver", "Wheat", "Copper"};
    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};

    static int[][] profits = new int[MONTHS * DAYS][COMMS];


    // ======== REQUIRED METHOD LOAD DATA (Students fill this) ========
    public static void loadData() {

        for (int m = 0; m < MONTHS; m++) {
            try {
                File file = new File("Data_Files/" + months[m] + ".txt");
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    String[] p = sc.nextLine().split(",");

                    int day = Integer.parseInt(p[0]); // 1-28
                    String comm = p[1];
                    int profit = Integer.parseInt(p[2]);

                    int cIndex = getCommodityIndex(comm);
                    if (cIndex != -1 && day >= 1 && day <= DAYS) {
                        int globalDay = m * DAYS + (day - 1);
                        profits[globalDay][cIndex] = profit;
                    }
                }
                sc.close();
            } catch (Exception e)
    }

    // ======== 10 REQUIRED METHODS (Students fill these) ========

    public static String mostProfitableCommodityInMonth(int month) {
        return "DUMMY"; 
    }

    public static int totalProfitOnDay(int month, int day) {
        return 1234;
    }

    public static int commodityProfitInRange(String commodity, int from, int to) {
        return 1234;
    }

    public static int bestDayOfMonth(int month) { 
        return 1234; 
    }
    
    public static String bestMonthForCommodity(String comm) { 
        return "DUMMY"; 
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

    public static void main(String[] args) {
        loadData();
        System.out.println("Data loaded – ready for queries");
    }
}