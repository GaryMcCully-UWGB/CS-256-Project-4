import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.text.*;

public class CRMClass
{
  //Main Method simply starts the program
  static Scanner user_input= new Scanner(System.in);

  ArrayList<String> crmDatabase = new ArrayList<String>();

  Customer customer = new Customer();
  Employee employee = new Employee();
  Vendor vendor = new Vendor();
  
  public void test()
  {
  //  Bob.setName("Bill");
  //  System.out.println(Bob.firstName);
  //  Bob.setID(123);
  //  System.out.println(Bob.customerID);
  //  Bob.setRelationshipType();
  }

  public void listPrintCRMDatabase()
  {
    for(int i=0; i<(crmDatabase.size()); i++)
    {
      String strRawData=crmDatabase.get(i);
      String strArray1[]= strRawData.split(",");
      String typeNoQuotes = strArray1[0].replace("\"", "");
      String strArray2[]={"Type: ","First Name: ", "Last Name: ", "Address: ", "Phone Number: ","E-mail Address: ", typeNoQuotes+" Number: "};

      System.out.println("\nDatabase Entry: " + i);
      for(int j=0; j<7; j++)
      {
        System.out.println(strArray2[j]+strArray1[j]);
      }
    }
    userMenu();
  }

  public void loadDatabase()
  {
    try
    {
      File database = new File("Database.txt");
      Scanner myReader = new Scanner(database);
      while (myReader.hasNextLine()) 
      {
        String data = myReader.nextLine();
        if (data.contains("Employee"))
        {
          crmDatabase.add(data);
        }
        else if (data.contains ("Customer"))
        {
          crmDatabase.add(data);
        }
        else if (data.contains ("Vendor"))
        {
          crmDatabase.add(data);
        }
        else
        {
          System.out.println("The database is corrupt");
        }
      }
      myReader.close();
    } 
    catch (FileNotFoundException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  //Method used to provide user options

  public void userMenu()
  {
    System.out.println("Select '1' to Exit");
    System.out.println("Select '2' to list the current user database");
    System.out.println("Select '3' to update a database entry");
    System.out.println("Select '4' to create a new database entry");

    String strSelection=user_input.nextLine();
    if(strSelection.matches("^[1-4]{1}$"))
    {
      //
    }
    else
    {
      System.out.println("Invalid Selection");
      userMenu();
    }
    int intSelection = Integer.parseInt(strSelection);

    if(intSelection==1)
    {
      System.exit(0);
    }
    else if (intSelection==2)
    {
      listPrintCRMDatabase();
    }
    else if (intSelection==3)
    {
    //  letsMakeaDeal();
      userMenu();
    }
    else
    {
      System.out.println("Please make a valid selection");
      userMenu();
    }
  }

  public static void main(String[] args)
  {
    CRMClass start=new CRMClass();
    System.out.println("Welcome to the Widget Inc. CRM system");
    System.out.println("Loading Current CRM Database");
    start.loadDatabase();
    start.userMenu();
  }
}
