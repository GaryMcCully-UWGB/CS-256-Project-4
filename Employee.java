public class Employee extends Person
{
  int employeeID;
  String strBaseBuildResults;
  String strDatabaseType;
  String strRetCreationData;
  String orgRelationship;
  int intEmployeeID;
  String strEmployeeID;
  String passedEmployeeID;
  
  public String setRelationshipType()
  {
    orgRelationship="Employee";
    System.out.println ("The database Type is "+orgRelationship);
    
    return orgRelationship;
  }

  public String setID(int newID)
  {
    intEmployeeID=newID+1;
    strEmployeeID=String.valueOf(intEmployeeID);
    System.out.println ("Assigned Employee ID is "+strEmployeeID);
    
    return strEmployeeID;
  }

  public String newUser(String first, String last, String address, String phone, String email, int highID)
  {
    strDatabaseType=setRelationshipType();
    strBaseBuildResults=buildBaseUser(first, last, address, phone, email);
    passedEmployeeID=setID(highID);
    strRetCreationData=strDatabaseType+","+strBaseBuildResults+","+passedEmployeeID;
    return strRetCreationData;
  }
}