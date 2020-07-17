public class Customer extends Person
{
  String strBaseBuildResults;
  String strDatabaseType;
  String strRetCreationData;
  String orgRelationship;
  int intCustomerID;
  String strCustomerID;
  String passedCustomerID;
  
  protected String setRelationshipType()
  {
    orgRelationship="Customer";
    System.out.println ("The database Type is "+orgRelationship);
    
    return orgRelationship;
  }

  protected String setID(int newID)
  {
    intCustomerID=newID+1;
    strCustomerID=String.valueOf(intCustomerID);
    System.out.println ("Assigned Customer ID is "+strCustomerID);
    
    return strCustomerID;
  }

  protected String newUser(String company,String first, String last, String address, String phone, String email, int highID)
  {
    strDatabaseType=setRelationshipType();
    strBaseBuildResults=buildBaseUser(company, first, last, address, phone, email);
    passedCustomerID=setID(highID);
    strRetCreationData=strDatabaseType+","+strBaseBuildResults+","+passedCustomerID;
    return strRetCreationData;
  }
}