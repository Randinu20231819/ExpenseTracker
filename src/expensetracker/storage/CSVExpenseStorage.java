package expensetracker.storage;


import expensetracker.model.Expense;
import java.io.*;
import java.util.List;

public class CSVExpenseStorage implements ExpenseStorage {
    @Override
    public void saveExpenses(List<Expense> expenses, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Date,Category,Amount,Type");
            for (Expense e : expenses) {
                writer.println(e.getDate() + "," + e.getCategory() + "," + e.getAmount() + "," + e.getExpenseType());
            }
            System.out.println("✅ Expenses saved to " + filename);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
