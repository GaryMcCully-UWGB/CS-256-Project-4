public class Customer extends Person
{
  public int customerID;

  public void setRelationshipType()
  {
    String personType="Customer";
    this.orgRelationship=personType;
        System.out.println ("The relationship is "+this.orgRelationship);
  }
  
  public void setID(int newID)
  {
    this.customerID=newID;
    System.out.println ("New name is "+this.customerID);
  }
}
