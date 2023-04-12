package assignment1.problem3;

/**
 * Represents the individual tax filer object who can be an employee
 * @author resmohan
 */
public class IndividualFiler extends TaxFiler{
  private static final float RETIREMENT_DEDUCT = 0.7f;
  private static final double TAXABLE_INCOME_LIMIT = 55000;
  private static final float LOWER_TAX_MULTIPLIER = 0.15f;
  private static final float HIGHER_TAX_MULTIPLIER = 0.19f;

  /**
   * Creates a new instance of individual tax filer object given the contact info, last year earnings,
   * total income tax already paid, mortgage interest paid, property taxes paid, student loan and tuition paid,
   * contributions made to a retirement savings account, contributions made to a health savings account
   * and charitable donations and contributions
   * @param contactInfo contact information
   * @param lastYearEarnings last year earnings
   * @param incomeTaxPaid total income tax already paid
   * @param mortgageInterestPaid mortgage interest paid
   * @param propTaxesPaid property taxes paid
   * @param studentAmtPaid student loan and tuition paid
   * @param retirementAmount contributions made to a retirement savings account
   * @param healthSavingsAmt contributions made to a health savings account
   * @param donationAmount charitable donations and contributions
   */
  public IndividualFiler(ContactInfo contactInfo, double lastYearEarnings,
      double incomeTaxPaid, double mortgageInterestPaid, double propTaxesPaid,
      double studentAmtPaid,
      double retirementAmount, double healthSavingsAmt, double donationAmount) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, mortgageInterestPaid, propTaxesPaid,
        studentAmtPaid, retirementAmount, healthSavingsAmt, donationAmount);
  }

  /**
   * This method calculates the amount of tax to be paid by the individual tax filer
   * @return tax amount to be paid
   */
  @Override
  public double calculateTaxes() {
    //for individual tax filers, taxable income is calculated by subtracting the retirement and
    //health savings deduction and mortgage interest and property deduction from basic taxable income
    double taxableIncome = getBasicIncome() - getRetirementDeduction() - getMortgageDeduction();

    if(taxableIncome <= 0)//no tax to be paid
      return taxableIncome;//if zero, no tax; if less than zero, refund amount
    else if(taxableIncome < TAXABLE_INCOME_LIMIT)//taxable income lower than $55000
      return(LOWER_TAX_MULTIPLIER * taxableIncome);
    else//taxable income equal to or more than $55000
      return(HIGHER_TAX_MULTIPLIER * taxableIncome);
  }

  /**
   * This method is used to calculate the retirement and health savings deduction for individual tax filers
   * @return retirement and health savings deduction
   */
  private double getRetirementDeduction(){
    //summing up the reported retirement and health savings contributions, and multiplying the sum by 0.7
    return ((getRetirementAmount() + getHealthSavingsAmt()) * RETIREMENT_DEDUCT);
  }

  /**
   * Generates the string representation of individual filer
   * @return string representation of individual filer
   */
  @Override
  public String toString() {
    return "IndividualFiler{}";
  }
}
