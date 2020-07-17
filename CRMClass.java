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

    String updatedEntry=strArray1[0]+","+strArray1[1]+","+strArray1[2]+","+strArray1[3]+","+strArray1[4]+","+strArray1[5]+","+strArray1[6];
    crmDatabase.remove(intSelection);
    crmDatabase.add(intSelection, updatedEntry);
    databaseEntry=crmDatabase.get(intSelection);
    System.out.println(databaseEntry);

    updateDatabase();
    userMenu();
  }
  public void deleteDatabaseEntry()
  {
    
  }

  public void createDatabaseEntry()
  {
    System.out.println("Enter '1' for new employee.");
    System.out.println("Enter '2' for new customer.");
    System.out.println("Enter '3' for new vendor.");
    
    String strSelection=user_input.nextLine();
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

    int intSelection = Integer.parseInt(strSelection);

    switch(intSelection) 
    {
      case 1:
        Employee employee=new Employee();
        String[] empInfo=new String[5];
        String[] orderInfoMessages={"First Name: ", "Last Name: ", "Address: ", "Phone Number: ", "E-Mail Address: "};

        for(int i=0; i<5; i++)
        {
          System.out.println(orderInfoMessages[i]);
          empInfo[i]=user_input.nextLine();
        }
     
        String newUserCreation=employee.newUser(empInfo[0],empInfo[1],empInfo[2],empInfo[3], empInfo[4], currentEmpNumber);
        crmDatabase.add(newUserCreation);
        break;
      case 2:
        // code block
        break;
      default:
      // code block
    }
  updateDatabase();
  userMenu();

  }

  public void listPrintCRMDatabase()
  {
    for(int i=0; i<(crmDatabase.size()); i++)
    {
      String strRawData=crmDatabase.get(i);
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

    try
    {
      File database = new File("Database.txt");
      Scanner myReader = new Scanner(database);
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

    System.out.println("\nSelect '1' to Exit");
    System.out.println("Select '2' to list the current user database");
    System.out.println("Select '3' to update a database entry");
    System.out.println("Select '4' to create a new database entry");
    System.out.println("Select '5' to delete a database entry");
    System.out.println("Select '6' to delete current database and re-write with updates");

    String strSelection=user_input.nextLine();
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
