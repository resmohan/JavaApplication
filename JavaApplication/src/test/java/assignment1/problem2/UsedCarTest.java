package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsedCarTest {
  private UsedCar usedCar;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    usedCar = new UsedCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 15, 2, 1);
  }

  /**
   * Testcase to verify the mileage of car
   */
  @Test
  void getMileage() {
    Assertions.assertEquals(15, this.usedCar.getMileage());
  }

  /**
   * Testcase to verify setting the mileage of car
   */
  @Test
  void setMileage() {
    this.usedCar.setMileage(25);
    Assertions.assertEquals(25, this.usedCar.getMileage());
  }

  /**
   * Testcase to verify the number of previous owners
   */
  @Test
  void getPrevOwners() {
    Assertions.assertEquals(2, this.usedCar.getPrevOwners());
  }

  /**
   * Testcase to verify setting the number of previous owners
   */
  @Test
  void setPrevOwners() {
    this.usedCar.setPrevOwners(1);
    Assertions.assertEquals(1, this.usedCar.getPrevOwners());
  }

  /**
   * Testcase to verify the number of minor accidents
   */
  @Test
  void getMinorAccidents() {
    Assertions.assertEquals(1, this.usedCar.getMinorAccidents());
  }

  /**
   * Testcase to verify setting the number of minor accidents
   */
  @Test
  void setMinorAccidents() {
    this.usedCar.setMinorAccidents(2);
    Assertions.assertEquals(2, this.usedCar.getMinorAccidents());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,usedCar.equals(usedCar));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,usedCar.equals(null));
  }

  @Test
  void testEqualsDiffObj() {
    Assertions.assertEquals(false,usedCar.equals("null"));
  }
  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,usedCar.equals(new UsedCar(2015,null,100d,20,3,2)));
  }

  @Test
  void testEqualsSame() {
    Assertions.assertEquals(true,usedCar.equals(new UsedCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 15, 2, 1)));
  }

  @Test
  void testEqualsDiffPrevOwner() {
    Assertions.assertEquals(false,usedCar.equals(new UsedCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 15, 5, 1)));
  }

  @Test
  void testEqualsDiffAccidents() {
    Assertions.assertEquals(false,usedCar.equals(new UsedCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 15, 2, 11)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.usedCar.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",usedCar.toString());
  }
}