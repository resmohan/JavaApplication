package assignment1.problem2;

/**
 * Represents the make and model object which tracks the make and model of vehicles
 * @author resmohan
 */

public class MakeModel {
  private String make;
  private String model;

  /**
   * Creates a new instance of make model object given the make and model of the vehicle
   * @param make make value of the vehicle
   * @param model model value of the vehicle
   */
  public MakeModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   * This method is used to compare the make and model of two vehicles.
   * It will return true only if both the instances have same make and model values
   * @param obj make model object instance to be compared
   * @return true or false which indicates whether the two objects are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    MakeModel makeModel = (MakeModel) obj;
    return((this.make == null ? makeModel.getMake() == null : this.make.equals(makeModel.getMake()))
        && (this.model == null ? makeModel.getModel() == null : this.model.equals(makeModel.getModel())));
  }

  /**
   * This method is used to generate the hashcode for a make model instance.
   * If two make model instances are same, it will return the same hashcode for both of them
   * @return hashcode of the given make model instance
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getMake() == null ? 0 : this.getMake().hashCode());
    result = 31 * result + (this.getModel() == null ? 0 : this.getModel().hashCode());

    return result;
  }

  /**
   * gives the make value of the vehicle
   * @return make value of the vehicle
   */
  public String getMake() {
    return make;
  }

  /**
   * sets the make value of the vehicle
   * @param make make value of the vehicle
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * gives the model value of the vehicle
   * @return model value of the vehicle
   */
  public String getModel() {
    return model;
  }

  /**
   * sets the model value of the vehicle
   * @param model model value of the vehicle
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * Generates the string representation of make model
   * @return string representation of make model
   */
  @Override
  public String toString() {
    return "MakeModel{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        '}';
  }
}
