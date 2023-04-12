package assignment1.problem1;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrequentFlyerTest {

  private FrequentFlyer freqFlyer;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    this.freqFlyer = new FrequentFlyer(new Name("John", "Mathew"), "john.mathew@gmail.com", new MilesBalance(5000, 2000, 1500));
  }

  /**
   * Testcase to verify the account id
   */
  @Test
  void getAccountId() {
    FrequentFlyer frequentFlyer = new FrequentFlyer(new Name("Jimmy", "James"), "jimmy.james@gmail.com", new MilesBalance(3000, 500, 100));
    Assertions.assertNotEquals(frequentFlyer.getAccountId(), this.freqFlyer.getAccountId());
  }

  /**
   * Testcase to verify setting the account id
   */
  @Test
  void setAccountId() {
    this.freqFlyer.setAccountId("RM2000");
    Assertions.assertEquals("RM2000", this.freqFlyer.getAccountId());
  }

  /**
   * Testcase to verify the name
   */
  @Test
  void getName() {
    Assertions.assertEquals(new Name("John","Mathew"), this.freqFlyer.getName());
  }

  /**
   * Testcase to verify setting the name
   */
  @Test
  void setName() {
    this.freqFlyer.setName(new Name("Mathew", "John"));
    Assertions.assertEquals(new Name("Mathew", "John"), this.freqFlyer.getName());
  }

  /**
   * Testcase to verify the email id
   */
  @Test
  void getEmail() {
    Assertions.assertEquals("john.mathew@gmail.com", this.freqFlyer.getEmail());
  }

  /**
   * Testcase to verify setting the email id
   */
  @Test
  void setEmail() {
    this.freqFlyer.setEmail("j.m@gmail.com");
    Assertions.assertEquals("j.m@gmail.com", this.freqFlyer.getEmail());
  }

  /**
   * Testcase to verify the miles balance
   */
  @Test
  void getMilesBalance() {
    Assertions.assertEquals(new MilesBalance(5000, 2000, 1500), this.freqFlyer.getMilesBalance());
  }

  /**
   * Testcase to verify setting the miles balance
   */
  @Test
  void setMilesBalance() {
    this.freqFlyer.setMilesBalance(new MilesBalance(6000, 2500, 1000));
    Assertions.assertEquals(new MilesBalance(6000, 2500, 1000), this.freqFlyer.getMilesBalance());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,freqFlyer.equals(freqFlyer));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,freqFlyer.equals(null));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,freqFlyer.equals(new FrequentFlyer(new Name("a","b"),"a.b@gmail.com",new MilesBalance(1,1,1))));
  }
}