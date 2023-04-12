package assignment1.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Represents the frequent flyer object which contains the account id, name, email address
 * and miles balance of a frequent flyer
 * @author resmohan
 */
public class FrequentFlyer {
  private String accountId;
  private Name name;
  private String email;
  private MilesBalance milesBalance;

  private static final int ID_LENGTH = 12;

  /**
   * Creates a new frequent flyer object given the name, email address and miles balance
   * @param name name of the frequent flyer
   * @param email email address of the frequent flyer
   * @param milesBalance miles data of the frequent flyer
   */
  public FrequentFlyer(Name name, String email, MilesBalance milesBalance){
    this.accountId = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    this.name = name;
    this.email = email;
    this.milesBalance = milesBalance;
  }

  /**
   * This method is used to add miles to a frequent flyer's miles balance account
   * @param miles miles to be added
   */
  public void addMiles(int miles){
    MilesBalance milesBal = this.getMilesBalance();
    milesBal.setMilesEarned(milesBal.getMilesEarned() + miles);// add miles to the recipient account
    milesBal.setMilesExpiring(milesBal.getMilesExpiring() + miles);
    milesBal.setTotalMiles(milesBal.getTotalMiles() + miles);
  }

  /**
   * This method is used to reduce miles from a frequent flyer's miles balance account
   * @param miles miles to be reduced
   */
  public void reduceMiles(int miles){
    MilesBalance milesBal = this.getMilesBalance();// reduce miles from the source account
    milesBal.setMilesExpiring((milesBal.getMilesExpiring() > miles) ? (milesBal.getMilesExpiring() - miles) : 0);//ensure that miles expiring is not getting negative
    milesBal.setTotalMiles(milesBal.getTotalMiles() - miles);
  }

  /**
   * gives the account id of the frequent flyer
   * @return account id of the frequent flyer
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * sets the account id of the frequent flyer
   * @param accountId account id of the frequent flyer
   */
  public void setAccountId(String accountId){
    this.accountId = accountId;
  }

  /**
   * gives the name of the frequent flyer
   * @return name of the frequent flyer
   */
  public Name getName(){
    return name;
  }

  /**
   * sets the name of the frequent flyer
   * @param name name of the frequent flyer
   */
  public void setName(Name name){
    this.name = name;
  }

  /**
   * gives the email address of the frequent flyer
   * @return email address of the frequent flyer
   */
  public String getEmail(){
    return email;
  }

  /**
   * sets the email address of the frequent flyer
   * @param email email address of the frequent flyer
   */
  public void setEmail(String email){
    this.email = email;
  }

  /**
   * gives the miles balance of the frequent flyer
   * @return miles balance of the frequent flyer
   */
  public MilesBalance getMilesBalance(){
    return milesBalance;
  }

  /**
   * sets the miles balance of the frequent flyer
   * @param milesBalance miles balance of the frequent flyer
   */
  public void setMilesBalance(MilesBalance milesBalance){
    this.milesBalance = milesBalance;
  }

  /**
   * This method is used to compare two frequent flyers.
   * It will return true only if both the frequent flyers have same property values
   * @param o frequent flyer instance to be compared
   * @return true or false which indicates whether the two frequent flyers are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FrequentFlyer that = (FrequentFlyer) o;
    return Objects.equals(accountId, that.accountId) && Objects.equals(name,
        that.name) && Objects.equals(email, that.email) && Objects.equals(
        milesBalance, that.milesBalance);
  }

  /**
   * This method is used to generate the hashcode for a frequent flyer.
   * If two frequent flyers are same, it will return the same hashcode for both of them
   * @return hashcode of the given frequent flyer
   */
  @Override
  public int hashCode() {
    return Objects.hash(accountId, name, email, milesBalance);
  }

  /**
   * Generates the string representation of frequent flyer
   * @return string representation of frequent flyer
   */
  @Override
  public String toString() {
    return "FrequentFlyer{" +
        "accountId='" + accountId + '\'' +
        ", name=" + name +
        ", email='" + email + '\'' +
        ", milesBalance=" + milesBalance +
        '}';
  }
}
