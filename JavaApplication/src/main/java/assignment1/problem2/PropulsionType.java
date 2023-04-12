package assignment1.problem2;

/**
 * Represents the set of values for propulsion type in boat object
 * @author resmohan
 */
public enum PropulsionType {
  /**
   * type of propulsion in which engine id connected to the propeller by a base plate
   */
  SAIL_POWER,
  /**
   * type of propulsion in which engine is enclosed within the hull of the boat
   */
  INBOARD_ENGINE,
  /**
   * type of propulsion in which engine is mounted externally to the rear of boat
   */
  OUTBOARD_ENGINE,
  /**
   * type of propulsion in which air-breathing engines are used
   */
  JET_PROPULSION;

  /**
   * Generates the string representation of propulsion type
   * @return string representation of propulsion type
   */
  @Override
  public String toString() {
    return "PropulsionType{}";
  }
}
