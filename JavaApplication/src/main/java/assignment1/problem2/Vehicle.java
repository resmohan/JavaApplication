package assignment1.problem2;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Represents the Vehicle object which tracks the common properties among different types of vehicles.
 * They include unique identifier of vehicle, manufacturing year, make and model of vehicle and manufacturer suggested retail price
 * @author resmohan
 */
public abstract class Vehicle {
  private String vehicleId;
  private int manufactureYear;
  private MakeModel makeAndModel;
  private double manufacturePrice;

  private static final int ID_LENGTH = 12;

  /**
   * Initializes the vehicle related information in vehicle object like manufacturing year,
   * make and model of the vehicle and manufacturer suggested retail price
   * @param manufactureYear year in which vehicle was manufactured
   * @param makeAndModel make and model of the vehicle
   * @param manufacturePrice manufacturer suggested retail price
   */
  public Vehicle(int manufactureYear, MakeModel makeAndModel, double manufacturePrice) {
    this.vehicleId = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    this.manufactureYear = manufactureYear;
    this.makeAndModel = makeAndModel;
    this.manufacturePrice = manufacturePrice;
  }

  /**
   * gives the unique identifier of the vehicle
   * @return unique id of the vehicle
   */
  public String getVehicleId() {
    return vehicleId;
  }

  /**
   * sets the unique identifier of the vehicle
   * @param vehicleId unique id of the vehicle
   */
  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  /**
   * gives the manufacture year of the vehicle
   * @return manufacture year of the vehicle
   */
  public int getManufactureYear() {
    return manufactureYear;
  }

  /**
   * sets the manufacture year of the vehicle
   * @param manufactureYear manufacture year of the vehicle
   */
  public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
  }

  /**
   * gives the make and model of the vehicle
   * @return make and model of the vehicle
   */
  public MakeModel getMakeAndModel() {
    return makeAndModel;
  }

  /**
   * sets the make and model of the vehicle
   * @param makeAndModel make and model of the vehicle
   */
  public void setMakeAndModel(MakeModel makeAndModel) {
    this.makeAndModel = makeAndModel;
  }

  /**
   * gives the manufacturer suggested retail price
   * @return manufacturer suggested retail price
   */
  public double getManufacturePrice() {
    return manufacturePrice;
  }

  /**
   * sets the manufacturer suggested retail price
   * @param manufacturePrice manufacturer suggested retail price
   */
  public void setManufacturePrice(double manufacturePrice) {
    this.manufacturePrice = manufacturePrice;
  }

  /**
   * This method is used to compare two vehicles.
   * It will return true only if both the vehicles have same property values
   * @param o vehicle instance to be compared
   * @return true or false which indicates whether the two vehicles are same or not
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return manufactureYear == vehicle.manufactureYear
        && Double.compare(vehicle.manufacturePrice, manufacturePrice) == 0
        && Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(
        makeAndModel, vehicle.makeAndModel);
  }

  /**
   * This method is used to generate the hashcode for a vehicle.
   * If two vehicles are same, it will return the same hashcode for both of them
   * @return hashcode of the given vehicle
   */
  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, manufactureYear, makeAndModel, manufacturePrice);
  }

  /**
   * Generates the string representation of vehicle
   * @return string representation of vehicle
   */
  @Override
  public String toString() {
    return "Vehicle{" +
        "vehicleId='" + vehicleId + '\'' +
        ", manufactureYear=" + manufactureYear +
        ", makeAndModel=" + makeAndModel +
        ", manufacturePrice=" + manufacturePrice +
        '}';
  }
}
