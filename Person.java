public class Person
{
  private String company;
  private String firstName;
  private String lastName;
  private String address;
  private String phoneNumber;
  private String emailAddress;

  protected String setID()
  {
    return "";
  }
  
  protected String setRelationshipType()
  {
    return "";
  }
  
  protected String newUser()
  {
    return "";
  }

  protected String buildBaseUser(String newCompany,String newFirstName, String newLastName, String newAddress, String newPhoneNumber, String newEmailAddress)
  {
    this.company=newCompany;
    this.firstName=newFirstName;
    this.lastName=newLastName;
    this.address=newAddress;
    this.phoneNumber=newPhoneNumber;
    this.emailAddress=newEmailAddress;

    System.out.println("Company is "+ this.company);
    System.out.println("First Name is "+ this.firstName);
    System.out.println("Last Name is "+ this.lastName);
    System.out.println("Address is "+this.address);
    System.out.println("Phone Number is "+this.phoneNumber);
    System.out.println("E-Mail Address is "+this.emailAddress);

    String formattedString= this.firstName+","+this.firstName+","+this.lastName+","+this.address+","+this.phoneNumber+","+this.emailAddress;

    return formattedString;
  }
}