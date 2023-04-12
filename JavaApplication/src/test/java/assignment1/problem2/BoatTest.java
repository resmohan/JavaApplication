package assignment1.problem2;

import assignment1.problem1.Deposit;
import assignment1.problem1.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoatTest {
  private Boat boat;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    boat = new Boat(2020, new MakeModel("Fibre", "2"), 70000d,4.0f, 15, PropulsionType.JET_PROPULSION);
  }

  /**
   * Testcase to verify boat length
   */
  @Test
  void getLength() {
    Assertions.assertEquals(4.0f, this.boat.getLength());
  }

  /**
   * Testcase to verify setting the boat length
   */
  @Test
  void setLength() {
    this.boat.setLength(5.0f);
    Assertions.assertEquals(5.0f, this.boat.getLength());
  }

  /**
   * Testcase to verify number of passengers
   */
  @Test
  void getNumOfPassengers() {
    Assertions.assertEquals(15, this.boat.getNumOfPassengers());
  }

  /**
   * Testcase to verify setting the number of passengers
   */
  @Test
  void setNumOfPassengers() {
    this.boat.setNumOfPassengers(20);
    Assertions.assertEquals(20, this.boat.getNumOfPassengers());
  }

  /**
   * Testcase to verify propulsion type
   */
  @Test
  void getPropulsionType() {
    Assertions.assertEquals(PropulsionType.JET_PROPULSION, this.boat.getPropulsionType());
  }

  /**
   * Testcase to verify setting the propulsion type
   */
  @Test
  void setPropulsionType() {
    this.boat.setPropulsionType(PropulsionType.INBOARD_ENGINE);
    Assertions.assertEquals(PropulsionType.INBOARD_ENGINE, this.boat.getPropulsionType());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,boat.equals(boat));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,boat.equals(null));
  }

  @Test
  void testEqualsDiffObj() {
    Assertions.assertEquals(false,boat.equals("null"));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,boat.equals(new Boat(2015,null,1000d,2.0f,5,PropulsionType.JET_PROPULSION)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.boat.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",boat.toString());
  }
}