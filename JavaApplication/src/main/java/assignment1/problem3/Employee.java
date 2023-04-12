package assignment1.problem3;

/**
 * Represents the Employee instance of Individual tax filer
 */
public class Employee extends IndividualFiler{

  /**
   * Creates a new instance of individual tax filer object given the contact info, last year earnings,
   * total income tax already paid, mortgage interest paid, property taxes paid, student loan and
   * tuition paid, contributions made to a retirement savings account, contributions made to a health
   * savings account and charitable donations and contributions
   *
   * @param contactInfo          contact information
   * @param lastYearEarnings     last year earnings
   * @param incomeTaxPaid        total income tax already paid
   * @param mortgageInterestPaid mortgage interest paid
   * @param propTaxesPaid        property taxes paid
   * @param studentAmtPaid       student loan and tuition paid
   * @param retirementAmount     contributions made to a retirement savings account
   * @param healthSavingsAmt     contributions made to a health savings account
   * @param donationAmount       charitable donations and contributions
   */
  public Employee(ContactInfo contactInfo, double lastYearEarnings, double incomeTaxPaid,
      double mortgageInterestPaid, double propTaxesPaid, double studentAmtPaid,
      double retirementAmount, double healthSavingsAmt, double donationAmount) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, mortgageInterestPaid, propTaxesPaid,
        studentAmtPaid, retirementAmount, healthSavingsAmt, donationAmount);
  }

  /**
   * Generates the string representation of employee
   * @return string representation of employee
   */
  @Override
  public String toString() {
    return "Employee{}";
  }
}
