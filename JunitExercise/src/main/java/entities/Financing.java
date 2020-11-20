package entities;

public class Financing {
    private Double totalAmount;
    private Double income;
    private Integer months;

    private static final double ENTRY_PERCENT = 0.2;
    private static final double QUOTA_PERCENT = 0.8;

    public Financing(){

    }

    public Financing(Double totalAmount, Double income, Integer months) {
        this.totalAmount = totalAmount;
        this.income = income;
        this.months = months;

        if (quota() > (income/2)) throw new IllegalArgumentException();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;

        if (isQuotaBiggerThanHalfIncome()) throw new IllegalArgumentException();
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;

        if (isQuotaBiggerThanHalfIncome()) throw new IllegalArgumentException();
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;

        if (isQuotaBiggerThanHalfIncome()) throw new IllegalArgumentException();
    }

    public double entry() {
        return totalAmount*ENTRY_PERCENT;
    }

    public double quota() {
        return (totalAmount*QUOTA_PERCENT)/months;
    }

    private boolean isQuotaBiggerThanHalfIncome() {
        double halfIncome = income/2;

        return quota() > halfIncome;
    }
}
