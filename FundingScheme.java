/* Daniel Foreacre
   CPS 230
   Prof Lehman
   Chp 8 Lab
*/

// Test program for parking classes
public class FundingScheme
{
   public static void main(String args[])
   {
      ParkingMeter meter1 = new ParkingMeter(15);  // Create first meter with 15 minutes on it
      ParkingMeter meter2 = new ParkingMeter(30);  // Create second meter with 30 minutes on it
      
      // Create first car, put it at meter 1 for 30 minutes
      ParkedCar car1 = new ParkedCar("Hyundai", "Sonata", "Blue", "B4H4MUT", meter1, 30);
      System.out.println("Car 1: " + car1.getInfo());
      
      // Create second car, put it at meter 2 for 20 minutes
      ParkedCar car2 = new ParkedCar("Ford", "F150", "Red", "X34KN2", meter2, 20);
      System.out.println("Car 2: " + car2.getInfo());
      
      // Create police officers for meter check
      PoliceOfficer officer = new PoliceOfficer("Foreacre", 12345);
      System.out.println("Officer on duty: " + officer.getInfo());
      
      PoliceOfficer officer2 = new PoliceOfficer("Graybill", 54321);
      System.out.println("Officer on duty: " + officer2.getInfo());
      
      // Check car1
      ParkingTicket ticket1 = officer.checkCar(car1);
      if (ticket1 != null)
         System.out.println("Ticket - " + ticket1.getCarInfo() + ": $" + ticket1.getFine() + " issued by " + ticket1.getBadge());
      
      // Check car2   
      ParkingTicket ticket2 = officer.checkCar(car2);
      if (ticket2 != null)
         System.out.println("Ticket - " + ticket2.getCarInfo() + ": $" + ticket2.getFine() + " issued by " + ticket2.getBadge());
      
      // Check car1 again by officer2   
      ParkingTicket ticket3 = officer2.checkCar(car1);
      if (ticket3 != null)
         System.out.println("Ticket - " + ticket3.getCarInfo() + ": $" + ticket3.getFine() + " issued by " + ticket3.getBadge());

   }
}