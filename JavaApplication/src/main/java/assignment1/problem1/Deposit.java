package assignment1.problem1;

import java.util.Objects;

/**
 * Represents the deposit object which tracks the number of miles to be transferred to another frequent flyer account
 * including the recipient account and name details
 * @author resmohan
 */
public class Deposit {
  private int miles;
  private String recipientAccountId;
  private Name name;

  /**
   * Creates a new deposit record given the miles to be transferred,
   * account id of the recipient frequent flyer and name details
   * @param miles number of miles to be transferred
   * @param recipientAccountId account id of the recipient frequent flyer
   * @param name name of the recipient frequent flyer
   */
  public Deposit(int miles, String recipientAccountId, Name name){
    this.miles = miles;
    this.recipientAccountId = recipientAccountId;
    this.name = name;
  }

  /**
   * gives the number of miles to be transferred
   * @return the number of miles
   */
  public int getMiles() {
    return miles;
  }

  /**
   * sets the number of miles to be transferred
   * @param miles the number of miles
   */
  public void setMiles(int miles) {
    this.miles = miles;
  }

  /**
   * gives the account id of the recipient frequent flyer
   * @return account id of the recipient frequent flyer
   */
  public String getRecipientAccountId() {
    return recipientAccountId;
  }

  /**
   * sets the account id of the recipient frequent flyer
   * @param recipientAccountId account id of the recipient frequent flyer
   */
  public void setRecipientAccountId(String recipientAccountId) {
    this.recipientAccountId = recipientAccountId;
  }

  /**
   * gives the name details of the recipient frequent flyer
   * @return the name of recipient frequent flyer
   */
  public Name getName() {
    return name;
  }

  /**
   * sets the name details of the recipient frequent flyer
   * @param name the name of recipient frequent flyer
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * This method is used to compare two deposits.
   * It will return true only if both the deposits have same property values
   * @param o deposit instance to be compared
   * @return true or false which indicates whether the two deposits are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) o;
    return miles == deposit.miles && Objects.equals(recipientAccountId,
        deposit.recipientAccountId) && Objects.equals(name, deposit.name);
  }

  /**
   * This method is used to generate the hashcode for a deposit.
   * If two deposits are same, it will return the same hashcode for both of them
   * @return hashcode of the given deposit
   */
  @Override
  public int hashCode() {
    return Objects.hash(miles, recipientAccountId, name);
  }

  /**
   * Generates the string representation of deposit
   * @return string representation of deposit
   */
  @Override
  public String toString() {
    return "Deposit{" +
        "miles=" + miles +
        ", recipientAccountId='" + recipientAccountId + '\'' +
        ", name=" + name +
        '}';
  }
}
