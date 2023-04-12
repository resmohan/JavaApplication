package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import assignment1.problem2.MakeModel;
import assignment1.problem2.NewCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupFilerTest {
  private GroupFiler groupFiler;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    groupFiler = new GroupFiler(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 1000000d, 10000d, 500d, 550d, 0d, 0d, 100d, 0d, 3, 2, 6000d, 1000d);
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is more than 90000
   */
  @Test
  void calculateTaxesHighIncome() {
    double value = (990000d - (100d * 0.65f)) * 0.185f;
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is less than 90000
   */
  @Test
  void calculateTaxesLowIncome() {
    this.groupFiler.setIncomeTaxPaid(950000d);
    double value = (50000d - (100d * 0.65f)) * 0.145f;
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when taxable income is zero
   */
  @Test
  void calculateTaxesNoTax() {
    this.groupFiler.setIncomeTaxPaid(9500000d);
    double value = (1000000d - 9500000d) - (100d * 0.65f);
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when retirement and health savings deduction result become more than 17500
   */
  @Test
  void calculateTaxesRetHealthDed() {
    this.groupFiler.setHealthSavingsAmt(50000d);
    double value = (990000d - 17500d) * 0.185f;
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when child care deduction is considered
   */
  @Test
  void calculateTaxesChildCareDed() {
    this.groupFiler.setLastYearEarnings(180000d);
    double value = (170000d - (100d * 0.65f) - 1250d) * 0.185f;
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the tax calculation; when child care deduction cannot be considered;
   * as the child care expense is not more than 5000
   */
  @Test
  void calculateTaxesChildCareDedLimit() {
    this.groupFiler.setLastYearEarnings(180000d);
    this.groupFiler.setChildExpenses(2000d);
    double value = (170000d - (100d * 0.65f)) * 0.185f;
    Assertions.assertEquals(value, this.groupFiler.calculateTaxes());
  }

  /**
   * Testcase to verify the number of dependents
   */
  @Test
  void getDependents() {
    Assertions.assertEquals(3, this.groupFiler.getDependents());
  }

  /**
   * Testcase to verify setting the number of dependents
   */
  @Test
  void setDependents() {
    this.groupFiler.setDependents(5);
    Assertions.assertEquals(5, this.groupFiler.getDependents());
  }

  /**
   * Testcase to verify the number of minor children
   */
  @Test
  void getMinorChildren() {
    Assertions.assertEquals(2, this.groupFiler.getMinorChildren());
  }

  /**
   * Testcase to verify setting the number of minor children
   */
  @Test
  void setMinorChildren() {
    this.groupFiler.setMinorChildren(3);
    Assertions.assertEquals(3, this.groupFiler.getMinorChildren());
  }

  /**
   * Testcase to verify the Childcare expenses
   */
  @Test
  void getChildExpenses() {
    Assertions.assertEquals(6000d, this.groupFiler.getChildExpenses());
  }

  /**
   * Testcase to verify setting the Childcare expenses
   */
  @Test
  void setChildExpenses() {
    this.groupFiler.setChildExpenses(5000d);
    Assertions.assertEquals(5000d, this.groupFiler.getChildExpenses());
  }

  /**
   * Testcase to verify the Dependent-care expenses
   */
  @Test
  void getDependentExpenses() {
    Assertions.assertEquals(1000d, this.groupFiler.getDependentExpenses());
  }

  /**
   * Testcase to verify setting the Dependent-care expenses
   */
  @Test
  void setDependentExpenses() {
    this.groupFiler.setDependentExpenses(3000d);
    Assertions.assertEquals(3000d, this.groupFiler.getDependentExpenses());
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true,groupFiler.equals(groupFiler));
  }

  @Test
  void testEqualsNull() {
    Assertions.assertEquals(false,groupFiler.equals(null));
  }

  @Test
  void testEqualsDiff() {
    Assertions.assertEquals(true,groupFiler.equals(new GroupFiler(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 1000000d, 10000d, 500d, 550d, 0d, 0d, 100d, 0d, 3, 2, 6000d, 1000d)));
  }

  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.groupFiler.hashCode());
  }
  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",groupFiler.toString());
  }
}