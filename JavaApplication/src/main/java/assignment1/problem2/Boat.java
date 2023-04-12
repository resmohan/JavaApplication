package assignment1.problem2;

import java.util.Objects;

/**
 * Represents the boat object which tracks the boat length, number of passengers and propulsion type
 * @author resmohan
 */
public class Boat extends Vessel{
  private float length;
  private int numOfPassengers;
  private PropulsionType propulsionType;

  /**
   * Creates a new instance of boat object given the manufacture year, make and model of boat,
   * manufacturer suggested retail price, boat length, number of passengers and propulsion type
   * @param manufactureYear manufacture year of the boat
   * @param makeAndModel make and model of the boat
   * @param manufacturePrice manufacturer suggested retail price
   * @param length length of the boat
   * @param numOfPassengers number of passengers
   * @param propulsionType propulsion type
   */
  public Boat(int manufactureYear, MakeModel makeAndModel, double manufacturePrice,
      float length, int numOfPassengers, PropulsionType propulsionType) {
    super(manufactureYear, makeAndModel, manufacturePrice);
    this.length = length;
    this.numOfPassengers = numOfPassengers;
    this.propulsionType = propulsionType;
  }

  /**
   * gives the length of the boat
   * @return boat length
   */
  public float getLength() {
    return length;
  }

  /**
   * sets the length of the boat
   * @param length boat length
   */
  public void setLength(float length) {
    this.length = length;
  }

  /**
   * gives the number of passengers
   * @return number of passengers
   */
  public int getNumOfPassengers() {
    return numOfPassengers;
  }

  /**
   * sets the number of passengers
   * @param numOfPassengers number of passengers
   */
  public void setNumOfPassengers(int numOfPassengers) {
    this.numOfPassengers = numOfPassengers;
  }

  /**
   * gives the propulsion type of the boat
   * @return propulsion type
   */
  public PropulsionType getPropulsionType() {
    return propulsionType;
  }

  /**
   * sets the propulsion type of the boat
   * @param propulsionType propulsion type
   */
  public void setPropulsionType(PropulsionType propulsionType) {
    this.propulsionType = propulsionType;
  }

  /**
   * This method is used to compare two boats.
   * It will return true only if both the boats have same property values
   * @param o boat instance to be compared
   * @return true or false which indicates whether the two boats are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Boat boat = (Boat) o;
    return Float.compare(boat.length, length) == 0
        && numOfPassengers == boat.numOfPassengers && propulsionType == boat.propulsionType;
  }

  /**
   * This method is used to generate the hashcode for a boat.
   * If two boats are same, it will return the same hashcode for both of them
   * @return hashcode of the given boat
   */
  @Override
  public int hashCode() {
    return Objects.hash(length, numOfPassengers, propulsionType);
  }

  /**
   * Generates the string representation of boat
   * @return string representation of boat
   */
  @Override
  public String toString() {
    return "Boat{" +
        "length=" + length +
        ", numOfPassengers=" + numOfPassengers +
        ", propulsionType=" + propulsionType +
        '}';
  }
}
