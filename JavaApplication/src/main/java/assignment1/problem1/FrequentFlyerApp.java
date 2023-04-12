package assignment1.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents the frequent flyer app service
 */
public class FrequentFlyerApp {

  private List<FrequentFlyer> freqFlyers;
  private FrequentFlyer currentFreqFlyer;

  private static final int MIN_MILES = 1000;
  private static final int MAX_MILES = 10000;

  /**
   * Validation message to be shown when a frequent flyer tries to transfer miles out of the valid
   * range
   */
  public static final String VALID_RANGE_MSG = "The transferring miles should be in the range of 1000 - 10000";
  /**
   * Validation message to be shown when a frequent flyer is transferring miles and the recipient
   * account id does not match with existing customer data
   */
  public static final String ID_NOT_VALID_MSG = "Recipient account details are not valid. Verify the account id of the recipient frequent flyer";
  /**
   * Validation message to be shown when a frequent flyer is transferring miles and the recipient
   * account id does not match with the name given
   */
  public static final String NAME_NOT_MATCHING_MSG = "Recipient account details are not valid. Account id of the recipient frequent flyer does not match with the name details given";


  /**
   * Creates a new instance of frequent flyer app service
   */
  public FrequentFlyerApp() {
    this.freqFlyers = new ArrayList<>();
  }

  /**
   * Creates a new instance of frequent flyer app service given the list of frequent flyers
   * @param freqFlyers list of frequent flyers
   */
  public FrequentFlyerApp(List<FrequentFlyer> freqFlyers) {
    this.freqFlyers = freqFlyers;
  }

  /**
   * This method is used to add the newly created frequent flyer to the list
   * and set him as the current active frequent flyer
   * @param frequentFlyer frequent flyer
   */
  public void addFrequentFlyer(FrequentFlyer frequentFlyer) {
    this.freqFlyers.add(frequentFlyer);
    this.currentFreqFlyer = frequentFlyer;
  }

  /**
   * Main method to test teh complete flow
   * @param args arguments to main
   */
  public static void main(String[] args) {
    FrequentFlyerApp flyerApp = new FrequentFlyerApp();
    FrequentFlyer freqFlyer = new FrequentFlyer(new Name("John", "Mathew"), "john.mathew@gmail.com",
        new MilesBalance(5000, 2000, 1500));
    FrequentFlyer freqFlyer1 = new FrequentFlyer(new Name("Manish", "Thomas"),
        "manish.thomas@gmail.com", new MilesBalance(2000, 500, 100));
    flyerApp.addFrequentFlyer(freqFlyer);
    flyerApp.addFrequentFlyer(freqFlyer1);

    flyerApp.setCurrentFreqFlyer(freqFlyer);
    Deposit deposit = new Deposit(1500, freqFlyer1.getAccountId(), freqFlyer1.getName());
    flyerApp.transferMiles(deposit);
  }

  /**
   * This method helps to transfer miles from a frequent flyer account to another one
   *
   * @param deposit Deposit object which tracks the number of miles to be transferred and the
   *                recipient account details
   */
  public void transferMiles(Deposit deposit) {
    int miles = deposit.getMiles();
    isValidRange(miles);//verify that user is trying to transfer a valid value of miles

    FrequentFlyer recFreqFlyer = getRecipientAccountDetails(deposit);//get the recipient frequent flyer record
    recFreqFlyer.addMiles(miles);//add miles to recipient frequent flyer
    getCurrentFreqFlyer().reduceMiles(miles);//reduce miles from current frequent flyer
  }

  private void isValidRange(int miles) {
    if (miles < MIN_MILES || miles > MAX_MILES)
      throw new IllegalArgumentException(VALID_RANGE_MSG);
  }

  private FrequentFlyer getRecipientAccountDetails(Deposit deposit) {
    Optional<FrequentFlyer> freqFlyerRec = freqFlyers.stream().
        filter(frFlyer -> frFlyer.getAccountId().equals(deposit.getRecipientAccountId())).
        findFirst();//filter the recipient frequent flyer from the list of flyers using the given account id
    if (freqFlyerRec.isEmpty())//couldn't find any frequent flyer with the given account id
      throw new IllegalArgumentException(ID_NOT_VALID_MSG);
    else {
      FrequentFlyer recFreqFlyer = freqFlyerRec.get();
      Name name = recFreqFlyer.getName();
      if (name.equals(
          deposit.getName()))//verify that the id of the frequent flyer record matches with the recipient's name
        return recFreqFlyer;
      else
        throw new IllegalArgumentException(NAME_NOT_MATCHING_MSG);
    }
  }

  /**
   * Gets the current frequent flyer
   * @return frequent flyer
   */
  public FrequentFlyer getCurrentFreqFlyer() {
    return currentFreqFlyer;
  }

  /**
   * Sets the current frequent flyer
   * @param currentFreqFlyer frequent flyer
   */
  public void setCurrentFreqFlyer(FrequentFlyer currentFreqFlyer) {
    this.currentFreqFlyer = currentFreqFlyer;
  }

  /**
   * This method is used to compare two frequent flyer apps.
   * It will return true only if both the frequent flyer apps have same property values
   * @param o frequent flyer app instance to be compared
   * @return true or false which indicates whether the two frequent flyer apps are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FrequentFlyerApp that = (FrequentFlyerApp) o;
    return Objects.equals(freqFlyers, that.freqFlyers) && Objects.equals(
        currentFreqFlyer, that.currentFreqFlyer);
  }

  /**
   * Generates the string representation of frequent flyer app
   * @return string representation of frequent flyer app
   */
  @Override
  public String toString() {
    return "FrequentFlyerApp{" +
        "freqFlyers=" + freqFlyers +
        ", currentFreqFlyer=" + currentFreqFlyer +
        '}';
  }

  /**
   * This method is used to generate the hashcode for a frequent flyer app.
   * If two frequent flyer apps are same, it will return the same hashcode for both of them
   * @return hashcode of the given frequent flyer app
   */
  @Override
  public int hashCode() {
    return Objects.hash(freqFlyers, currentFreqFlyer);
  }
}
