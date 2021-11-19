/**
   Daniel Foreacre
   Prof Lehman CPS 230
   Programming Challenge 13.3
   October 30, 2019
*/

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Registration extends Application
{
   // Constants for price calculations
   final private int GENERAL_REGISTRATION = 895;
   final private int STUDENT_REGISTRATION = 495;
   final private int DINNER = 30;
   final private int WORKSHOP_ECOMMERCE = 295;
   final private int WORKSHOP_FUTUREWEB = 295;
   final private int WORKSHOP_ADVANCEDJAVA = 395;
   final private int WORKSHOP_NETWORKSECURITY = 395;
   
   // Invoice total initialized to default General Registration
   int total = GENERAL_REGISTRATION;
      
   // Label for invoice total
   Label totalLabel = new Label(String.format("$ %6d.00", total));
   
   // Main method
   public static void main(String args[])
   {
      // Launch application
      launch(args);
   }
   
   // Start method for javafx
   public void start(Stage primaryStage)
   {
      // Create radio buttons for registration types
      RadioButton generalButton = new RadioButton("General Registration");
      RadioButton studentButton = new RadioButton("Student Registration");
      
      // Default selection to General Registration
      generalButton.setSelected(true);
      
      // Create check boxes for dinner and workshops
      CheckBox dinnerBox = new CheckBox("Dinner and Keynote Speech");
      CheckBox ecommerceBox = new CheckBox("Introduction to E-commerce");
      CheckBox futurewebBox = new CheckBox("The Future of the Web");
      CheckBox advancedjavaBox = new CheckBox("Advanced Java Programming");
      CheckBox networksecurityBox = new CheckBox("Network Security");
      
      // Create separators
      Separator separator1 = new Separator();
      Separator separator2 = new Separator();
      Separator separator3 = new Separator();
      
      // Create events for radio buttons
      generalButton.setOnAction(event ->
      {
         total += GENERAL_REGISTRATION;
         total -= STUDENT_REGISTRATION;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      studentButton.setOnAction(event ->
      {
         total += STUDENT_REGISTRATION;
         total -= GENERAL_REGISTRATION;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      // Create events for check boxes
      dinnerBox.setOnAction(event ->
      {
         if(dinnerBox.isSelected())
            total += DINNER;
         else
            total -= DINNER;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      ecommerceBox.setOnAction(event ->
      {
         if(ecommerceBox.isSelected())
            total += WORKSHOP_ECOMMERCE;
         else
            total -= WORKSHOP_ECOMMERCE;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      futurewebBox.setOnAction(event ->
      {
         if(futurewebBox.isSelected())
            total += WORKSHOP_FUTUREWEB;
         else
            total -= WORKSHOP_FUTUREWEB;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      advancedjavaBox.setOnAction(event ->
      {
         if(advancedjavaBox.isSelected())
            total += WORKSHOP_ADVANCEDJAVA;
         else
            total -= WORKSHOP_ADVANCEDJAVA;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
      
      networksecurityBox.setOnAction(event ->
      {
         if(networksecurityBox.isSelected())
            total += WORKSHOP_NETWORKSECURITY;
         else
            total -= WORKSHOP_NETWORKSECURITY;
         totalLabel.setText(String.format("$ %6d.00", total));
      });
       
      // Group registration buttons into ToggleGroup
      ToggleGroup typeGroup = new ToggleGroup();
      generalButton.setToggleGroup(typeGroup);
      studentButton.setToggleGroup(typeGroup);
      
      // Create labels for prices
      Label generalPrice = new Label(String.format("$ %6d.00", GENERAL_REGISTRATION));
      Label studentPrice = new Label(String.format("$ %6d.00", STUDENT_REGISTRATION));
      Label dinnerPrice = new Label(String.format("$ %6d.00", DINNER));
      Label ecommercePrice = new Label(String.format("$ %6d.00", WORKSHOP_ECOMMERCE));
      Label futurewebPrice = new Label(String.format("$ %6d.00", WORKSHOP_FUTUREWEB));
      Label advancedjavaPrice = new Label(String.format("$ %6d.00", WORKSHOP_ADVANCEDJAVA));
      Label networksecurityPrice = new Label(String.format("$ %6d.00", WORKSHOP_NETWORKSECURITY));
      
      // Create text label for total and set alignment
      Label totalText = new Label("Total: ");
      totalText.setAlignment(Pos.CENTER_RIGHT);
      
      // Create grid and set padding
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(15));
      grid.setHgap(40);
      grid.setVgap(10);
      
      // Add elements to grid
      grid.add(generalButton, 0, 0);
      grid.add(generalPrice, 1, 0);
      grid.add(studentButton, 0, 1);
      grid.add(studentPrice, 1, 1);
      grid.add(separator1, 0, 2);
      grid.add(dinnerBox, 0, 3);
      grid.add(dinnerPrice, 1, 3);
      grid.add(separator2, 0, 4);
      grid.add(ecommerceBox, 0, 5);
      grid.add(ecommercePrice, 1, 5);
      grid.add(futurewebBox, 0, 6);
      grid.add(futurewebPrice, 1, 6);
      grid.add(advancedjavaBox, 0, 7);
      grid.add(advancedjavaPrice, 1, 7);
      grid.add(networksecurityBox, 0, 8);
      grid.add(networksecurityPrice, 1, 8);
      grid.add(separator3, 0, 9);
      grid.add(totalText, 0, 10);
      grid.add(totalLabel, 1, 10);
      
      // Create scene
      Scene scene = new Scene(grid);
      
      // Add style sheet to scene
      scene.getStylesheets().add("Registration.css");
      
      // Set stage and show
      primaryStage.setScene(scene);
      primaryStage.setTitle("Conference Fees");
      primaryStage.show();
   }
}