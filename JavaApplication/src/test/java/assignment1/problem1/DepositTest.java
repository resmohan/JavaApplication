package assignment1.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepositTest {

  private Deposit depositMiles;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    depositMiles = new Deposit(100, "RA1000", new Name("Mathew", "John"));
  }

  /**
   * Testcase to verify miles transferred
   */
  @Test
  void getMiles() {
    Assertions.assertEquals(this.depositMiles.getMiles(), 100);
  }

  /**
   * Testcase to verify setting the miles
   */
  @Test
  void setMiles() {
    this.depositMiles.setMiles(200);
    Assertions.assertEquals(this.depositMiles.getMiles(), 200);
  }

  /**
   * Testcase to verify the recipient account id
   */
  @Test
  void getRecipientAccountId() {
    Assertions.assertEquals(this.depositMiles.getRecipientAccountId(), "RA1000");
  }

  /**
   * Testcase to verify setting the recipient account id
   */
  @Test
  void setRecipientAccountId() {
    this.depositMiles.setRecipientAccountId("RA2000");
    Assertions.assertEquals(this.depositMiles.getRecipientAccountId(), "RA2000");
  }

  /**
   * Testcase to verify the recipient name
   */
  @Test
  void getName() {
    Assertions.assertEquals(this.depositMiles.getName(), new Name("Mathew", "John"));
  }

  /**
   * Testcase to verify setting the name
   */
  @Test
  void setName() {
    this.depositMiles.setName(new Name("Jacob", "John"));
    Assertions.assertEquals(this.depositMiles.getName(), new Name("Jacob", "John"));
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,depositMiles.equals(depositMiles));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,depositMiles.equals(null));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,depositMiles.equals(new Deposit(1,"123",new Name("a","b"))));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.depositMiles.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",depositMiles.toString());
  }
}