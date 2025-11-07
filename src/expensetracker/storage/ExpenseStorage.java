package expensetracker.storage;


import expensetracker.model.Expense;
import java.util.List;

public interface ExpenseStorage {
    void saveExpenses(List<Expense> expenses, String filename);
}
