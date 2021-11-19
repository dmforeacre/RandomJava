/**
   Daniel Foreacre   
   CPS 230 Prof Lehman
   Programming Challenge 14.5
   Nov 14, 2019
*/

import java.lang.Math;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.effect.*;
import javafx.event.EventHandler;
import javafx.scene.media.*;
import javafx.scene.image.Image;

public class SolarSystem extends Application
{
   public static void main(String args[])
   {
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Scene dimensions
      final int SCENE_WIDTH = 1200;
      final int SCENE_HEIGHT = 700;
      // Left offset for sun
      final int OFFSET = 80;
      
      /** Constants for planets
          Radius based on hundreds of kilometers
          Aphelion based on millions of kilometers
      */
      final double SUN_RADIUS = getRadConv(6963.4);
      final Color SUN_COLOR = Color.YELLOW;
      
      final double MERCURY_RADIUS = getRadConv(24.4);
      final int MERCURY_APHELION = getDistConv(70.0);
      final Color MERCURY_COLOR = Color.TOMATO;
      
      final double VENUS_RADIUS = getRadConv(60.5);
      final int VENUS_APHELION = getDistConv(109.0);
      final Color VENUS_COLOR = Color.LIGHTGOLDENRODYELLOW;
      
      final double EARTH_RADIUS = getRadConv(63.8);
      final int EARTH_APHELION = getDistConv(152.0);
      final Color EARTH_COLOR = Color.BLUE;
      
      final double MARS_RADIUS = getRadConv(34.0);
      final int MARS_APHELION = getDistConv(249.0);
      final Color MARS_COLOR = Color.ORANGERED;
      
      final double JUPITER_RADIUS = getRadConv(714.9);
      final int JUPITER_APHELION = getDistConv(817.0);
      final Color JUPITER_COLOR = Color.PERU;
      
      final double SATURN_RADIUS = getRadConv(602.7);
      final int SATURN_APHELION = getDistConv(1515.0);
      final Color SATURN_COLOR = Color.ORANGE;
      
      final double URANUS_RADIUS = getRadConv(255.6);
      final int URANUS_APHELION = getDistConv(3004.0);
      final Color URANUS_COLOR = Color.LIGHTBLUE;
      
      final double NEPTUNE_RADIUS = getRadConv(247.6);
      final int NEPTUNE_APHELION = getDistConv(4546.0);
      final Color NEPTUNE_COLOR = Color.DARKBLUE;
      
      final double PLUTO_RADIUS = getRadConv(11.9);
      final int PLUTO_APHELION = getDistConv(7376.0);
      final Color PLUTO_COLOR = Color.DARKORANGE;
      
      // Create Media object for background music
      AudioClip bgMusic = new AudioClip("file:magistar.mp3");
      
      // Create Image object for background image
      Image bgImage = new Image("file:starry_background.jpg");
      
      // Create new Planet object for each planet
      Planet sun = new Planet("Sun", SUN_RADIUS, SUN_COLOR, OFFSET, (SCENE_HEIGHT / 2));
      Planet mercury = new Planet("Mercury", MERCURY_RADIUS, MERCURY_COLOR, MERCURY_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet venus = new Planet("Venus", VENUS_RADIUS, VENUS_COLOR, VENUS_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet earth = new Planet("Earth", EARTH_RADIUS, EARTH_COLOR, EARTH_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet mars = new Planet("Mars", MARS_RADIUS, MARS_COLOR, MARS_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet jupiter = new Planet("Jupiter", JUPITER_RADIUS, JUPITER_COLOR, JUPITER_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet saturn = new Planet("Saturn", SATURN_RADIUS, SATURN_COLOR, SATURN_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet uranus = new Planet("Uranus", URANUS_RADIUS, URANUS_COLOR, URANUS_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet neptune = new Planet("Neptune", NEPTUNE_RADIUS, NEPTUNE_COLOR, NEPTUNE_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      Planet pluto = new Planet("Pluto", PLUTO_RADIUS, PLUTO_COLOR, PLUTO_APHELION + OFFSET, (SCENE_HEIGHT / 2));
      
      // Create rings for Saturn
      Arc satRingRear = new Arc(SATURN_APHELION + OFFSET, (SCENE_HEIGHT / 2), 40, 10, 0, 180);
      satRingRear.setFill(Color.ORANGE);
      InnerShadow ringShadow = new InnerShadow(30, 0, 0, Color.web("#2A2E5E"));
      satRingRear.setEffect(ringShadow);
      Arc satRingFront = new Arc(SATURN_APHELION + OFFSET, (SCENE_HEIGHT / 2), 40, 10, 180, 180);
      satRingFront.setFill(Color.ORANGE);
      satRingFront.setEffect(ringShadow);
      
      // Create attribution text for music and background
      Text attribution = new Text(10, 15, "\"Magistar\" Kevin MacLeod (incompetech.com)\n" +
                                  "Licensed under Creative Commons: By Attribution 4.0 License\n" +
                                  "http://creativecommons.org/licenses/by/4.0/\n" +
                                  "Background Photo by Kai Pilger on Unsplash");
      attribution.setStroke(Color.DARKGRAY);
      attribution.setStyle("-fx-font-size: 8;");
      
      // Add all Circle and Text objects to pane
      Pane pane = new Pane(attribution,
                           sun.disk, sun.label,
                           mercury.disk, mercury.label,
                           venus.disk, venus.label,
                           earth.disk, earth.label,
                           mars.disk, mars.label,
                           jupiter.disk, jupiter.label,
                           satRingRear, saturn.disk, satRingFront, saturn.label,
                           uranus.disk, uranus.label,
                           neptune.disk, neptune.label,
                           pluto.disk, pluto.label);
                           
      // Set background color of pane
      pane.setBackground(new Background(new BackgroundImage(bgImage, null, null, null, null)));
      
      // Create scene and display
      Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
      primaryStage.setTitle("The Solar System");
      primaryStage.setScene(scene);
      primaryStage.show();
      
      // Play background music
      bgMusic.play();
   }
   
   // Calculates the square root of x and multiplies by .9 to generate a radius in pixels
   // @param x Double containing the radius
   // @return Int containing transformed radius
   public static int getRadConv(double x)
   {
      return (int)(Math.sqrt(x) * .9);
   }
   
   // Calculates the natural logarithm of x then cubes it and multiplies that by 1.5 to generate a distance in pixels
   // @param x Double containing the distance from sun
   // @return Int containing transformed distance
   public static int getDistConv(double x)
   {
      return (int)(Math.log(x) * Math.log(x) * Math.log(x) * 1.5);
   }
   
   // Class to represent a planet object
   public class Planet
   {
      private String name;     // Name of the planet
      private double radius;   // Radius of the planet (in thousands of kilometers)
      private Color color;     // Color of the planet
      private int xPos;        // X coordinate of the displayed circle
      private int yPos;        // Y coordinate of the displayed circle
      Circle disk;             // Circle object to draw on screen      
      Text label;              // Text object to draw on screen with planet's name
      
      // Constructor
      public Planet(String n, double r, Color c, int x, int y)
      {
         name = n;
         radius = r;
         color = c;
         xPos = x;
         yPos = y;
         
         // Create Circle object with x and y position parameters
         disk = new Circle(xPos, yPos, radius, color);
         // Set inner shadow for Circle object
         InnerShadow innerShadow = new InnerShadow(.9 * radius, 0, 0, Color.web("#2A2E5E"));
         disk.setEffect(innerShadow);
         // Create Text object with position centered at the middle of the circle and the radius plus 15 pixels below the circle
         // Finds center of text string by returning length of string, dividing in half, and multiplying by 6 pixels per letter.
         label = new Text(xPos - ((n.length() / 2) * 6), yPos + radius + 15, n);
         // Set text color to white and create drop shadow
         label.setStroke(Color.WHITE);
         DropShadow dropShadow = new DropShadow();
         label.setEffect(dropShadow);
      }
   }
}