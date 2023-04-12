package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

  private Employee employee;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    employee = new Employee(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 100000d, 1000d, 500d, 550d, 0d, 0d, 100d, 0d);
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",employee.toString());
  }
}