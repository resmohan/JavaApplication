package assignment1.problem3;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Represents the tax filer object which contains the tax related information like tax id,
 * contact info, last year earnings, total income tax already paid, mortgage interest paid,
 * property taxes paid, student loan and tuition paid, contributions made to a retirement savings account,
 * contributions made to a health savings account and charitable donations and contributions
 * @author resmohan
 */
public abstract class TaxFiler {
  private String taxId;
  private ContactInfo contactInfo;
  private double lastYearEarnings;
  private double incomeTaxPaid;
  private double mortgageInterestPaid;
  private double PropTaxesPaid;
  private double studentAmtPaid;
  private double retirementAmount;
  private double healthSavingsAmt;
  private double donationAmount;

  private static int ID_LENGTH = 12;
  private static final double MORTGAGE_EARN_LIMIT = 250000;
  private static final double MORTGAGE_INTEREST_LIMIT = 12500;
  private static final double MORTGAGE_DEDUCTION = 2500;

  /**
   * Initializes the tax related information in tax filer object like contact info, last year earnings,
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
  public TaxFiler(ContactInfo contactInfo, double lastYearEarnings,
      double incomeTaxPaid, double mortgageInterestPaid, double propTaxesPaid,
      double studentAmtPaid,
      double retirementAmount, double healthSavingsAmt, double donationAmount) {

    this.taxId = RandomStringUtils.randomAlphanumeric(ID_LENGTH);;
    this.contactInfo = contactInfo;
    this.lastYearEarnings = lastYearEarnings;
    this.incomeTaxPaid = incomeTaxPaid;
    this.mortgageInterestPaid = mortgageInterestPaid;
    PropTaxesPaid = propTaxesPaid;
    this.studentAmtPaid = studentAmtPaid;
    this.retirementAmount = retirementAmount;
    this.healthSavingsAmt = healthSavingsAmt;
    this.donationAmount = donationAmount;
  }

  /**
   * This method calculates the amount of tax to be paid by the tax filer
   * @return tax amount to be paid
   */
  public abstract double calculateTaxes();

  /**
   * This method is used to calculate the basic taxable income for all tax filers.
   * It is calculated by subtracting the amount of income taxes already paid from their last year’s earnings.
   * @return basic taxable income
   */
  protected double getBasicIncome(){
    return (getLastYearEarnings() - getIncomeTaxPaid());
  }

  /**
   * This method is used to calculate the mortgage interest and property tax deduction for all tax filers.
   * For tax filers who have earned less than $250000 last year, and who have reported more than $12500 in
   * mortgage interests and property taxes expenses, $2500 is returned as mortgage interest and property tax deduction.
   * @return mortgage interest and property tax deduction
   */
  protected double getMortgageDeduction(){
    if(getLastYearEarnings() < MORTGAGE_EARN_LIMIT && getMortgageInterestPaid() > MORTGAGE_INTEREST_LIMIT)
      return MORTGAGE_DEDUCTION;
    else
      return 0;
  }

  /**
   * gives the tax id of the filer
   * @return unique tax filer identifier
   */
  public String getTaxId() {
    return taxId;
  }

  /**
   * sets the tax id of the filer
   * @param taxId unique tax filer identifier
   */
  public void setTaxId(String taxId) {
    this.taxId = taxId;
  }

  /**
   * gives the contact information of the tax filer
   * @return contact information of the tax filer
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * sets the contact information of the tax filer
   * @param contactInfo contact information of the tax filer
   */
  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  /**
   * gives the last year earnings of the tax filer
   * @return last year earnings of the tax filer
   */
  public double getLastYearEarnings() {
    return lastYearEarnings;
  }

  /**
   * sets the last year earnings of the tax filer
   * @param lastYearEarnings last year earnings of the tax filer
   */
  public void setLastYearEarnings(double lastYearEarnings) {
    this.lastYearEarnings = lastYearEarnings;
  }

  /**
   * gives the total income tax already paid by the tax filer
   * @return total income tax already paid
   */
  public double getIncomeTaxPaid() {
    return incomeTaxPaid;
  }

  /**
   * sets the total income tax already paid by the tax filer
   * @param incomeTaxPaid total income tax already paid
   */
  public void setIncomeTaxPaid(double incomeTaxPaid) {
    this.incomeTaxPaid = incomeTaxPaid;
  }

  /**
   * gives the mortgage interest paid by the tax filer
   * @return mortgage interest paid
   */
  public double getMortgageInterestPaid() {
    return mortgageInterestPaid;
  }

  /**
   * sets the mortgage interest paid by the tax filer
   * @param mortgageInterestPaid mortgage interest paid
   */
  public void setMortgageInterestPaid(double mortgageInterestPaid) {
    this.mortgageInterestPaid = mortgageInterestPaid;
  }

  /**
   * gives the property taxes paid by the tax filer
   * @return property taxes paid
   */
  public double getPropTaxesPaid() {
    return PropTaxesPaid;
  }

  /**
   * sets the property taxes paid by the tax filer
   * @param propTaxesPaid property taxes paid
   */
  public void setPropTaxesPaid(double propTaxesPaid) {
    PropTaxesPaid = propTaxesPaid;
  }

  /**
   * gives the student loan and tuition paid by the tax filer
   * @return student loan and tuition paid
   */
  public double getStudentAmtPaid() {
    return studentAmtPaid;
  }

  /**
   * sets the student loan and tuition paid by the tax filer
   * @param studentAmtPaid student loan and tuition paid
   */
  public void setStudentAmtPaid(double studentAmtPaid) {
    this.studentAmtPaid = studentAmtPaid;
  }

  /**
   * gives the contributions made to a retirement savings account by the tax filer
   * @return contributions made to a retirement savings account
   */
  public double getRetirementAmount() {
    return retirementAmount;
  }

  /**
   * sets the contributions made to a retirement savings account by the tax filer
   * @param retirementAmount contributions made to a retirement savings account
   */
  public void setRetirementAmount(double retirementAmount) {
    this.retirementAmount = retirementAmount;
  }

  /**
   * gives the contributions made to a health savings account by the tax filer
   * @return contributions made to a health savings account
   */
  public double getHealthSavingsAmt() {
    return healthSavingsAmt;
  }

  /**
   * sets the contributions made to a health savings account by the tax filer
   * @param healthSavingsAmt contributions made to a health savings account
   */
  public void setHealthSavingsAmt(double healthSavingsAmt) {
    this.healthSavingsAmt = healthSavingsAmt;
  }

  /**
   * gives the charitable donations and contributions by the tax filer
   * @return charitable donations and contributions
   */
  public double getDonationAmount() {
    return donationAmount;
  }

  /**
   * sets the charitable donations and contributions by the tax filer
   * @param donationAmount charitable donations and contributions
   */
  public void setDonationAmount(double donationAmount) {
    this.donationAmount = donationAmount;
  }

  /**
   * This method is used to compare two tax filers.
   * It will return true only if both the tax filers have same property values
   * @param o tax filer instance to be compared
   * @return true or false which indicates whether the two tax filers are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxFiler taxFiler = (TaxFiler) o;
    return Double.compare(taxFiler.lastYearEarnings, lastYearEarnings) == 0
        && Double.compare(taxFiler.incomeTaxPaid, incomeTaxPaid) == 0
        && Double.compare(taxFiler.mortgageInterestPaid, mortgageInterestPaid) == 0
        && Double.compare(taxFiler.PropTaxesPaid, PropTaxesPaid) == 0
        && Double.compare(taxFiler.studentAmtPaid, studentAmtPaid) == 0
        && Double.compare(taxFiler.retirementAmount, retirementAmount) == 0
        && Double.compare(taxFiler.healthSavingsAmt, healthSavingsAmt) == 0
        && Double.compare(taxFiler.donationAmount, donationAmount) == 0
        && Objects.equals(taxId, taxFiler.taxId) && Objects.equals(contactInfo,
        taxFiler.contactInfo);
  }

  /**
   * This method is used to generate the hashcode for a tax filer.
   * If two tax filers are same, it will return the same hashcode for both of them
   * @return hashcode of the given tax filer
   */
  @Override
  public int hashCode() {
    return Objects.hash(taxId, contactInfo, lastYearEarnings, incomeTaxPaid, mortgageInterestPaid,
        PropTaxesPaid, studentAmtPaid, retirementAmount, healthSavingsAmt, donationAmount);
  }

  /**
   * Generates the string representation of tax filer
   * @return string representation of tax filer
   */
  @Override
  public String toString() {
    return "TaxFiler{" +
        "taxId='" + taxId + '\'' +
        ", contactInfo=" + contactInfo +
        ", lastYearEarnings=" + lastYearEarnings +
        ", incomeTaxPaid=" + incomeTaxPaid +
        ", mortgageInterestPaid=" + mortgageInterestPaid +
        ", PropTaxesPaid=" + PropTaxesPaid +
        ", studentAmtPaid=" + studentAmtPaid +
        ", retirementAmount=" + retirementAmount +
        ", healthSavingsAmt=" + healthSavingsAmt +
        ", donationAmount=" + donationAmount +
        '}';
  }
}
