package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarriedFillingJointTest {

  private MarriedFillingJoint marriedFillingJoint;
  @BeforeEach
  void setUp() {
    marriedFillingJoint = new MarriedFillingJoint(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 1000000d, 10000d, 500d, 550d, 0d, 0d, 100d, 0d, 3, 2, 6000d, 1000d);
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",marriedFillingJoint.toString());
  }
}