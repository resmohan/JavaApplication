package assignment1.problem1;

/**
 * Represents the miles balance of a frequent flyer which contains the total miles available,
 * miles earned this year and miles expiring by the end of this calendar year
 * @author resmohan
 */
public class MilesBalance {
  private int totalMiles;
  private int milesEarned;
  private int milesExpiring;

  /**
   * Creates a new miles balance record given the total miles, miles earned and miles expiring this calendar year
   * @param totalMiles total miles earned by a frequent flyer
   * @param milesEarned miles earned by a frequent flyer in this calendar year
   * @param milesExpiring miles expiring for a frequent flyer in this calendar year
   */
  public MilesBalance(int totalMiles, int milesEarned, int milesExpiring){
    this.totalMiles = totalMiles;
    this.milesEarned = milesEarned;
    this.milesExpiring = milesExpiring;
  }

  /**
   * This method is used to compare two miles balance records.
   * It will return true only if both the records have same total miles, miles earned and miles expiring data
   * @param obj miles balance record to be compared
   * @return true or false which indicates whether the two miles balance records are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    MilesBalance milesBal = (MilesBalance) obj;
    return((this.totalMiles == milesBal.getTotalMiles())
        && (this.milesEarned == milesBal.getMilesEarned())
        && (this.milesExpiring == milesBal.getMilesExpiring()));
  }

  /**
   * This method is used to generate the hashcode for a miles balance record.
   * If two miles balance records are equal, it will return the same hashcode for both of them
   * @return hashcode of the given miles balance
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + this.getTotalMiles();
    result = 31 * result + this.getMilesEarned();
    result = 31 * result + this.getMilesExpiring();

    return result;
  }

  /**
   * gives the total miles available for a frequent flyer
   * @return the total miles available
   */
    public int getTotalMiles() {
    return totalMiles;
  }

  /**
   * sets the total miles available for a frequent flyer
   * @param totalMiles the total miles available
   */
  public void setTotalMiles(int totalMiles) {
    this.totalMiles = totalMiles;
  }

  /**
   * gives the miles earned by a frequent flyer in this calendar year
   * @return miles earned this year
   */
  public int getMilesEarned() {
    return milesEarned;
  }

  /**
   * sets the miles earned by a frequent flyer in this calendar year
   * @param milesEarned miles earned this year
   */
  public void setMilesEarned(int milesEarned) {
    this.milesEarned = milesEarned;
  }

  /**
   * gives the miles expiring for a frequent flyer in this calendar year
   * @return miles expiring this year
   */
  public int getMilesExpiring() {
    return milesExpiring;
  }

  /**
   * sets the miles expiring for a frequent flyer in this calendar year
   * @param milesExpiring miles expiring this year
   */
  public void setMilesExpiring(int milesExpiring) {
    this.milesExpiring = milesExpiring;
  }

  /**
   * Generates the string representation of miles balance
   * @return string representation of miles balance
   */
  @Override
  public String toString() {
    return "MilesBalance{" +
        "totalMiles=" + totalMiles +
        ", milesEarned=" + milesEarned +
        ", milesExpiring=" + milesExpiring +
        '}';
  }
}
