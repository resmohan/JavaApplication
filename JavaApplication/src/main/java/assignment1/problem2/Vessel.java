package assignment1.problem2;

/**
 * Represents the vessel object which tracks the common properties and functionalities among different types of water vehicles
 * @author resmohan
 */
public abstract class Vessel extends Vehicle{

  /**
   * Initializes the vehicle related information in vessel object like manufacture year,
   * make and model of vehicle and manufacturer suggested retail price
   * @param manufactureYear manufacture year of the vehicle
   * @param makeAndModel make and model of the vehicle
   * @param manufacturePrice manufacturer suggested retail price of the vehicle
   */
  public Vessel(int manufactureYear, MakeModel makeAndModel, double manufacturePrice) {
    super(manufactureYear, makeAndModel, manufacturePrice);
  }

  /**
   * Generates the string representation of vessel
   * @return string representation of vessel
   */
  @Override
  public String toString() {
    return "Vessel{}";
  }
}
