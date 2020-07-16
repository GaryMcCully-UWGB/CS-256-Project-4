public class Vendor extends Person
{
   public void setRelationshipType()
  {
    String personType="Vendor";
    this.orgRelationship=personType;
        System.out.println ("The relationship is "+this.orgRelationship);
  }
}