package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FinancialTracker {

    static Scanner johns = new Scanner(System.in);
    static List<Transactions> transactions = new ArrayList<>();

    public static void main(String[] args) {

        // load saved data when program starts
        transactions = FileManager.loadTransactions();

        // ask for user's name
        System.out.println("Enter your name: ");
        String name = johns.nextLine();

        // main menu loop
        boolean running = true;
        while (running) {
            printMenu(name);
            int choice = Integer.parseInt(johns.nextLine());

            switch (choice) {
                case 1 -> Income();
                case 2 -> Expenses();
                case 3 -> Savings();
                case 4 -> Recap();
                case 5 -> running = false;
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }

        // show quote when exiting
        showQuote();
        System.out.println("Goodbye, " + name + "! Keep tracking your finances!");
    }

    // ===================== PRINT MENU =====================
    public static void printMenu(String name) {
        System.out.println("\n================================");
        System.out.println("       FINANCIAL TRACKER");
        System.out.println("================================");
        System.out.println("  Welcome, " + name + "!");
        System.out.println("--------------------------------");
        System.out.println("  1. Income");
        System.out.println("  2. Expenses");
        System.out.println("  3. Savings");
        System.out.println("  4. Recap");
        System.out.println("  5. Exit");
        System.out.println("--------------------------------");
        System.out.println("  Enter your choice: ");
    }

    // ===================== INCOME =====================
    public static void Income() {
        System.out.println("\n--- Previous Income ---");
        for (Transactions t : transactions) {
            if (t.getType().equals("INCOME")) {
                System.out.println(t.getDate() + " | " + t.getCategory() +
                        " | RM" + t.getAmount() +
                        " | " + t.getDescription());
            }
        }
        System.out.println("-----------------------");

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(johns.nextLine());

        System.out.println("Enter category (e.g. Salary, Freelance): ");
        String category = johns.nextLine();

        System.out.println("Enter description: ");
        String description = johns.nextLine();

        String date = java.time.LocalDate.now().toString();
        int id = transactions.size() + 1;

        Transactions t = new Transactions(id, amount, category, "INCOME", date, description);
        transactions.add(t);
        FileManager.saveTransactions(transactions);

        System.out.println("Income saved successfully!");
    }

    // ===================== EXPENSES =====================
    public static void Expenses() {
        System.out.println("\n--- Previous Expenses ---");
        for (Transactions t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                System.out.println(t.getDate() + " | " + t.getCategory() +
                        " | RM" + t.getAmount() +
                        " | " + t.getDescription());
            }
        }
        System.out.println("-------------------------");

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(johns.nextLine());

        System.out.println("Enter category (e.g. Food, Transport): ");
        String category = johns.nextLine();

        System.out.println("Enter description: ");
        String description = johns.nextLine();

        String date = java.time.LocalDate.now().toString();
        int id = transactions.size() + 1;

        Transactions t = new Transactions(id, amount, category, "EXPENSE", date, description);
        transactions.add(t);
        FileManager.saveTransactions(transactions);

        System.out.println("Expense saved successfully!");
    }

    // ===================== SAVINGS =====================
    public static void Savings() {
        System.out.println("\n--- Previous Savings ---");
        for (Transactions t : transactions) {
            if (t.getType().equals("SAVINGS")) {
                System.out.println(t.getDate() + " | " + t.getCategory() +
                        " | RM" + t.getAmount() +
                        " | " + t.getDescription());
            }
        }
        System.out.println("------------------------");

        System.out.println("Enter amount: ");
        double amount = Double.parseDouble(johns.nextLine());

        System.out.println("Enter category (e.g. Emergency, Travel): ");
        String category = johns.nextLine();

        System.out.println("Enter description: ");
        String description = johns.nextLine();

        String date = java.time.LocalDate.now().toString();
        int id = transactions.size() + 1;

        Transactions t = new Transactions(id, amount, category, "SAVINGS", date, description);
        transactions.add(t);
        FileManager.saveTransactions(transactions);

        System.out.println("Savings saved successfully!");
    }

    // ===================== RECAP =====================
    public static void Recap() {
        System.out.println("\n================================");
        System.out.println("           RECAP");
        System.out.println("================================");

        double totalIncome = 0;
        double totalExpense = 0;
        double totalSavings = 0;

        System.out.println("\n--- All Transactions ---");
        for (Transactions t : transactions) {
            System.out.println(t.getDate() + " | " + t.getType() +
                    " | " + t.getCategory() +
                    " | RM" + t.getAmount() +
                    " | " + t.getDescription());

            if (t.getType().equals("INCOME")) {
                totalIncome += t.getAmount();
            } else if (t.getType().equals("EXPENSE")) {
                totalExpense += t.getAmount();
            } else if (t.getType().equals("SAVINGS")) {
                totalSavings += t.getAmount();
            }
        }

        double balance = totalIncome - totalExpense - totalSavings;

        System.out.println("\n--------------------------------");
        System.out.println("  Total Income  : RM" + totalIncome);
        System.out.println("  Total Expense : RM" + totalExpense);
        System.out.println("  Total Savings : RM" + totalSavings);
        System.out.println("  Balance       : RM" + balance);
        System.out.println("================================");
    }

    // ===================== QUOTE =====================
    public static void showQuote() {
        String[] quotes = {
            "A penny saved is a penny earned.",
            "Do not save what is left after spending, spend what is left after saving.",
            "Financial freedom is available to those who learn about it and work for it.",
            "The secret to financial security is not to have more money, but to have fewer desires.",
            "It is not how much money you make, but how much money you keep.",
            "Rich people have small TVs and big libraries.",
            "Wealth is not about having a lot of money; it's about having a lot of options.",
            "Stop buying things you don't need to impress people you don't like.",
            "A budget is telling your money where to go instead of wondering where it went.",
            "The habit of saving is itself an education.",
            "Money is a tool. Used properly it makes something beautiful.",
            "Financial peace is not the acquisition of stuff. It's learning to live on less.",
            "Invest in yourself. Your career is the engine of your wealth.",
            "Beware of little expenses; a small leak will sink a great ship.",
            "You must gain control over your money or the lack of it will forever control you.",
            "Never spend your money before you have it.",
            "An investment in knowledge pays the best interest.",
            "The more you learn, the more you earn.",
            "Save money and money will save you.",
            "Dream big, start small, but most of all start."
        };

        Random random = new Random();
        int index = random.nextInt(quotes.length);
        System.out.println("\n💡 Quote of the day: " + quotes[index]);
    }
}
