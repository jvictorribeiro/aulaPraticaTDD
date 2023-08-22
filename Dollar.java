import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Dollar extends Money{
  Dollar(int amount) {
    this.amount = amount;
  }  
  Money times(int multiplier) {
    return new Dollar(amount * multiplier);
  }

  @Test
  
}




