package expensetracker.service;
import expensetracker.model.*;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses;
    private Budget budget;

    public ExpenseManager(Budget budget) {
        this.budget = budget;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getRemainingBalance() {
        return budget.getIncome() - getTotalExpenses();
    }

    public void generateMonthlyReport() {
        double totalExpenses = getTotalExpenses();
        double income = budget.getIncome();
        double savingsGoal = budget.getSavingsGoal();
        double remaining = getRemainingBalance();

        System.out.println("\n========== Monthly Summary ==========");
        System.out.println("Total Income: $" + income);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Remaining Balance: $" + remaining);

        if (remaining < savingsGoal) {
            System.out.println("❌ You are short of your savings goal by $" + (savingsGoal - remaining));
        } else if (remaining > savingsGoal) {
            System.out.println("✅ Great! You saved $" + (remaining - savingsGoal) + " more than your goal!");
        } else {
            System.out.println("✅ You met your savings goal exactly!");
        }

        System.out.println("\nExpenses Breakdown:");
        for (Expense e : expenses) {
            System.out.println("- " + e.getCategory() + " (" + e.getDescription() + "): $" + e.getAmount());
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
