// Parked car class represents a car that has parked in a
// metered parking spot
public class ParkedCar
{
   private String make;        // Make of the car
   private String model;       // Model of the car
   private String color;       // Color of the car
   private String license;     // License of the car
   private ParkingMeter meter; // Meter the car is parked at
   private int minutes;        // Number of minutes parked

   // Default constructor sets all fields to null
   public ParkedCar()
   {
      make = "";
      model = "";
      color = "";
      license = "";
      meter = new ParkingMeter();
      minutes = 0;
   }
   
   // Constructor
   // @param mk Make of car as a String
   // @param md Model of car as a String
   // @param c Color of the car as a String
   // @param l License plate of the car as a String
   // @param mt Meter that the car is parked at as a ParkingMeter object
   // @param min Number of minutes the car is parked, as an int
   public ParkedCar(String mk, String md, String c, String l, ParkingMeter mt, int min)
   {
      make = mk;
      model = md;
      color = c;
      license = l;
      meter = mt;
      minutes = min;
   }
   
   // @return Make, model, color, license and number minutes parked of car as a String
   public String getInfo()
   {
      return make + " " + model + " " + color + " " + license + " " + minutes;
   }
   
   // @return Meter the car is parked at as a ParkingMeter object
   public ParkingMeter getMeter()
   {
      return meter;
   }
   
   // @return Minutes car is parked as an int
   public int getMinutes()
   {
      return minutes;
   }
}