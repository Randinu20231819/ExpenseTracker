package expensetracker.main;

import expensetracker.model.*;
import expensetracker.service.*;
import expensetracker.storage.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    
    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("❗ Invalid input. Please enter a whole number.");
                sc.nextLine();
            }
        }
    }


    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = sc.nextDouble();
                sc.nextLine();
                if (value < 0) {
                    System.out.println("❗ Amount cannot be negative. Try again.");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("❗ Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Budget budget = new Budget();
        ExpenseManager manager = new ExpenseManager(budget);
        ExpenseStorage storage = new CSVExpenseStorage();

        System.out.println("===== Welcome to Expense Tracker =====");

   
        double income = readDouble(sc, "Enter your monthly income: ");
        budget.setIncome(income);

     
        double savingGoal;
        while (true) {
            savingGoal = readDouble(sc, "Enter your monthly saving goal: ");
            if (savingGoal > income) {
                System.out.println("❗ Saving goal cannot exceed your income. Try again.");
            } else {
                budget.setSavingsGoal(savingGoal);
                break;
            }
        }

   
        boolean addMore = true;

        while (addMore) {
            System.out.println("\nEnter expense details:");

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Description: ");
            String description = sc.nextLine();

            double amount = readDouble(sc, "Amount: ");

            manager.addExpense(new VariableExpense(amount, category, LocalDate.now(), description));

            System.out.print("Do you want to add another expense? (y/n): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (!choice.equals("y")) {
                addMore = false;
            }
        }

     
        manager.generateMonthlyReport();

   
        storage.saveExpenses(manager.getExpenses(), "expenses_income.csv");

        System.out.println("\n✅ Report generated and saved successfully!");
        sc.close();
    }
}
