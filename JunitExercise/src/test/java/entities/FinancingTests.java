package entities;

import factory.FinancingFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    Financing fin;

    @BeforeEach
    public void init(){
        fin = FinancingFactory.createAvailableFinancing();
    }

    @Test
    public void entryShouldReturnTwentyPercentOfTotalAmount(){
        double expectedValue = 2000.0;

        double result = fin.entry();

        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void quotaShouldReturnEightyTotalAmountPercentDividedByFinancingMonthsWhenQuotaLesserOrEqualsThanHalfIncome() {
        double expectedValue = 800.0;

        double result = fin.quota();

        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    public void constructorShouldDoNothingWhenQuotaLesserOrEqualsThanHalfIncome(){
       Financing fin = new Financing(10000.0, 2000.0, 10);

       Assertions.assertEquals(10000, fin.getTotalAmount());
       Assertions.assertEquals(2000, fin.getIncome());
       Assertions.assertEquals(10, fin.getMonths());
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenTryToCreateFinancingThatQuotaBiggerThanHalfIncome(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing fin = new Financing(10000.0, 799.0, 10);
        });
    }

    @Test
    public void setTotalAmountShouldDoNothingWhenQuotaLesserOrEqualsThanHalfIncome(){
        double expectedValue = 10000;
        fin.setTotalAmount(expectedValue);

        Assertions.assertEquals(expectedValue, fin.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenQuotaBiggerThanHalfIncome(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setTotalAmount(30000.0);
        });
    }

    @Test
    public void setIncomeShouldDoNothingWhenQuotaLesserOrEqualsThanHalfIncome(){
        double expectedValue = 3000;
        fin.setIncome(expectedValue);

        Assertions.assertEquals(expectedValue, fin.getIncome());
    }

    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenQuotaBiggerThanHalfIncome(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setIncome(799.0);
        });
    }

    @Test
    public void setMonthsShouldDoNothingWhenQuotaLesserOrEqualsThanHalfIncome(){
        int expectedValue = 10;
        fin.setMonths(expectedValue);

        Assertions.assertEquals(expectedValue, fin.getMonths());
    }

    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenQuotaBiggerThanHalfIncome(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fin.setMonths(2);
        });
    }

}
