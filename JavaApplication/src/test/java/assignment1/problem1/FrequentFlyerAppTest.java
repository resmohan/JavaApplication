package assignment1.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrequentFlyerAppTest {

  private FrequentFlyer freqFlyer, freqFlyer1;
  private FrequentFlyerApp flyerApp;

  @BeforeEach
  void setUp() {
    flyerApp = new FrequentFlyerApp();
    this.freqFlyer = new FrequentFlyer(new Name("John", "Mathew"), "john.mathew@gmail.com", new MilesBalance(5000, 2000, 1500));
    this.freqFlyer1 = new FrequentFlyer(new Name("Manish", "Thomas"), "manish.thomas@gmail.com", new MilesBalance(2000, 500, 100));
    flyerApp.addFrequentFlyer(freqFlyer);
    flyerApp.addFrequentFlyer(freqFlyer1);
    flyerApp.setCurrentFreqFlyer(freqFlyer);
  }

  @Test
  void main() {
    FrequentFlyerApp.main(null);
  }

  /**
   * Testcase to verify that, if user is trying to transfer miles less than the minimum range of 1000;
   * system is throwing the expected exception
   */
  @Test
  void transferMilesMinCase() {
    Deposit depositAcct = new Deposit(100, this.freqFlyer1.getAccountId(), this.freqFlyer1.getName());

    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> this.flyerApp.transferMiles(depositAcct));
    Assertions.assertEquals(FrequentFlyerApp.VALID_RANGE_MSG, exception.getMessage());
  }

  /**
   * Testcase to verify that, if user is trying to transfer miles more than the maximum range of 10000;
   * system is throwing the expected exception
   */
  @Test
  void transferMilesMaxCase() {
    Deposit depositAcct = new Deposit(20000, this.freqFlyer1.getAccountId(), this.freqFlyer1.getName());

    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> this.flyerApp.transferMiles(depositAcct));
    Assertions.assertEquals(FrequentFlyerApp.VALID_RANGE_MSG, exception.getMessage());
  }

  /**
   * Testcase to verify that, if user is transferring a valid value of miles;
   * it is working as expected. Verify that corresponding no of miles are added at the destination side
   */
  @Test
  void transferMilesVerifyReceived() {
    Deposit depositAcct = new Deposit(1000, this.freqFlyer1.getAccountId(), this.freqFlyer1.getName());
    int totalBeforeTransfer = this.freqFlyer1.getMilesBalance().getTotalMiles();
    this.flyerApp.transferMiles(depositAcct);

    Assertions.assertEquals( totalBeforeTransfer + 1000, this.freqFlyer1.getMilesBalance().getTotalMiles());
  }

  /**
   * Testcase to verify that, if user is trying to transfer miles to a non-existing record (wrong recipient account id);
   * system is throwing error as expected
   */
  @Test
  void transferMilesInvalidRecipientId() {
    Deposit depositAcct = new Deposit(4000, "Invalid1000", this.freqFlyer1.getName());

    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> this.flyerApp.transferMiles(depositAcct));
    Assertions.assertEquals(FrequentFlyerApp.ID_NOT_VALID_MSG, exception.getMessage());
  }

  /**
   * Testcase to verify that, if user is trying to transfer miles to a non-existing record (wrong name);
   * system is throwing error as expected
   */
  @Test
  void transferMilesInvalidRecipientName() {
    Deposit depositAcct = new Deposit(4000, this.freqFlyer1.getAccountId(), new Name("Test", "Person"));

    Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> this.flyerApp.transferMiles(depositAcct));
    Assertions.assertEquals(FrequentFlyerApp.NAME_NOT_MATCHING_MSG, exception.getMessage());
  }

  /**
   * Testcase to verify that, if user is transferring a valid value of miles;
   * it is working as expected. Verify that corresponding no of miles are reduced at the source side
   */
  @Test
  void transferMilesVerifyDeducted() {
    Deposit depositAcct = new Deposit(1600, this.freqFlyer1.getAccountId(), this.freqFlyer1.getName());
    int totalBeforeTransfer = this.freqFlyer.getMilesBalance().getTotalMiles();
    this.flyerApp.transferMiles(depositAcct);

    Assertions.assertEquals( totalBeforeTransfer - 1600, this.freqFlyer.getMilesBalance().getTotalMiles());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,flyerApp.equals(flyerApp));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,flyerApp.equals(null));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,flyerApp.equals(new FrequentFlyerApp(new ArrayList<>())));
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",flyerApp.toString());
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100,flyerApp.hashCode());
  }
}