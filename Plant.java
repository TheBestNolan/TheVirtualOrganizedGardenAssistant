//************************************************
//Nolan Richardson
//2/08/2025
//This code makes a plant class
//************************************************
public class Plant
{
   private String name;
   private String stage;
   private String gender;
   private String notes;
   
   public Plant(String plantName, String plantStage, String plantGender)
   {
      name = plantName;
      stage = plantStage;
      gender = plantGender;
      notes = null;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getNotes()
   {
      if (notes == null)
      {
         return "";
      }
      return notes;
   }
   
   public String getStage()
   {
      return stage;
   }
   
   public String getGender()
   {
      return gender;
   }
   
   public void setStage(String plantStage)
   {
      stage = plantStage;
   }
   
   public void setNotes(String plantNotes)
   {
      notes = plantNotes;
   }
 
}
   
   
