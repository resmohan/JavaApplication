package assignment1.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  private Name nimmy, paul, mathew;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    this.nimmy = new Name("Nimmy","Mariam","Abraham");
    this.paul = new Name("Paul", "Emil");
    this.mathew = new Name("Nimmy", "George", "Mathew");
  }

  /**
   * Testcase to verify first name
   */
  @Test
  void getFirstName() {
    Assertions.assertEquals("Nimmy", this.nimmy.getFirstName());
  }

  /**
   * Testcase to verify middle name
   */
  @Test
  void getMiddleName() {
    Assertions.assertEquals("Mariam", this.nimmy.getMiddleName());
  }

  /**
   * Testcase to verify last name
   */
  @Test
  void getLastName() {
    Assertions.assertEquals("Abraham", this.nimmy.getLastName());
  }

  /**
   * Testcase to verify the scenario of having no middle name
   */
  @Test
  void getMiddleNameNull() {
    Assertions.assertNull(this.paul.getMiddleName());
  }

  /**
   * Testcase to cover the scenario of comparing 2 Name objects; one having all first name,
   * middle name and last name; but other doesn't have middle name
   */
  @Test
  void testEqualsWithoutMidName() {
    Assertions.assertNotEquals(this.nimmy, this.paul);
  }

  /**
   * Testcase to cover the scenario of comparing same 2 Name objects
   */
  @Test
  void testEquals() {
    Assertions.assertEquals(this.nimmy, this.nimmy);
  }

  /**
   * Testcase to cover the scenario of comparing 2 Name objects with same first name
   * but different middle and last names
   */
  @Test
  void testNotEqualsWithMidName() {
    Assertions.assertNotEquals(this.nimmy, this.mathew);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with null value
   */
  @Test
  void testEqualsWithNull() {
    Assertions.assertNotEquals(this.nimmy, null);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with a different object
   */
  @Test
  void testEqualsWithDiffObj() {
    Assertions.assertNotEquals(this.nimmy, new String("Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with no first name
   */
  @Test
  void testEqualsWithNullName() {
    Assertions.assertNotEquals(new Name(null,"Test","Val"), this.nimmy);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with no first name for both objects
   */
  @Test
  void testEqualsWithNullFnameBoth() {
    Assertions.assertNotEquals(new Name(null,"Test","Val"),
                      new Name(null, "Test", null));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with
   * no first name for both objects
   */
  @Test
  void testEqualsWithNullMnameBoth() {
    Assertions.assertNotEquals(new Name(null,null,"Val"),
        new Name(null, null, null));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * no middle name for both objects and same last name
   */
  @Test
  void testEqualsWithNullMname() {
    Assertions.assertEquals(new Name("Test",null,"Val"),
        new Name("Test", null, "Val"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * same middle name and no last name
   */
  @Test
  void testEqualsWithNullLname() {
    Assertions.assertEquals(new Name("Test","Val",null),
        new Name("Test", "Val", null));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * same middle name and different last name
   */
  @Test
  void testEqualsWithLnameNull() {
    Assertions.assertNotEquals(new Name("Check","Val",null),
        new Name("Check", "Val", "Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * different middle name and last name
   */
  @Test
  void testEqualsWithMnameNull() {
    Assertions.assertNotEquals(new Name("Check",null,null),
        new Name("Check", "Val", "Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * same middle name and different last name
   */
  @Test
  void testEqualsWithDiffName() {
    Assertions.assertNotEquals(new Name("Test","Val","Check"),
        new Name("Test", "Val", "Check1"));
  }

  /**
   * Testcase to verify hashcode function
   */
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.nimmy.hashCode());
  }

  /**
   * Testcase to verify hashcode function with null first name
   */
  @Test
  void testHashCodeNullFname() {
    Assertions.assertNotEquals(100, new Name(null,"Test","Val").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null middle name
   */
  @Test
  void testHashCodeNullMname() {
    Assertions.assertNotEquals(100, new Name(null,null,"Val").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null last name
   */
  @Test
  void testHashCodeNullLname() {
    Assertions.assertNotEquals(100, new Name(null,null,null).hashCode());
  }

  /**
   * Testcase to verify setting first name
   */
  @Test
  void setFirstName() {
    nimmy.setFirstName("Nimmy1");
    Assertions.assertEquals("Nimmy1", this.nimmy.getFirstName());
  }

  /**
   * Testcase to verify setting middle name
   */
  @Test
  void setMiddleName() {
    nimmy.setMiddleName("Mariam1");
    Assertions.assertEquals("Mariam1", this.nimmy.getMiddleName());
  }

  /**
   * Testcase to verify setting last name
   */
   @Test
  void setLastName() {
     nimmy.setLastName("Abraham1");
     Assertions.assertEquals("Abraham1", this.nimmy.getLastName());
  }
}