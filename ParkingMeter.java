// Class to represent a parking meter
public class ParkingMeter
{
   private int minutes;  // Number of minutes put on the meter
   
   // Default constructor sets minutes to 0
   public ParkingMeter()
   {
      minutes = 0;
   }
   
   // Constructor
   // @param m Minutes put on the meter as an int
   public ParkingMeter(int m)
   {
      minutes = m;
   }
   
   // @return Number of minutes paid for
   public int getMinutes()
   {
      return minutes;
   }
}