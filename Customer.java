public class Customer extends Person
{
  String strBaseBuildResults;
  String strDatabaseType;
  String strRetCreationData;
  String orgRelationship;
  int intCustomerID;
  String strCustomerID;
  String passedCustomerID;
  
  public String setRelationshipType()
  {
    orgRelationship="Customer";
    System.out.println ("The database Type is "+orgRelationship);
    
    return orgRelationship;
  }

  public String setID(int newID)
  {
    intCustomerID=newID+1;
    strCustomerID=String.valueOf(intCustomerID);
    System.out.println ("Assigned Customer ID is "+strCustomerID);
    
    return strCustomerID;
  }

  public String newUser(String first, String last, String address, String phone, String email, int highID)
  {
    strDatabaseType=setRelationshipType();
    strBaseBuildResults=buildBaseUser(first, last, address, phone, email);
    passedCustomerID=setID(highID);
    strRetCreationData=strDatabaseType+","+strBaseBuildResults+","+passedCustomerID;
    return strRetCreationData;
  }
}