public class Employee extends Person
{

   public void setRelationshipType()
  {
    String personType="Employee";
    this.orgRelationship=personType;
        System.out.println ("The relationship is "+this.orgRelationship);
  }
}