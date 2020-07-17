public class Vendor extends Person
{
  String strBaseBuildResults;
  String strDatabaseType;
  String strRetCreationData;
  String orgRelationship;
  int intVendorID;
  String strVendorID;
  String passedVendorID;
  
  public String setRelationshipType()
  {
    orgRelationship="Vendor";
    System.out.println ("The database Type is "+orgRelationship);
    
    return orgRelationship;
  }

  public String setID(int newID)
  {
    intVendorID=newID+1;
    strVendorID=String.valueOf(intVendorID);
    System.out.println ("Assigned Vendor ID is "+strVendorID);
    
    return strVendorID;
  }

  public String newUser(String first, String last, String address, String phone, String email, int highID)
  {
    strDatabaseType=setRelationshipType();
    strBaseBuildResults=buildBaseUser(first, last, address, phone, email);
    passedVendorID=setID(highID);
    strRetCreationData=strDatabaseType+","+strBaseBuildResults+","+passedVendorID;
    return strRetCreationData;
  }
}