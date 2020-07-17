public class Person
{
  public String firstName;
  public String lastName;
  public String address;
  public String phoneNumber;
  public String emailAddress;

  public String setID()
  {
    return "";
  }
  
  public String setRelationshipType()
  {
    return "";
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

    System.out.println("First Name is "+ this.firstName);
    System.out.println("Last Name is "+ this.lastName);
    System.out.println("Address is "+this.address);
    System.out.println("Phone Number is "+this.phoneNumber);
    System.out.println("E-Mail Address is "+this.emailAddress);

    String formattedString= this.firstName+","+this.lastName+","+this.address+","+this.phoneNumber+","+this.emailAddress;

    return formattedString;
  }
}