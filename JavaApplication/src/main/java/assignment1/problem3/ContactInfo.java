package assignment1.problem3;

/**
 * Represents the contact information of a user which contains the name, address, phone number and email address
 * @author resmohan
 */
public class ContactInfo {
  private Name name;
  private String address;
  private String phoneNumber;
  private String emailAddress;

  /**
   * Creates a new instance of contact information object given the name, address, phone number and email address
   * @param name name of the user
   * @param address address of the user
   * @param phoneNumber phone number of the user
   * @param emailAddress email address of the user
   */
  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
  }

  /**
   * This method is used to compare two contact info instances.
   * It will return true only if both the instances have same name, address, phone number and email address
   * @param obj contact info instance to be compared
   * @return true or false which indicates whether the two contact infos are same or not
   */
  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;

    if(obj == null || (this.getClass() != obj.getClass()))
      return false;

    ContactInfo contact = (ContactInfo) obj;
    return((this.getName() == null ? contact.getName() == null : this.getName().equals(contact.getName()))
        && (this.getAddress() == null ? contact.getAddress() == null : this.getAddress().equals(contact.getAddress()))
        && (this.getPhoneNumber() == null ? contact.getPhoneNumber() == null : this.getPhoneNumber().equals(contact.getPhoneNumber()))
        && (this.getEmailAddress() == null ? contact.getEmailAddress() == null : this.getEmailAddress().equals(contact.getEmailAddress())));
  }

  /**
   * This method is used to generate the hashcode for a contact info.
   * If two contact infos are same, it will return the same hashcode for both of them
   * @return hashcode of the given contact info
   */
  @Override
  public int hashCode(){
    //take a prime no as hash. take another prime no as multiplier
    int result = 17;
    result = 31 * result + (this.getName() == null ? 0 : this.getName().hashCode());
    result = 31 * result + (this.getAddress() == null ? 0 : this.getAddress().hashCode());
    result = 31 * result + (this.getPhoneNumber() == null ? 0 : this.getPhoneNumber().hashCode());
    result = 31 * result + (this.getEmailAddress() == null ? 0 : this.getEmailAddress().hashCode());

    return result;
  }

  /**
   * gives the name of the user
   * @return name of the user
   */
  public Name getName() {
    return name;
  }

  /**
   * sets the name of the user
   * @param name name of the user
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * gives the address of the user
   * @return address of the user
   */
  public String getAddress() {
    return address;
  }

  /**
   * sets the address of the user
   * @param address address of the user
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * gives the phone number of the user
   * @return phone number of the user
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * sets the phone number of the user
   * @param phoneNumber phone number of the user
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * gives the email address of the user
   * @return email address of the user
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * sets the email address of the user
   * @param emailAddress email address of the user
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * Generates the string representation of contact info
   * @return string representation of contact info
   */
  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
