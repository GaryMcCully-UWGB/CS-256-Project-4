public class Person
{
  public String firstName;
  public String lastName;
  public String address;
  public String phoneNumber;
  public String emailAddress;
  public String orgRelationship;

  public void setRelationshipType()
  {
    //
  }
  
  public String newUser()
  {
    return "";
  }

  public String buildBaseUser(String newFirstName, String newLastName, String newAddress, String newPhoneNumber, String newEmailAddress)
  {
    this.firstName=newFirstName;
    this.lastName=newLastName;
    this.address=newAddress;
    this.phoneNumber=newPhoneNumber;
    this.emailAddress=newEmailAddress;

    String formattedString= this.firstName+","+this.lastName+","+this.address+","+this.phoneNumber+","+this.emailAddress;

    return formattedString;
  }
}