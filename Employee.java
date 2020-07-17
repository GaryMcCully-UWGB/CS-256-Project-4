public class Employee extends Person
{
  int employeeID;
  public void setRelationshipType()
  {
    String personType="Employee";
    this.orgRelationship=personType;
        System.out.println ("The relationship is "+this.orgRelationship);
  }

  public void setID(int newID)
  {
    this.employeeID=newID;
    System.out.println ("New name is "+this.employeeID);
  }

  public String newUser(String first, String last, String address, String phone, String email)
  {
    return "";
  }
}