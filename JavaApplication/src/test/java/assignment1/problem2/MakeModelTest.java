package assignment1.problem2;

import assignment1.problem1.Deposit;
import assignment1.problem1.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeModelTest {
  private MakeModel makeModel;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("Volkswagen", "Jetta");
  }

  /**
   * Testcase to cover the scenario of comparing same 2 MakeModel objects
   */
  @Test
  void testEquals() {
    Assertions.assertEquals(this.makeModel, this.makeModel);
  }

  /**
   * Testcase to cover the scenario of comparing MakeModel object with null value
   */
  @Test
  void testEqualsWithNull() {
    Assertions.assertNotEquals(this.makeModel, null);
  }

  /**
   * Testcase to cover the scenario of comparing MakeModel object with a different object
   */
  @Test
  void testEqualsWithDiffObj() {
    Assertions.assertNotEquals(this.makeModel, new String("Test"));
  }

  /**
   * Testcase to cover the scenario of comparing MakeModel object with another object of same value
   */
  @Test
  void testEqualsWithSame() {
    Assertions.assertEquals(this.makeModel, new MakeModel("Volkswagen", "Jetta"));
  }

  /**
   * Testcase to cover the scenario of comparing MakeModel object with another object with null make value
   */
  @Test
  void testEqualsWithNullMake() {
    Assertions.assertNotEquals(new MakeModel(null, "Vento"), this.makeModel);
  }

  /**
   * Testcase to cover the scenario of comparing MakeModel object with another object with null model value
   */
  @Test
  void testEqualsWithNullModel() {
    Assertions.assertNotEquals(new MakeModel("Volkswagen", null), this.makeModel);
  }

  /**
   * Testcase to cover the scenario of comparing 2 MakeModel objects with one object having a model value
   */
  @Test
  void testEqualsWithBothNullMake() {
    Assertions.assertNotEquals(new MakeModel(null, "Vento"), new MakeModel(null, null));
  }

  /**
   * Testcase to cover the scenario of comparing 2 MakeModel objects with one object having a make value
   */
  @Test
  void testEqualsWithBothNullModel() {
    Assertions.assertNotEquals(new MakeModel("Volkswagen", null), new MakeModel(null, null));
  }

  /**
   * Testcase to cover the scenario of comparing 2 MakeModel objects with both null
   */
  @Test
  void testEqualsWithBothNull() {
    Assertions.assertEquals(new MakeModel(null, null), new MakeModel(null, null));
  }

  /**
   * Testcase to verify hashcode function
   */
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.makeModel.hashCode());
  }

  /**
   * Testcase to verify hashcode function with null make value
   */
  @Test
  void testHashCodeNullMake() {
    Assertions.assertNotEquals(100, new MakeModel(null,"Jetta").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null model value
   */
  @Test
  void testHashCodeNullModel() {
    Assertions.assertNotEquals(100, new MakeModel("Maruti",null).hashCode());
  }

  /**
   * Testcase to verify the make of car
   */
  @Test
  void getMake() {
    Assertions.assertEquals("Volkswagen", this.makeModel.getMake());
  }

  /**
   * Testcase to verify setting the make of car
   */
  @Test
  void setMake() {
    this.makeModel.setMake("Maruti");
    Assertions.assertEquals("Maruti", this.makeModel.getMake());
  }

  /**
   * Testcase to verify the model of car
   */
  @Test
  void getModel() {
    Assertions.assertEquals("Jetta", this.makeModel.getModel());
  }

  /**
   * Testcase to verify setting the model of car
   */
  @Test
  void setModel() {
    this.makeModel.setModel("800");
    Assertions.assertEquals("800", this.makeModel.getModel());
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",makeModel.toString());
  }
}