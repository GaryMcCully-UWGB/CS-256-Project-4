import java.io.*;
import java.util.*;
import java.text.*;

public class CRMClass
{
  //Main Method simply starts the program
  static Scanner user_input= new Scanner(System.in);

  ArrayList<String> crmDatabase = new ArrayList<String>();

  int currentEmpNumber=0;
  int currentCustNumber=0;
  int currentVendNumber=0;
  
  public void updateDatabase()
  {
    //Define Variables
    FileWriter myWriter;
    File currentDatabase;
    File updatedDatabase;

    String dataEntry;
    
    //Reference current database
    currentDatabase = new File("Database.txt");
    //Delete this database
    currentDatabase.delete();

    try
    {
      updatedDatabase = new File("Database.txt");
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
      myWriter = new FileWriter("Database.txt");
      Collections.sort(crmDatabase);
      for(int i=0; i<(crmDatabase.size()); i++)
      {
        dataEntry=crmDatabase.get(i);
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
    //Define variables
    String strSelection;
    String databaseEntry;
    String updatedEntry;
    int intSelection;

    System.out.println("Select Database Entry to update");
    strSelection=user_input.nextLine();
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
    
    intSelection = Integer.parseInt(strSelection);
    
    //Ensure number is within range of database entries
    if ((intSelection<0)||intSelection>(crmDatabase.size()-1))
    {
      System.out.println("Invalid Selection");
      userMenu();
    }
    databaseEntry=crmDatabase.get(intSelection);
    System.out.println(databaseEntry);
    String strArray1[]= databaseEntry.split(",");
    String strArray2[]={"Type","First Name", "Last Name", "Address", "Phone Number","E-mail Address", strArray1[0]+" Number"};

    /*The database type and number should not be edited.To avoid modification of these values, these fields are not presented to the end user during the update*/
    for(int j=1; j<6; j++)
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

    crmDatabase.remove(intSelection);
    crmDatabase.add(intSelection, updatedEntry);
    databaseEntry=crmDatabase.get(intSelection);
    System.out.println(databaseEntry);

    updateDatabase();
    userMenu();
  }

  public void deleteDatabaseEntry()
  {
    //Declare variables
    String strSelection;
    int intSelection;

    System.out.println("Enter the database entry to delete");
    strSelection=user_input.nextLine();
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
    
    intSelection = Integer.parseInt(strSelection);
    
    //Ensure number is within range of database entries
    if ((intSelection<0)||intSelection>(crmDatabase.size()-1))
    {
      System.out.println("Invalid Selection");
      userMenu();
    }

    crmDatabase.remove(intSelection);

    updateDatabase();
    userMenu();
  }

  public void createDatabaseEntry()
  {
    int intSelection;
    String strSelection;
    String newUserCreation;

    Employee employee;
    Customer customer;
    Vendor vendor;

    String[] empInfo;
    String[] custInfo;
    String[] vendInfo;
    String[] createdFields = {"First Name: ", "Last Name: ", "Address: ", "Phone Number: ", "E-Mail Address: "};

    System.out.println("Enter '1' for new employee.");
    System.out.println("Enter '2' for new customer.");
    System.out.println("Enter '3' for new vendor.");
    
    strSelection=user_input.nextLine();
    //Ensure string is not null or a non-number
    if(strSelection.matches("^[1-3]{1}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid selection.");
      userMenu();
    }

    intSelection = Integer.parseInt(strSelection);

    switch(intSelection) 
    {
      case 1:
        employee=new Employee();
        empInfo=new String[5];

        for(int i=0; i<5; i++)
        {
          System.out.println(createdFields[i]);
          empInfo[i]=user_input.nextLine();
        }
     
        newUserCreation=employee.newUser(empInfo[0],empInfo[1],empInfo[2],empInfo[3], empInfo[4], currentEmpNumber);
        crmDatabase.add(newUserCreation);
        currentEmpNumber++;
        break;
      case 2:
        customer=new Customer();
        custInfo=new String[5];

        for(int i=0; i<5; i++)
        {
          System.out.println(createdFields[i]);
          custInfo[i]=user_input.nextLine();
        }
     
        newUserCreation=customer.newUser(custInfo[0],custInfo[1],custInfo[2],custInfo[3], custInfo[4], currentCustNumber);
        crmDatabase.add(newUserCreation);
        currentCustNumber++;
        break;
      default:
        vendor=new Vendor();
        vendInfo=new String[5];

        for(int i=0; i<5; i++)
        {
          System.out.println(createdFields[i]);
          vendInfo[i]=user_input.nextLine();
        }
     
        newUserCreation=vendor.newUser(vendInfo[0],vendInfo[1],vendInfo[2],vendInfo[3], vendInfo[4], currentVendNumber);
        crmDatabase.add(newUserCreation);
        currentVendNumber++;
    }
  updateDatabase();
  userMenu();

  }

  public void listPrintCRMDatabase()
  {
    //Declare variables
    String strRawData;

    for(int i=0; i<(crmDatabase.size()); i++)
    {
      strRawData=crmDatabase.get(i);
      String strArray1[]= strRawData.split(",");
      String strArray2[]={"Type: ","First Name: ", "Last Name: ", "Address: ", "Phone Number: ","E-mail Address: ", strArray1[0]+" Number: "};

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
    int intID;
    File database;
    Scanner myReader;

    try
    {
      database = new File("Database.txt");
      myReader = new Scanner(database);
      while (myReader.hasNextLine()) 
      {
        String data = myReader.nextLine();

        //Parse out ID numbers to track next ID to be assigned
        String strArray1[]= data.split(",");
        intID = Integer.parseInt(strArray1[6]);

        if (data.contains("Employee"))
        {
          crmDatabase.add(data);
          if(intID>currentEmpNumber)
          {
            currentEmpNumber=intID;
          }
        }
        else if (data.contains ("Customer"))
        {
          crmDatabase.add(data);
          if(intID>currentCustNumber)
          {
            currentCustNumber=intID;
          }
        }
        else if (data.contains ("Vendor"))
        {
          crmDatabase.add(data);
          if(intID>currentVendNumber)
          {
            currentVendNumber=intID;
          }
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
    int intSelection;
    String strSelection;

    System.out.println("\nSelect '1' to Exit");
    System.out.println("Select '2' to list the current user database");
    System.out.println("Select '3' to update a database entry");
    System.out.println("Select '4' to create a new database entry");
    System.out.println("Select '5' to delete a database entry");
    System.out.println("Select '6' to delete current database and re-write with updates");

    strSelection=user_input.nextLine();
    if(strSelection.matches("^[1-6]{1}$"))
    {
      //Do nothing
    }
    else
    {
      System.out.println("Invalid Selection");
      userMenu();
    }

    intSelection = Integer.parseInt(strSelection);

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
      createDatabaseEntry();
    }
    else if (intSelection==5)
    {
      deleteDatabaseEntry();
    }
    else if (intSelection==6)
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
