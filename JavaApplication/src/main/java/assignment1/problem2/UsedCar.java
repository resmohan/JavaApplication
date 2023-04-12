package assignment1.problem2;

import java.util.Objects;

/**
 * Represents the used car object which tracks the mileage, number of previous owners and
 * number of minor traffic accidents the car was involved in
 * @author resmohan
 */
public class UsedCar extends Car{
  private int mileage;
  private int prevOwners;
  private int minorAccidents;

  /**
   * Creates a new instance of used car object given the manufacture year, make and model of car,
   * manufacturer suggested retail price, mileage, number of previous owners and number of minor traffic accidents
   * @param manufactureYear manufacture year of the car
   * @param makeAndModel make and model of the car
   * @param manufacturePrice manufacturer suggested retail price of the car
   * @param mileage mileage of car
   * @param prevOwners number of previous owners
   * @param minorAccidents number of minor traffic accidents the car was involved in
   */
  public UsedCar(int manufactureYear, MakeModel makeAndModel, Double manufacturePrice,
      int mileage, int prevOwners, int minorAccidents) {
    super(manufactureYear, makeAndModel, manufacturePrice);
    this.mileage = mileage;
    this.prevOwners = prevOwners;
    this.minorAccidents = minorAccidents;
  }

  /**
   * gives the mileage of the car
   * @return mileage of car
   */
  public int getMileage() {
    return mileage;
  }

  /**
   * sets the mileage of the car
   * @param mileage mileage of car
   */
  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  /**
   * gives the number of previous owners of this car
   * @return number of previous owners
   */
  public int getPrevOwners() {
    return prevOwners;
  }

  /**
   * sets the number of previous owners of this car
   * @param prevOwners number of previous owners
   */
  public void setPrevOwners(int prevOwners) {
    this.prevOwners = prevOwners;
  }

  /**
   * gives the number of minor traffic accidents the car was involved in
   * @return number of minor traffic accidents
   */
  public int getMinorAccidents() {
    return minorAccidents;
  }

  /**
   * sets the number of minor traffic accidents the car was involved in
   * @param minorAccidents number of minor traffic accidents
   */
  public void setMinorAccidents(int minorAccidents) {
    this.minorAccidents = minorAccidents;
  }

  /**
   * This method is used to compare two used cars.
   * It will return true only if both the cars have same property values
   * @param o car instance to be compared
   * @return true or false which indicates whether the two cars are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsedCar usedCar = (UsedCar) o;
    return mileage == usedCar.mileage && prevOwners == usedCar.prevOwners
        && minorAccidents == usedCar.minorAccidents;
  }

  /**
   * This method is used to generate the hashcode for a used car.
   * If two cars are same, it will return the same hashcode for both of them
   * @return hashcode of the given car
   */
  @Override
  public int hashCode() {
    return Objects.hash(mileage, prevOwners, minorAccidents);
  }

  /**
   * Generates the string representation of used car
   * @return string representation of used car
   */
  @Override
  public String toString() {
    return "UsedCar{" +
        "mileage=" + mileage +
        ", prevOwners=" + prevOwners +
        ", minorAccidents=" + minorAccidents +
        '}';
  }
}
