public class Person
{
  public String firstName;
  public String lastName;
  public String address;
  public String phoneNumber;
  public String emailAddress;
  public String orgRelationship;

  public void setRelationshipType()
  {}

  public void setName(String newName)
  {
    this.firstName=newName;
    System.out.println ("New name is "+this.firstName);
  }
}