// Class to represent a parking ticket
public class ParkingTicket
{
   private ParkedCar car;         // Car that is being ticketed
   private PoliceOfficer officer; // Officer issuing the ticket
   private double fine;           // Fine issued
   
   // Default constructor sets all fields to null
   public ParkingTicket()
   {
      car = new ParkedCar();
      officer = new PoliceOfficer();
      fine = 0.0;
   }
   
   // Constructor
   // @param c Car that the ticket is given to, as a ParkedCar object
   // @param o Officer assigning the ticket as a PoliceOfficer object
   // @param f Fine given to the car as a double
   public ParkingTicket(ParkedCar c, PoliceOfficer o, double f)
   {
      car = c;
      officer = o;
      fine = f;
   }
   
   // Gets car info
   // @return String containing make, model, color and license of car
   public String getCarInfo()
   {
     return car.getInfo();
   }
   
   // @return Fine as a double
   public double getFine()
   {
      return fine;
   }
   
   // @return Badge of ticketing officer as a String containing the name and badge number
   public String getBadge()
   {
      return officer.getInfo();
   }
}