// Class to represent a police officer on the traffic beat
public class PoliceOfficer
{
   private String name;  // The officer's name
   private int badge;    // The officer's badge number
   
   // Default constructor sets name and badge to null
   public PoliceOfficer()
   {
      name = "";
      badge = 0;
   }
   
   // Constructor
   // @param n Name to assign to officer as a String
   // @param b Badge number to assign to officer as an int
   public PoliceOfficer(String n, int b)
   {
      name = n;
      badge = b;
   }
   
   // @return String containing officer name and badge number
   public String getInfo()
   {
      return name + " " + badge;
   }
   
   // Method to check a car to see if its time has expired and write a ticket if it has
   // @param car Car to check as a ParkedCar object
   // @return ParkingTicket object if the meter is expired, null otherwise
   public ParkingTicket checkCar(ParkedCar car)
   {
      ParkingTicket ticket = null;  // Initialize parking ticket to null
      
      // Calculate the time difference between the car and meter it is parked at
      int diff = car.getMinutes() - car.getMeter().getMinutes();
      // If difference is greater than zero, issue a ticket
      if (diff > 0)
         ticket = new ParkingTicket(car, this, (diff * 5) + 100);  // Fine is $5 for each minute over plus $100 base
      
      return ticket;
   }
}