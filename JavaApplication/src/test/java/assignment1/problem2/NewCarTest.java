package assignment1.problem2;

import static org.junit.jupiter.api.Assertions.*;

import assignment1.problem1.Deposit;
import assignment1.problem1.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewCarTest {
  private NewCar newCar;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    newCar = new NewCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 2);
  }

  /**
   * Testcase to verify the number of available cars
   */
  @Test
  void getAvailableVehicles() {
    Assertions.assertEquals(2, this.newCar.getAvailableVehicles());
  }

  /**
   * Testcase to verify setting the number of available cars
   */
  @Test
  void setAvailableVehicles() {
    this.newCar.setAvailableVehicles(3);
    Assertions.assertEquals(3, this.newCar.getAvailableVehicles());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,newCar.equals(newCar));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,newCar.equals(null));
  }

  @Test
  void testEqualsDiffObj() {
    Assertions.assertEquals(false,newCar.equals("null"));
  }
  @Test
  void testEqualsSame() {
    Assertions.assertEquals(true,newCar.equals(new NewCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 2)));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(false,newCar.equals(new NewCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 20)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.newCar.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",newCar.toString());
  }
}