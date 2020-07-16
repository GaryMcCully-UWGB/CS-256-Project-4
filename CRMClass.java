import java.io.*;
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
  
  public void updateDatabase()
  {

    //Reference current database
    File currentDatabase = new File("Database.txt");
    //Delete this database
    currentDatabase.delete();

    try
    {
      File updatedDatabase = new File("Database.txt");
      //Create new database
      updatedDatabase.createNewFile();
    }
    catch (IOException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
    try
    {
      //Write contents of CRM Database ArrayList to new database file
      FileWriter myWriter = new FileWriter("Database.txt"); 
      for(int i=0; i<(crmDatabase.size()); i++)
      {
        String dataEntry=crmDatabase.get(i);
        myWriter.write(dataEntry+"\n");
      }
      myWriter.close();
    }
    catch (IOException e)
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    userMenu();
  }

  public void updateDatabaseEntry()
  {
    System.out.println("Select Database Entry to update");
    String strSelection=user_input.nextLine();
    //Ensure string is not null or a non-number
    if(strSelection.matches("^[0-9]{1,3}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid Selection");
      userMenu();
    }
    
    int intSelection = Integer.parseInt(strSelection);
    
    //Ensure number is within range of database entries
    if ((intSelection<0)||intSelection>crmDatabase.size())
    {
      System.out.println("Invalid Selection");
      userMenu();
    }
    String databaseEntry=crmDatabase.get(intSelection);
    System.out.println(databaseEntry);
    String strArray1[]= databaseEntry.split(",");
    String typeNoQuotes = strArray1[0].replace("\"", "");
    String strArray2[]={"Type","First Name", "Last Name", "Address", "Phone Number","E-mail Address", typeNoQuotes+" Number"};

    String updatedEntry;

    for(int j=0; j<7; j++)
    {
        System.out.println(strArray2[j]+" value is "+strArray1[j]);
        System.out.println("Do you want to change this value? 'Y' for yes, 'N' for No");
        strSelection=user_input.nextLine();
      if(strSelection.matches("^[Y]{1}$"))
      {
        System.out.println("Enter new "+ strArray2[j]+ " value");
        strSelection=user_input.nextLine();
        strArray1[j]=strSelection;
      }
      else if(strSelection.matches("^[N]{1}$"))
      {
        //Do nothing
      }
      else
      {
        System.out.println("Invalid Selection");
        userMenu();
      }

    }

    updatedEntry=strArray1[0]+","+strArray1[1]+","+strArray1[2]+","+strArray1[3]+","+strArray1[4]+","+strArray1[5]+","+strArray1[6];
    crmDatabase.add(intSelection, updatedEntry);
    databaseEntry=crmDatabase.get(intSelection);
    System.out.println(databaseEntry);
    userMenu();
  }

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
    System.out.println("Select '5' to delete current database and re-write with updates");

    String strSelection=user_input.nextLine();
    if(strSelection.matches("^[1-5]{1}$"))
    {
      //Do nothing
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
      updateDatabaseEntry();
    }
    else if (intSelection==4)
    {

    }
    else if (intSelection==5)
    {
      updateDatabase();
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
