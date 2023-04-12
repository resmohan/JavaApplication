package assignment1.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MilesBalanceTest {
  private MilesBalance milesBal;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    milesBal = new MilesBalance(10000, 2000, 500);
  }

  /**
   * Testcase to verify the total miles
   */
  @Test
  void getTotalMiles() {
    Assertions.assertEquals(10000, this.milesBal.getTotalMiles());
  }

  /**
   * Testcase to verify setting the total miles
   */
  @Test
  void setTotalMiles() {
    this.milesBal.setTotalMiles(20000);
    Assertions.assertEquals(20000, this.milesBal.getTotalMiles());
  }

  /**
   * Testcase to verify the miles earned
   */
  @Test
  void getMilesEarned() {
    Assertions.assertEquals(2000, this.milesBal.getMilesEarned());
  }

  /**
   * Testcase to verify setting the miles earned
   */
  @Test
  void setMilesEarned() {
    this.milesBal.setMilesEarned(3000);
    Assertions.assertEquals(3000, this.milesBal.getMilesEarned());
  }

  /**
   * Testcase to verify the miles expiring
   */
  @Test
  void getMilesExpiring() {
    Assertions.assertEquals(500, this.milesBal.getMilesExpiring());
  }

  /**
   * Testcase to verify setting the miles expiring
   */
  @Test
  void setMilesExpiring() {
    this.milesBal.setMilesExpiring(1000);
    Assertions.assertEquals(1000, this.milesBal.getMilesExpiring());
  }

  /**
   * Testcase to compare the same two instances of miles balance
   */
  @Test
  void testEqualsWithSame() {
    Assertions.assertEquals(this.milesBal, this.milesBal);
  }

  /**
   * Testcase to compare the miles balance with null
   */
  @Test
  void testEquals() {
    Assertions.assertNotEquals(this.milesBal, null);
  }

  /**
   * Testcase to compare the miles balance with a different object
   */
  @Test
  void testEqualsDiffObj() {
    Assertions.assertNotEquals(this.milesBal, new String(""));
  }

  /**
   * Testcase to compare the miles balance with another one having different total miles
   */
  @Test
  void testEqualsDiffMiles() {
    Assertions.assertNotEquals(this.milesBal, new MilesBalance(1000, 500, 0));
  }

  /**
   * Testcase to compare the miles balance with another one with same total miles
   */
  @Test
  void testEqualsSameMiles() {
    Assertions.assertNotEquals(this.milesBal, new MilesBalance(10000, 500, 0));
  }

  /**
   * Testcase to compare the miles balance with another one with different miles expiring
   */
  @Test
  void testEqualsDiffMilesExp() {
    Assertions.assertNotEquals(this.milesBal, new MilesBalance(10000, 2000, 0));
  }

  /**
   * Testcase to verify hashcode function
   */
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.milesBal.hashCode());
  }
}