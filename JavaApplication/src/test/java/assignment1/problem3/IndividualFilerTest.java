package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualFilerTest {
  private IndividualFiler individualFiler;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    individualFiler = new IndividualFiler(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 100000d, 1000d, 500d, 550d, 0d, 0d, 100d, 0d);
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is more than 55000
   */
  @Test
  void calculateTaxesHighIncome() {
    double value = (99000d - (0.7f * 100d)) * 0.19f;
    Assertions.assertEquals(value, this.individualFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is less than 55000
   */
  @Test
  void calculateTaxesLowIncome() {
    this.individualFiler.setHealthSavingsAmt(100000d);
    double value = (99000d - (0.7f * 100000d)) * 0.15f;
    Assertions.assertEquals(value, this.individualFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is zero
   */
  @Test
  void calculateTaxesNoTax() {
    this.individualFiler.setHealthSavingsAmt(1000000d);
    double value = (99000d - (0.7f * 1000000d));
    Assertions.assertEquals(value, this.individualFiler.calculateTaxes());
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",individualFiler.toString());
  }
}