public class Vendor extends Person
{
  String strBaseBuildResults;
  String strDatabaseType;
  String strRetCreationData;
  String orgRelationship;
  int intVendorID;
  String strVendorID;
  String passedVendorID;
  
  protected String setRelationshipType()
  {
    orgRelationship="Vendor";
    System.out.println ("The database Type is "+orgRelationship);
    
    return orgRelationship;
  }

  protected String setID(int newID)
  {
    intVendorID=newID+1;
    strVendorID=String.valueOf(intVendorID);
    System.out.println ("Assigned Vendor ID is "+strVendorID);
    
    return strVendorID;
  }

  protected String newUser(String company, String first, String last, String address, String phone, String email, int highID)
  {
    strDatabaseType=setRelationshipType();
    strBaseBuildResults=buildBaseUser(company,first, last, address, phone, email);
    passedVendorID=setID(highID);
    strRetCreationData=strDatabaseType+","+strBaseBuildResults+","+passedVendorID;
    return strRetCreationData;
  }
}