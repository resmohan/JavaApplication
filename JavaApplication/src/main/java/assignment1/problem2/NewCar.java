package assignment1.problem2;

import java.util.Objects;

/**
 * Represents the new car object which tracks the number of available cars within 50 miles
 * @author resmohan
 */
public class NewCar extends Car{
  private int availableVehicles;

  /**
   * Creates a new instance of new car object given the manufacture year, make and model of car,
   * manufacturer suggested retail price and number of available cars within 50 miles
   * @param manufactureYear manufacture year of the car
   * @param makeAndModel make and model of the car
   * @param manufacturePrice manufacturer suggested retail price of the car
   * @param availableVehicles number of available cars within 50 miles
   */
  public NewCar(int manufactureYear, MakeModel makeAndModel, Double manufacturePrice,
      int availableVehicles) {
    super(manufactureYear, makeAndModel, manufacturePrice);
    this.availableVehicles = availableVehicles;
  }

  /**
   * gives the number of available cars within 50 miles
   * @return number of available cars
   */
  public int getAvailableVehicles() {
    return availableVehicles;
  }

  /**
   * sets the number of available cars within 50 miles
   * @param availableVehicles number of available cars
   */
  public void setAvailableVehicles(int availableVehicles) {
    this.availableVehicles = availableVehicles;
  }

  /**
   * This method is used to compare two new cars.
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
    NewCar newCar = (NewCar) o;
    return availableVehicles == newCar.availableVehicles;
  }

  /**
   * This method is used to generate the hashcode for a new car.
   * If two cars are same, it will return the same hashcode for both of them
   * @return hashcode of the given car
   */
  @Override
  public int hashCode() {
    return Objects.hash(availableVehicles);
  }

  /**
   * Generates the string representation of new car
   * @return string representation of new car
   */
  @Override
  public String toString() {
    return "NewCar{" +
        "availableVehicles=" + availableVehicles +
        '}';
  }
}
