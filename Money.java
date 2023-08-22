import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

abstract class Money {
  protected int amount;
  private String currency;

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && getClass().equals(money.getClass());
  }

  static Money dollar(int amount)  {
    return new Dollar(amount, "USD");
  }

  static Money franc(int amount) {
    return new Franc(amount, "CHF");
  }

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  String currency() {
    return currency;
  }

  abstract Money times(int multiplier);  

  @Test
  public void testEquality() {
   assertTrue(new Dollar(5).equals(new Dollar(5)));
   assertFalse(new Dollar(5).equals(new Dollar(6)));
   assertTrue(new Franc(5).equals(new Franc(5)));
   assertFalse(new Franc(5).equals(new Franc(6)));
  //  assertFalse(new Franc(5).equals(new Dollar(5)));
  }

  public void testFrancMultiplication() {
    Money five = Money.franc(5);
    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));
  }

  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }
}


class Franc extends Money{
  Franc(int amount, String currency) {
    super(amount, currency);
  }

  Money times(int multiplier) {
    return Money.franc(amount * multiplier);
  }

}

class Dollar extends Money{
	
   Dollar(int amount, String currency) {
      super(amount, currency);
   }

  Money times(int multiplier) {
    return Money.dollar(amount * multiplier);
  }  

}

