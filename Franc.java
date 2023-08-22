import static org.junit.Assert.assertEquals;

class Franc extends Money{
  Franc(int amount) {
    this.amount = amount;
  }
  Franc times(int multiplier) {
    return new Franc(amount * multiplier);
  }
}

public void testMultiplication() {
  Franc five = new Franc(5);
  assertEquals(new Franc(10), five.times(2));
  assertEquals(new Franc(15), five.times(3));
}

