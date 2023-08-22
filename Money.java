import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Money {
  protected int amount;

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount;
  }
}

public void testEquality() {
   assertTrue(new Dollar(5).equals(new Dollar(5)));
   assertFalse(new Dollar(5).equals(new Dollar(6)));
   assertTrue(new Franc(5).equals(new Franc(5)));
   assertFalse(new Franc(5).equals(new Franc(6)));
}
