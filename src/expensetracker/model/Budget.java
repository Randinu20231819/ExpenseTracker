package expensetracker.model;



import java.util.HashMap;
import java.util.Map;

public class Budget {
    private Map<String, Double> categoryLimits;
    private double savingsGoal;
    private double income; 

    public Budget() {
        categoryLimits = new HashMap<>();
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    
    public void setSavingsGoal(double goal) {
        this.savingsGoal = goal;
    }

    public double getSavingsGoal() {
        return savingsGoal;
    }

    public void setCategoryLimit(String category, double limit) {
        categoryLimits.put(category, limit);
    }

    public double getCategoryLimit(String category) {
        return categoryLimits.getOrDefault(category, 0.0);
    }

    public Map<String, Double> getCategoryLimits() {
        return categoryLimits;
    }
}
