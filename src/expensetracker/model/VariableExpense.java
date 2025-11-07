package expensetracker.model;


import java.time.LocalDate;

public class VariableExpense extends Expense {
    public VariableExpense(double amount, String category, LocalDate date, String description) {
        super(amount, category, date, description);
    }

    @Override
    public String getExpenseType() {
        return "Variable";
    }
}
