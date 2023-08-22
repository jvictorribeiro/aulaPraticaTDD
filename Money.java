import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class Money {
  protected int amount;
  private String currency;

  static Money dollar(int amount)  {
    return new Money(amount, "USD");
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && getClass().equals(money.getClass());
  }

  Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
 }

  String currency() {
    return currency;
  }

  @Test
  public void testEquality() {
   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
   assertTrue(Money.franc(5).equals(Money.franc(5)));
   assertFalse(Money.franc(5).equals(Money.dollar(5)));
  }

  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }
}

