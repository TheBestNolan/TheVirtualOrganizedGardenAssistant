/***************************************
Nolan Richardson
This code creates a helpful gardening tool
2/08/2024
***************************************/

//Notes: Find out why edit is repeating
import java.util.Scanner;

public class VirtualOrganizingGardenAssistant
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    //for use later
    int rows = 0;
    int columns = 0;
    
    System.out.println("Hello, this is V.O.G.A, the virtual organizing garden assistant.");

    System.out.print("\nHow many rows does the garden have? (Enter an integer, negatives will be turned into their absolute value, 0 will be put to 1): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many rows does the garden have? (Enter an integer greater than 0): "); //re-prompt user for data
    }
    rows = input.nextInt();
    if(rows<0)
    {
      rows*=-1;
    }
    if(rows==0)
    {
      rows = 1;
    }
      
    System.out.print("\nHow many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value, 0 will be put to 1): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value,, 0 will be put to 1): "); //re-prompt user for data
    }
    columns = input.nextInt();
    if(columns<0)
    {
      columns*=-1;
    }
    if(columns==0)
    {
      columns = 1;
    }
    Plant[][] garden = new Plant[rows][columns];
    System.out.println("\nNew " +rows +"x"+columns +" garden created");
    //Allow use of V.O.G.A
    boolean inUse = true;
    System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
    while(inUse)
    {
      String command = input.nextLine();
      if(command.equalsIgnoreCase("expand"))
      {
        garden = expand(garden);
        System.out.println("\nYour new garden is "+garden.length + "x"+garden[0].length);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("shrink"))
      {
        garden = shrink(garden);
        System.out.println("\nYour new garden is "+garden.length + "x"+garden[0].length);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("Plant"))
      {
        garden = place(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("Remove"))
      {
        garden = remove(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("find"))
      {
        find(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("edit"))
      {
        garden=edit(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("display"))
      {
        display(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      if(command.equalsIgnoreCase("show"))
      {
        show(garden);
        System.out.println("\nWhat would you like to do? (Type the word or phrase without the description)\n\nExpand-add rows or columns\nShrink-remove rows or columns\nPlant-plant new plant\nRemove-remove existing plants\nEdit-edit existing plants\nFind-find plants\nDisplay-display plant descriptions\nShow-show map of garden");
      }
      
      
    }
  }
  // make methods for each individual V.O.G.A function
  
  //expand method
  public static Plant[][] expand(Plant[][]oldGarden)
  {
    Scanner input = new Scanner(System.in);
    int rows = oldGarden.length;
    int cols = oldGarden[0].length;
    System.out.print("\nHow many rows do you wish to expand by? (Enter an integer, negatives will be turned into their absolute value): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many rows does the garden have? (Enter an integer greater than 0): "); //re-prompt user for data
    }
    int addRows = input.nextInt();
    if(addRows<0)
    {
      addRows*=-1;
    }
    
    System.out.print("\nHow many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value): "); //re-prompt user for data
    }
    int addCols = input.nextInt();
    if(addCols<0)
    {
      addCols*=-1;
    }
    //Create new larger array with the same features
    Plant[][] garden = new Plant[rows+ addRows][cols + addCols];
    for(int i = 0; i<rows; i++)
    {
      for(int j=0;j<cols; j++)
      {
        garden[i][j] = oldGarden[i][j];
      }
    }
    return garden;
    
  }
  
  //shrink method
  public static Plant[][] shrink(Plant[][]oldGarden)
  {
    Scanner input = new Scanner(System.in);
    int rows = oldGarden.length;
    int cols = oldGarden[0].length;
    System.out.print("\nHow many rows do you wish to expand by? (Enter an integer, negatives will be turned into their absolute value, difference of 0 or less will be set to 1): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many rows does the garden have? (Enter an integer, negatives will be turned into their absolute value, difference of 0 or less will be set to 1): "); //re-prompt user for data
    }
    int subRows = input.nextInt();
    if(subRows>=rows)
    {
      subRows=rows-1;
    }
    
    System.out.print("\nHow many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value, difference of 0 or less will be set to 1): ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("How many columns does the garden have? (Enter an integer, negatives will be turned into their absolute value, difference of 0 or less will be set to 1): "); //re-prompt user for data
    }
    int subCols = input.nextInt();
    if(subCols>=cols)
    {
      subCols = cols-1;
    }
    //Create new smaller array with the same features
    Plant[][] garden = new Plant[rows-subRows][cols-subCols];
    for(int i = 0; i<(rows-subRows)-1; i++)
    {
      for(int j=0;j<(cols-subCols)-1;j++)
      {
        garden[i][j] = oldGarden[i][j];
      }
    }
    return garden; 
  }
  
  //Plant Method
  public static Plant[][] place(Plant[][] garden)
  {
    Scanner input = new Scanner(System.in);
    int rows = garden.length;
    int cols = garden[0].length;
    System.out.println("What is the scientific name of the plant (Make sure you have no misspellings!)");
    String name = input.nextLine();
    System.out.println("What is the stage of the plant? (Choose from this list (Make sure you have no misspellings!): Seed, Sprout, Seedling, Vegitative, Adult)");
    String stage = input.nextLine();
    System.out.println("What is the sex of the plant? (Choose from this list (Make sure you have no misspellings!): Male, Female, N/A)");
    String sex = input.nextLine();
    Plant newPlant = new Plant(name, stage, sex);
    System.out.println("\nRows and columns start at 0");
    System.out.print("Which row would you like to place your plant? (If not in garden, will be set to 0) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("Which row would you like to place your plant? (If not in garden, will be set to 0) "); //re-prompt user for data
    }
    int row = input.nextInt();
    if(row>=rows||row<0)
    {
      row=0;
    }
    
    System.out.print("\n\nWhich column would you like to place your plant? (If not in garden, will be set to 1) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("\n\nWhich column would you like to place your plant? (If not in garden, will be set to 1) "); //re-prompt user for data
    }
    int col = input.nextInt();
    if(col>=cols||col<0)
    {
      col=0;
    }
    System.out.println("You chose position ("+ row +","+col+")");
    for(int i = 0; i<rows; i++)
    {
      for(int j=0;j<cols; j++)
      {
        if(i == row)
        {
          if(j == col)
          {
            if(garden[i][j]!=null)
            {
              
              String instructions = "";
              if(!(instructions.equalsIgnoreCase("yes")||instructions.equalsIgnoreCase("no"))){
              System.out.println("There is already a plant there, do you wish to replace it? (yes/no) ");
              instructions = input.next();
              while(!(instructions.equalsIgnoreCase("yes")||instructions.equalsIgnoreCase("no")))
              {
                   System.out.println("I do not understand...");
                   System.out.println("There is already a plant there, do you wish to replace it? (yes/no) ");
                   instructions = input.next();
                   System.out.println();
              }
              }
              if(instructions.equalsIgnoreCase("yes"))
              {
                System.out.println("The plant was replaced");
                garden[i][j]= newPlant;
              }
              else
              {
                System.out.println("No plant was placed");
              }
            }
            else
            {
              System.out.println("The plant was placed");
              garden[i][j]= newPlant;
            }
          }
        }
      }
    }
    return garden;
    
    
  }
  
  //remove method
  public static Plant[][] remove(Plant[][] garden)
  {
    Scanner input = new Scanner(System.in);
    int rows = garden.length;
    int cols = garden[0].length;
    System.out.println("\nRows and columns start at 0");
    System.out.print("Which row would you like to remove your plant? (If not in garden, will be set to 0) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("Which row would you like to remove your plant? (If not in garden, will be set to 0) "); //re-prompt user for data
    }
    int row = input.nextInt();
    if(row>=rows||row<0)
    {
      row=0;
    }
    
    System.out.print("\n\nWhich column would you like to remove your plant? (If not in garden, will be set to 0) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("\n\nWhich column would you like to place your plant? (If not in garden, will be set to 0) "); //re-prompt user for data
    }
    int col = input.nextInt();
    if(col>=cols||col<0)
    {
      col=0;
    }
    System.out.println("You chose position ("+ row +","+col+")");
    garden[row][col] = null;
    System.out.println("Removed any plants");

    return garden;
  }
  
  //find method
  public static void find(Plant[][] garden)
  {
    Scanner input = new Scanner(System.in);
    System.out.print("What do you want to search by? (name, stage, sex) **CASE SENSITIVE**");
    String command= input.next();
    String list = "";
    int count = 0;
    while (!(((command.equals("name"))||(command.equals("stage"))||(command.equals("sex")))))
    {
      System.out.println("\nI do not understand... ");
      System.out.print("What do you want to search by? (name, stage, sex) **CASE SENSITIVE** ");
      command= input.next();
    }
    
    String searchFeature = "";
    if(command.equals("name"))
    {
       System.out.println("What is the scientific name of the plant (Make sure you have no misspellings!)");
       String name = input.next();
       searchFeature = name;
       
    }   
    if(command.equals("stage"))
    {
       System.out.println("What is the stage of the plant? (Choose from this list (Make sure you have no misspellings!): Seed, Sprout, Seedling, Vegitative, Adult)");
       String stage = input.next();
       searchFeature = stage;
       
    }
    if(command.equals("sex"))
    {
       System.out.println("What is the sex of the plant? (Choose from this list (Make sure you have no misspellings!): Male, Female, N/A)");
       String sex = input.next();
       searchFeature = sex;
       
    }
    list = searchFeature+" plants found at:";
    for(int i = 0; i<garden.length;i++)
       {
          for(int j = 0; j<garden[i].length; j++)
          {
             if(garden[i][j]!=null&&searchFeature.equals(helpFind(garden[i][j], command)))
             {
                count++;
                list+="\n("+i+","+j+")";
             }
          }
       }
    
    System.out.println(count+" "+list);
  } 
  //edit method
  public static Plant[][] edit(Plant[][] garden)
  {
    Scanner input = new Scanner(System.in);
    int rows = garden.length;
    int cols = garden[0].length;
    System.out.println("\nRows and columns start at 0");
    System.out.print("Which row would you like to edit your plant? (If not in garden, will be set to 0) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("Which row would you like to edit your plant? (If not in garden, will be set to 0) "); //re-prompt user for data
    }
    int row = input.nextInt();
    if(row>=rows||row<0)
    {
      row=0;
    }
    
    System.out.print("\n\nWhich column would you like to edit your plant? (If not in garden, will be set to 1) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("\n\nWhich column would you like to edit your plant? (If not in garden, will be set to 1) "); //re-prompt user for data
    }
    int col = input.nextInt();
    if(col>=cols||col<0)
    {
      col=0;
    }
    System.out.println("You chose position ("+ row +","+col+")");
    for(int i = 0; i<rows; i++)
    {
      for(int j=0;j<cols; j++)
      {
        if(i == row)
        {
          if(j == col)
          {
            if(garden[i][j]!=null)
            {
              String instructions = "";
              if(!(instructions.equalsIgnoreCase("Notes")||instructions.equalsIgnoreCase("Stage")))
              {
              System.out.println("What do you wish to edit? (Notes) (Stage)");
              instructions = input.next();
              while(!(instructions.equalsIgnoreCase("Notes")||instructions.equalsIgnoreCase("Stage")))
              {
                   System.out.println("I do not understand...");
                   System.out.println("What do you wish to edit? (Notes) (Stage)");
                   instructions = input.next();
                   System.out.println();
              }
              }
              if(instructions.equalsIgnoreCase("Notes"))
              {
                System.out.println("Current Notes:\n"+ garden[i][j].getNotes());
                
                String keep = "";
                while(!(keep.equalsIgnoreCase("yes")||keep.equalsIgnoreCase("no")))
                {
                    System.out.println("Do you wish to keep the current notes? (yes/no)");
                    keep = input.next();
                    if(!(keep.equalsIgnoreCase("yes")||keep.equalsIgnoreCase("no")))
                    {
                        System.out.println("I do not understand...");
                        System.out.println("Do you wish to keep the current notes? (yes/no)");
                        keep = input.next();
                        System.out.println();
                    }
                }
                if((keep.equalsIgnoreCase("yes")))
                {
                  System.out.println("What would you wish to add?");
                  input.nextLine();
                  String newNotes = input.nextLine();
                  garden[i][j].setNotes(garden[i][j].getNotes()+"\n"+newNotes);
                }
                else
                {
                  System.out.println("What do you wish the notes to be?");
                  input.nextLine();
                  String newNotes = input.nextLine();
                  garden[i][j].setNotes(newNotes);
                }
               }
               else
               {
                  System.out.println("What is the stage of the plant? (Choose from this list (Make sure you have no misspellings!): Seed, Sprout, Seedling, Vegitative, Adult)");
                  String newStage = input.next();
                  garden[i][j].setStage(newStage);
               }
            }
            else
            {
               System.out.println("There is no plant there");
            }
          }
        }
      } 
    }
    return garden;
  }
  
  //display method
  public static void display(Plant[][] garden)
  {
    Scanner input = new Scanner(System.in);
    int rows = garden.length;
    int cols = garden[0].length;
    System.out.println("\nRows and columns start at 0");
    System.out.print("Which row is your plant? (If not in garden, will be set to 0) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("Which row is your plant? (If not in garden, will be set to 0) "); //re-prompt user for data
    }
    int row = input.nextInt();
    if(row>=rows||row<0)
    {
      row=0;
    }
    
    System.out.print("\n\nWhich column is your plant? (If not in garden, will be set to 1) ");
    while(!input.hasNextInt())
    {
      input.next(); //discard invalid data
      System.out.println("\nPlease try again");
      System.out.print("\n\nWhich column is your plant? (If not in garden, will be set to 1) "); //re-prompt user for data
    }
    int col = input.nextInt();
    if(col>=cols||col<0)
    {
      col=0;
    }
    System.out.println("You chose position ("+ row +","+col+")");
    Plant thePlant = garden[row][col];
    if(thePlant==null)
    {
      System.out.println("There is no plant there");
    }
    else
    {
      System.out.println("\nName:\n " +thePlant.getName());
      System.out.println("\nStage:\n " +thePlant.getStage());
      System.out.println("\nSex:\n " +thePlant.getGender());
      System.out.println("\nNotes:\n" +thePlant.getNotes());
    }
   }
   
   //show method
   public static void show(Plant[][] garden)
   {
      System.out.println("Where there are plants, there is a 1, where there are not plants there is a zero");
      for(int i=0; i<garden.length;i++)
      {
         for(int j=0;j<garden[i].length;j++)
         {
            if(garden[i][j]==null)
            {
               System.out.print("0 ");
            }
            else
            {
               System.out.print("1 ");
            }
         }
         System.out.println();
      }
   }
   
   //this is a helper method for find method
   public static String helpFind(Plant thePlant, String word)
   {
      if(word.equals("name"))
      { 
         return thePlant.getName();
      }
      if(word.equals("sex"))
      { 
         return thePlant.getGender();
      }
         return thePlant.getStage();
   }
}