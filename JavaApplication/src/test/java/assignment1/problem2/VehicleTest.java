package assignment1.problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {
  private Vehicle vehicle;
  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    vehicle = new NewCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 2);
  }

  /**
   * Testcase to verify the vehicle id
   */
  @Test
  void getVehicleId() {
    Assertions.assertNotEquals("Id200", this.vehicle.getVehicleId());
  }

  /**
   * Testcase to verify setting the vehicle id
   */
  @Test
  void setVehicleId() {
    this.vehicle.setVehicleId("Id5000000");
    Assertions.assertEquals("Id5000000", this.vehicle.getVehicleId());
  }

  /**
   * Testcase to verify the manufacture year
   */
  @Test
  void getManufactureYear() {
    Assertions.assertEquals(2020, this.vehicle.getManufactureYear());
  }

  /**
   * Testcase to verify setting the manufacture year
   */
  @Test
  void setManufactureYear() {
    this.vehicle.setManufactureYear(2021);
    Assertions.assertEquals(2021, this.vehicle.getManufactureYear());
  }

  /**
   * Testcase to verify the make and model of vehicle
   */
  @Test
  void getMakeAndModel() {
    Assertions.assertEquals(new MakeModel("Volkswagen", "Vento"), this.vehicle.getMakeAndModel());
  }

  /**
   * Testcase to verify setting the make and model of vehicle
   */
  @Test
  void setMakeAndModel() {
    this.vehicle.setMakeAndModel(new MakeModel("Maruti", "Suzuki"));
    Assertions.assertEquals(new MakeModel("Maruti", "Suzuki"), this.vehicle.getMakeAndModel());
  }

  /**
   * Testcase to verify the manufacturer suggested retail price
   */
  @Test
  void getManufacturePrice() {
    Assertions.assertEquals(70000d, this.vehicle.getManufacturePrice());
  }

  /**
   * Testcase to verify setting the manufacturer suggested retail price
   */
  @Test
  void setManufacturePrice() {
    this.vehicle.setManufacturePrice(80000d);
    Assertions.assertEquals(80000d, this.vehicle.getManufacturePrice());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,vehicle.equals(vehicle));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,vehicle.equals(null));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(true,vehicle.equals(new NewCar(2020, new MakeModel("Volkswagen", "Vento"), 70000d, 2)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.vehicle.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",vehicle.toString());
  }
}