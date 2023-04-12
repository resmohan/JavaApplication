package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaxFilerTest {
  private TaxFiler taxFiler;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    taxFiler = new IndividualFiler(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), 100000d, 1000d, 500d, 550d, 0d, 0d, 100d, 0d);
  }

  /**
   * Testcase to verify that the method is returning the basic income as expected
   */
  @Test
  void getBasicIncome() {
    Assertions.assertEquals(99000d, this.taxFiler.getBasicIncome());
  }

  /**
   * Testcase to verify that, when earnings are less than $250000
   * and if mortgage interest is less than $12500, deduction is returned as 0
   */
  @Test
  void getMortgageDeductionLowInterest() {
    Assertions.assertEquals(0d, this.taxFiler.getMortgageDeduction());
  }

  /**
   * Testcase to verify that, when earnings are less than $250000
   * and if mortgage interest is more than $12500, deduction is returned as 2500
   */
  @Test
  void getMortgageDeduction() {
    this.taxFiler.setMortgageInterestPaid(13000d);
    Assertions.assertEquals(2500d, this.taxFiler.getMortgageDeduction());
  }

  /**
   * Testcase to verify that, when earnings are not less than $250000,
   * deduction is returned as 0
   */
  @Test
  void getMortgageDeductionHighIncome() {
    this.taxFiler.setLastYearEarnings(300000d);
    Assertions.assertEquals(0d, this.taxFiler.getMortgageDeduction());
  }

  /**
   * Testcase to verify the tax id
   */
  @Test
  void getTaxId() {
    Assertions.assertNotEquals("ID100", this.taxFiler.getTaxId());
  }

  /**
   * Testcase to verify setting the tax id
   */
  @Test
  void setTaxId() {
    this.taxFiler.setTaxId("ID20000");
    Assertions.assertEquals("ID20000", this.taxFiler.getTaxId());
  }

  /**
   * Testcase to verify the contact info
   */
  @Test
  void getContactInfo() {
    Assertions.assertEquals(new ContactInfo(new Name("John", "Mathew"), "Addr1", "1-222-333-4567", "john.mathew@gmail.com"), this.taxFiler.getContactInfo());
  }

  /**
   * Testcase to verify setting the contact info
   */
  @Test
  void setContactInfo() {
    this.taxFiler.setContactInfo(new ContactInfo(new Name("George", "Thomas"), "Addr1", "1-222-666-4567", "george.thomas@gmail.com"));
    Assertions.assertEquals(new ContactInfo(new Name("George", "Thomas"), "Addr1", "1-222-666-4567", "george.thomas@gmail.com"), this.taxFiler.getContactInfo());
  }

  /**
   * Testcase to verify the last year's earnings
   */
  @Test
  void getLastYearEarnings() {
    Assertions.assertEquals(100000d, this.taxFiler.getLastYearEarnings());
  }

  /**
   * Testcase to verify setting the last year's earnings
   */
  @Test
  void setLastYearEarnings() {
    this.taxFiler.setLastYearEarnings(200000d);
    Assertions.assertEquals(200000d, this.taxFiler.getLastYearEarnings());
  }

  /**
   * Testcase to verify the total income tax already paid
   */
  @Test
  void getIncomeTaxPaid() {
    Assertions.assertEquals(1000d, this.taxFiler.getIncomeTaxPaid());
  }

  /**
   * Testcase to verify setting the total income tax already paid
   */
  @Test
  void setIncomeTaxPaid() {
    this.taxFiler.setIncomeTaxPaid(20000d);
    Assertions.assertEquals(20000d, this.taxFiler.getIncomeTaxPaid());
  }

  /**
   * Testcase to verify the mortgage interest paid
   */
  @Test
  void getMortgageInterestPaid() {
    Assertions.assertEquals(500d, this.taxFiler.getMortgageInterestPaid());
  }

  /**
   * Testcase to verify setting the mortgage interest paid
   */
  @Test
  void setMortgageInterestPaid() {
    this.taxFiler.setMortgageInterestPaid(600d);
    Assertions.assertEquals(600d, this.taxFiler.getMortgageInterestPaid());
  }

  /**
   * Testcase to verify the property taxes paid
   */
  @Test
  void getPropTaxesPaid() {
    Assertions.assertEquals(550d, this.taxFiler.getPropTaxesPaid());
  }

  /**
   * Testcase to verify setting the property taxes paid
   */
  @Test
  void setPropTaxesPaid() {
    this.taxFiler.setPropTaxesPaid(650d);
    Assertions.assertEquals(650d, this.taxFiler.getPropTaxesPaid());
  }

  /**
   * Testcase to verify the student loan and tuition paid
   */
  @Test
  void getStudentAmtPaid() {
    Assertions.assertEquals(0d, this.taxFiler.getStudentAmtPaid());
  }

  /**
   * Testcase to verify setting the student loan and tuition paid
   */
  @Test
  void setStudentAmtPaid() {
    this.taxFiler.setStudentAmtPaid(100d);
    Assertions.assertEquals(100d, this.taxFiler.getStudentAmtPaid());
  }

  /**
   * Testcase to verify the contributions made to a retirement savings account
   */
  @Test
  void getRetirementAmount() {
    Assertions.assertEquals(0d, this.taxFiler.getRetirementAmount());
  }

  /**
   * Testcase to verify setting the contributions made to a retirement savings account
   */
  @Test
  void setRetirementAmount() {
    this.taxFiler.setRetirementAmount(200d);
    Assertions.assertEquals(200d, this.taxFiler.getRetirementAmount());
  }

  /**
   * Testcase to verify the contributions made to a health savings account
   */
  @Test
  void getHealthSavingsAmt() {
    Assertions.assertEquals(100d, this.taxFiler.getHealthSavingsAmt());
  }

  /**
   * Testcase to verify setting the contributions made to a health savings account
   */
  @Test
  void setHealthSavingsAmt() {
    this.taxFiler.setHealthSavingsAmt(300d);
    Assertions.assertEquals(300d, this.taxFiler.getHealthSavingsAmt());
  }

  /**
   * Testcase to verify the charitable donations and contributions
   */
  @Test
  void getDonationAmount() {
    Assertions.assertEquals(0d, this.taxFiler.getDonationAmount());
  }

  /**
   * Testcase to verify setting the charitable donations and contributions
   */
  @Test
  void setDonationAmount() {
    this.taxFiler.setDonationAmount(400d);
    Assertions.assertEquals(400d, this.taxFiler.getDonationAmount());
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",taxFiler.toString());
  }
}