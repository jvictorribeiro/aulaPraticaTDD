import static org.junit.Assert.assertEquals;

class Dollar extends Money{
  Dollar(int amount) {
    this.amount = amount;
  }  
  Dollar times(int multiplier) {
    return new Dollar(amount * multiplier);
  }
}

public void testMultiplication() {
  Dollar five = new Dollar(5);
  assertEquals(new Dollar(10), five.times(2));
  assertEquals(new Dollar(15), five.times(3));
}


