package assignment1.problem3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {
  private ContactInfo contact;

  /**
   * Setup the data before running test cases
   */
  @BeforeEach
  void setUp() {
    contact = new ContactInfo(new Name("George", "Thomas"), "Addr1", "1-403-354-5634", "george.thomas@gmail.com");
  }

  /**
   * Testcase to cover the scenario of comparing same 2 ContactInfo objects
   */
  @Test
  void testEquals() {
    Assertions.assertEquals(this.contact, this.contact);
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with null value
   */
  @Test
  void testEqualsWithNull() {
    Assertions.assertNotEquals(this.contact, null);
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with a different object
   */
  @Test
  void testEqualsWithDiffObj() {
    Assertions.assertNotEquals(this.contact, new String("Test"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one with same value
   */
  @Test
  void testEqualsWithSameObj() {
    Assertions.assertEquals(this.contact, new ContactInfo(new Name("George", "Thomas"), "Addr1", "1-403-354-5634", "george.thomas@gmail.com"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null Name
   */
  @Test
  void testEqualsWithNullName() {
    Assertions.assertNotEquals(this.contact, new ContactInfo(null, "Addr1", "1-403-354-5634", "george.thomas@gmail.com"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null address
   */
  @Test
  void testEqualsWithNullAddr() {
    Assertions.assertNotEquals(this.contact, new ContactInfo(new Name("George", "Thomas"), null, "1-403-354-5634", "george.thomas@gmail.com"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null phone number
   */
  @Test
  void testEqualsWithNullPhone() {
    Assertions.assertNotEquals(this.contact, new ContactInfo(new Name("George", "Thomas"), "Addr1", null, "george.thomas@gmail.com"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null email address
   */
  @Test
  void testEqualsWithNullEmail() {
    Assertions.assertNotEquals(this.contact, new ContactInfo(new Name("George", "Thomas"), "Addr1", "1-403-354-5634", null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null Name and different address
   */
  @Test
  void testEqualsWithDiffName() {
    Assertions.assertNotEquals(new ContactInfo(null, "A1", "1-403-444-4567", null), new ContactInfo(new Name("George1", "Thomas"), "Addr1", "1-403-354-5634", "george.thomas@gmail.com"));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null Name and different address
   */
  @Test
  void testEqualsWithDiffAddr() {
    Assertions.assertNotEquals(new ContactInfo(null, "A1", "1-403-444-4567", null), new ContactInfo(null, null, "1-403-444-4567", null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null Name, null address and same phone
   */
  @Test
  void testEqualsWithSamePhone() {
    Assertions.assertEquals(new ContactInfo(null, null, "1-403-444-4567", null), new ContactInfo(null, null, "1-403-444-4567", null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null Name, null address,null phone and different email
   */
  @Test
  void testEqualsWithDiffEmail() {
    Assertions.assertNotEquals(new ContactInfo(null, null, null, "j.t@gmail.com"), new ContactInfo(null, null, null, null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null phone and different email
   */
  @Test
  void testEqualsWithNullPh() {
    Assertions.assertNotEquals(new ContactInfo(new Name("George", "Thomas"), "A1", null, null), new ContactInfo(new Name("George", "Thomas"), "A1", "1-33-444-5678", null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null address and different phone
   */
  @Test
  void testEqualsWithNullAddress() {
    Assertions.assertNotEquals(new ContactInfo(new Name("George", "Thomas"), null, null, null), new ContactInfo(new Name("George", "Thomas"), "A1", "1-33-444-5678", null));
  }

  /**
   * Testcase to cover the scenario of comparing ContactInfo object with another one having null email address
   */
  @Test
  void testEqualsWithNullEmailAddr() {
    Assertions.assertNotEquals(new ContactInfo(new Name("George", "Thomas"), "A1", "1-403-333-4567", null), new ContactInfo(new Name("George", "Thomas"), "A1", "1-403-333-4567", "j.t@gmail.com"));
  }

  /**
   * Testcase to verify hashcode function
   */
  @Test
  void testHashCode() {
    Assertions.assertNotEquals(100, this.contact.hashCode());
  }

  /**
   * Testcase to verify hashcode function with null name
   */
  @Test
  void testHashCodeNullName() {
    Assertions.assertNotEquals(100, new ContactInfo(null,"Test", "1-403-234", "r.r@gmail.com").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null address
   */
  @Test
  void testHashCodeNullAddress() {
    Assertions.assertNotEquals(100, new ContactInfo(new Name("Manu", "S"),null, "1-333-444-5678", "a.b@gmail.com").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null phone
   */
  @Test
  void testHashCodeNullPhone() {
    Assertions.assertNotEquals(100, new ContactInfo(new Name("Manu", "S"),"A1", null, "a.b@gmail.com").hashCode());
  }

  /**
   * Testcase to verify hashcode function with null email address
   */
  @Test
  void testHashCodeNullEmailAddr() {
    Assertions.assertNotEquals(100, new ContactInfo(new Name("Manu", "S"),"A1", "1-333-444-5678", null).hashCode());
  }

  /**
   * Testcase to verify the name
   */
  @Test
  void getName() {
    Assertions.assertEquals(new Name("George", "Thomas"), this.contact.getName());
  }

  /**
   * Testcase to verify setting the name
   */
  @Test
  void setName() {
    this.contact.setName(new Name("Varsha", "Mathew"));
    Assertions.assertEquals(new Name("Varsha", "Mathew"), this.contact.getName());
  }

  /**
   * Testcase to verify the address
   */
  @Test
  void getAddress() {
    Assertions.assertEquals("Addr1", this.contact.getAddress());
  }

  /**
   * Testcase to verify setting the address
   */
  @Test
  void setAddress() {
    this.contact.setAddress("Addr2");
    Assertions.assertEquals("Addr2", this.contact.getAddress());
  }

  /**
   * Testcase to verify the phone number
   */
  @Test
  void getPhoneNumber() {
    Assertions.assertEquals("1-403-354-5634", this.contact.getPhoneNumber());
  }

  /**
   * Testcase to verify setting the phone number
   */
  @Test
  void setPhoneNumber() {
    this.contact.setPhoneNumber("1-403-333-5634");
    Assertions.assertEquals("1-403-333-5634", this.contact.getPhoneNumber());
  }

  /**
   * Testcase to verify the email address
   */
  @Test
  void getEmailAddress() {
    Assertions.assertEquals("george.thomas@gmail.com", this.contact.getEmailAddress());
  }

  /**
   * Testcase to verify setting the email address
   */
  @Test
  void setEmailAddress() {
    this.contact.setEmailAddress("g.t@gmail.com");
    Assertions.assertEquals("g.t@gmail.com", this.contact.getEmailAddress());
  }

  @Test
  void testToString() {
    Assertions.assertNotEquals("Test",contact.toString());
  }
}