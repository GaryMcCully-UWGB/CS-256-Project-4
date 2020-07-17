public class Vendor extends Person
{
  int vendorID;
  
  public void setRelationshipType()
  {
    String personType="Vendor";
    this.orgRelationship=personType;
        System.out.println ("The relationship is "+this.orgRelationship);
  }

  public void setID(int newID)
  {
    this.vendorID=newID;
    System.out.println ("New name is "+this.vendorID);
  }

  public String newUser(String first, String last, String address, String phone, String email)
  {

    return "";
  }
}