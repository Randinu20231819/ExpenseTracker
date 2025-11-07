package expensetracker.model;


import java.time.LocalDate;

public class FixedExpense extends Expense {
    public FixedExpense(double amount, String category, LocalDate date, String description) {
        super(amount, category, date, description);
    }

    @Override
    public String getExpenseType() {
        return "Fixed";
    }
}
