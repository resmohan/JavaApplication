package assignment1.problem3;

import java.util.Objects;

/**
 * Represents the group tax filer object who can be one of
 * married filing jointly or separately or head of the household
 * @author resmohan
 */
public class GroupFiler extends TaxFiler{
  private int dependents;
  private int minorChildren;
  private double childExpenses;
  private double dependentExpenses;

  private static final float RETIREMENT_DEDUCT = 0.65f;
  private static final double RETIREMENT_AMT_LIMIT = 17500;
  private static final double CHILD_CARE_EARN_LIMIT = 200000;
  private static final double CHILD_CARE_EXPENSE = 5000;
  private static final double CHILD_CARE_DEDUCTION = 1250;
  private static final double TAXABLE_INCOME_LIMIT = 90000;
  private static final float LOWER_TAX_MULTIPLIER = 0.145f;
  private static final float HIGHER_TAX_MULTIPLIER = 0.185f;

  /**
   * Creates a new instance of group tax filer object given the contact info, last year earnings,
   * total income tax already paid, mortgage interest paid, property taxes paid, student loan and tuition paid,
   * contributions made to a retirement savings account, contributions made to a health savings account,
   * charitable donations and contributions, number of dependents, number of minor children,
   * child care expenses and dependent care expenses
   * @param contactInfo contact information
   * @param lastYearEarnings last year earnings
   * @param incomeTaxPaid total income tax already paid
   * @param mortgageInterestPaid mortgage interest paid
   * @param propTaxesPaid property taxes paid
   * @param studentAmtPaid student loan and tuition paid
   * @param retirementAmount contributions made to a retirement savings account
   * @param healthSavingsAmt contributions made to a health savings account
   * @param donationAmount charitable donations and contributions
   * @param dependents number of dependents
   * @param minorChildren number of minor children
   * @param childExpenses child care expenses
   * @param dependentExpenses dependent care expenses
   */
  public GroupFiler(ContactInfo contactInfo, double lastYearEarnings,
      double incomeTaxPaid, double mortgageInterestPaid, double propTaxesPaid,
      double studentAmtPaid,
      double retirementAmount, double healthSavingsAmt, double donationAmount, int dependents,
      int minorChildren, double childExpenses, double dependentExpenses) {
    super(contactInfo, lastYearEarnings, incomeTaxPaid, mortgageInterestPaid, propTaxesPaid,
        studentAmtPaid, retirementAmount, healthSavingsAmt, donationAmount);
    this.dependents = dependents;
    this.minorChildren = minorChildren;
    this.childExpenses = childExpenses;
    this.dependentExpenses = dependentExpenses;
  }

  /**
   * This method calculates the amount of tax to be paid by the group tax filers
   * @return tax amount to be paid
   */
  @Override
  public double calculateTaxes() {
    double taxableIncome = getBasicIncome() - getRetirementDeduction() - getMortgageDeduction() - getChildCareDeduction();

    if(taxableIncome <= 0)
      return taxableIncome;//if zero, no tax; if less than zero, refund amount
    else if(taxableIncome < TAXABLE_INCOME_LIMIT)
      return(LOWER_TAX_MULTIPLIER * taxableIncome);
    else
      return(HIGHER_TAX_MULTIPLIER * taxableIncome);
  }

  /**
   * This method is used to calculate the retirement and health savings deduction for group tax filers
   * @return retirement and health savings deduction
   */
  private double getRetirementDeduction(){
    //summing up the reported retirement and health savings contributions, and multiplying the sum by 0.65
    double retirementDedAmt = (getRetirementAmount() + getHealthSavingsAmt()) * RETIREMENT_DEDUCT;
    //amount higher than $17500 is floored to $17500
    return (Math.min(retirementDedAmt, RETIREMENT_AMT_LIMIT));
  }

  /**
   * This method is used to calculate the child care deduction for group tax filers
   * @return child care deduction
   */
  private double getChildCareDeduction(){
    //earned less than $200000 and reported more than $5000 in childcare expenses; return $1250 child care deduction
    if(getLastYearEarnings() < CHILD_CARE_EARN_LIMIT && getChildExpenses() > CHILD_CARE_EXPENSE)
      return CHILD_CARE_DEDUCTION;
    else
      return 0;
  }

  /**
   * gives the number of dependents
   * @return number of dependents
   */
  public int getDependents() {
    return dependents;
  }

  /**
   * sets the number of dependents
   * @param dependents number of dependents
   */
  public void setDependents(int dependents) {
    this.dependents = dependents;
  }

  /**
   * gives the number of minor children
   * @return number of minor children
   */
  public int getMinorChildren() {
    return minorChildren;
  }

  /**
   * sets the number of minor children
   * @param minorChildren number of minor children
   */
  public void setMinorChildren(int minorChildren) {
    this.minorChildren = minorChildren;
  }

  /**
   * gives the child care expenses
   * @return child care expenses
   */
  public double getChildExpenses() {
    return childExpenses;
  }

  /**
   * sets the child care expenses
   * @param childExpenses child care expenses
   */
  public void setChildExpenses(double childExpenses) {
    this.childExpenses = childExpenses;
  }

  /**
   * gives the dependent care expenses
   * @return dependent care expenses
   */
  public double getDependentExpenses() {
    return dependentExpenses;
  }

  /**
   * sets the dependent care expenses
   * @param dependentExpenses dependent care expenses
   */
  public void setDependentExpenses(double dependentExpenses) {
    this.dependentExpenses = dependentExpenses;
  }

  /**
   * This method is used to compare two group filers.
   * It will return true only if both the group filers have same property values
   * @param o group filer instance to be compared
   * @return true or false which indicates whether the two group filers are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupFiler that = (GroupFiler) o;
    return dependents == that.dependents && minorChildren == that.minorChildren
        && Double.compare(that.childExpenses, childExpenses) == 0
        && Double.compare(that.dependentExpenses, dependentExpenses) == 0;
  }

  /**
   * This method is used to generate the hashcode for a group filer.
   * If two group filers are same, it will return the same hashcode for both of them
   * @return hashcode of the given group filer
   */
  @Override
  public int hashCode() {
    return Objects.hash(dependents, minorChildren, childExpenses, dependentExpenses);
  }

  /**
   * Generates the string representation of group filer
   * @return string representation of group filer
   */
  @Override
  public String toString() {
    return "GroupFiler{" +
        "dependents=" + dependents +
        ", minorChildren=" + minorChildren +
        ", childExpenses=" + childExpenses +
        ", dependentExpenses=" + dependentExpenses +
        '}';
  }
}
