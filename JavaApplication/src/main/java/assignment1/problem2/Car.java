package assignment1.problem2;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Represents the car object which tracks the common properties and functionalities among different types of cars
 * @author resmohan
 */
public abstract class Car extends Vehicle{

  /**
   * Initializes the car related information in car object like manufacture year,
   * make and model of car and manufacturer suggested retail price
   * @param manufactureYear manufacture year of the car
   * @param makeAndModel make and model of the car
   * @param manufacturePrice manufacturer suggested retail price of the car
   */
  public Car(int manufactureYear, MakeModel makeAndModel, double manufacturePrice) {
    super(manufactureYear, makeAndModel, manufacturePrice);
  }

  /**
   * Generates the string representation of car
   * @return string representation of car
   */
  @Override
  public String toString() {
    return "Car{}";
  }
}
