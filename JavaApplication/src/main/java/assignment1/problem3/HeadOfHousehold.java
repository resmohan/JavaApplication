package assignment1.problem3;

/**
 * Represents the instance of group filer who is the head of household
 */
public class HeadOfHousehold extends GroupFiler{

  /**
   * Creates a new instance of group tax filer object given the contact info, last year earnings,
   * total income tax already paid, mortgage interest paid, property taxes paid, student loan and
   * tuition paid, contributions made to a retirement savings account, contributions made to a health
   * savings account, charitable donations and contributions, number of dependents, number of minor
   * children, child care expenses and dependent care expenses
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
   * @param dependents           number of dependents
   * @param minorChildren        number of minor children
   * @param childExpenses        child care expenses
   * @param dependentExpenses    dependent care expenses
   */
  public HeadOfHousehold(ContactInfo contactInfo, double lastYearEarnings, double incomeTaxPaid,
      double mortgageInterestPaid, double propTaxesPaid, double studentAmtPaid,
      double retirementAmount, double healthSavingsAmt, double donationAmount, int dependents,
      int minorChildren, double childExpenses, double dependentExpenses) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, mortgageInterestPaid, propTaxesPaid,
        studentAmtPaid, retirementAmount, healthSavingsAmt, donationAmount, dependents,
        minorChildren,
        childExpenses, dependentExpenses);
  }

  /**
   * Generates the string representation of head of household
   * @return string representation of head of household
   */
  @Override
  public String toString() {
    return "HeadOfHousehold{}";
  }
}
