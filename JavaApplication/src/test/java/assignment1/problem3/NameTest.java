package assignment1.problem3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {
  private Name name;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    name = new Name("Susan", "Mathew");
  }

  /**
   * Testcase to cover the scenario of comparing same 2 Name objects
   */
  @Test
  void testEquals() {
    Assertions.assertEquals(this.name, this.name);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with null value
   */
  @Test
  void testEqualsWithNull() {
    Assertions.assertNotEquals(this.name, null);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with a different object
   */
  @Test
  void testEqualsWithDiffObj() {
    Assertions.assertNotEquals(this.name, new String("Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with no first name
   */
  @Test
  void testEqualsWithNullName() {
    Assertions.assertNotEquals(new Name(null,"Test"), this.name);
  }

  /**
   * Testcase to cover the scenario of comparing Name object with no first name for both objects
   */
  @Test
  void testEqualsWithNullFnameBoth() {
    Assertions.assertEquals(new Name(null,"Test"), new Name(null, "Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * and no last name
   */
  @Test
  void testEqualsWithNullLname() {
    Assertions.assertEquals(new Name("Test",null), new Name("Test", null));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * and different last name
   */
  @Test
  void testEqualsWithLnameNull() {
    Assertions.assertNotEquals(new Name("Val",null), new Name("Val", "Test"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with same first name,
   * and different last name
   */
  @Test
  void testEqualsWithDiffLname() {
    Assertions.assertNotEquals(new Name("Test", "Check"), new Name("Test", "Check1"));
  }

  /**
   * Testcase to cover the scenario of comparing Name object with different first name,
   * and same last name
   */
  @Test
  void testEqualsWithDiffFname() {
    Assertions.assertNotEquals(new Name("Test1", "Check"), new Name("Test", "Check"));
  }

  /**
   * Testcase to verify hashcode function
   */
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.name.hashCode());
  }

  /**
   * Testcase to verify hashcode function with null first name
   */
  @Test
  void testHashCodeNullFname() {
    Assertions.assertNotEquals(100, new Name(null,"Test").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null last name
   */
  @Test
  void testHashCodeNullLname() {
    Assertions.assertNotEquals(100, new Name("Val",null).hashCode());
  }

  /**
   * Testcase to verify the first name
   */
  @Test
  void getFirstName() {
    Assertions.assertEquals("Susan", this.name.getFirstName());
  }

  /**
   * Testcase to verify setting the first name
   */
  @Test
  void setFirstName() {
    this.name.setFirstName("Manu");
    Assertions.assertEquals("Manu", this.name.getFirstName());
  }

  /**
   * Testcase to verify the last name
   */
  @Test
  void getLastName() {
    Assertions.assertEquals("Mathew", this.name.getLastName());
  }

  /**
   * Testcase to verify setting the last name
   */
  @Test
  void setLastName() {
    this.name.setLastName("Mohan");
    Assertions.assertEquals("Mohan", this.name.getLastName());
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",name.toString());
  }
}