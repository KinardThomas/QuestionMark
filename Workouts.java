/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Nard
 */
public class Workouts {
    double height,weight,sworkout,MET,weightinkg,newnum,newcal,caneat;
    public Workouts(){
        run();
    }
    
    private void run(){
        //Array for available workouts with Caloric expenditure
      Object[] workouts = new Object[14];
      int i = 0;
      for(double work = 0; work <=14; work++)
      {
         //workouts[i++] = new Double(work);
         workouts[0] = "Cardio (light walking 2-3.5 MPH)";
         workouts[1] = "Cardio (Brisk walking 3.5-4.5 MPH)";
         workouts[2] = "Cardio (Light jogging 4.5-5.0 MPH)";
         workouts[3] = "Cardio (Medium jogging 5.0-6.0 MPH)";
         workouts[4] = "Cardio (Sprinting 6.0+ MPH)";
         workouts[5]= "Weight Lifting (Low weight, High Reps)";
         workouts[6] = "Weight Lifting (High weight, Low Reps)";
         workouts[7] = "Weight Lifting (High weight, High Reps)";
         workouts[8] = "Weight Lifting (High weight, High Reps) + Light Cardio";
         workouts[9] = "Weight Lifting (High weight, High Reps) + Medium Cardio";
         workouts[10] = "Weight Lifting (High weight, High Reps) + Intense Cardio";
         workouts[11] = "Aerobics";
         workouts[12] = "Swimming";
         workouts[13] = "Sports(Basketball,Football,Soccer,etc)";
      }
      
                            try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/healthtrack","root","root");
                                    Statement stmt=(Statement)con.createStatement();
                                    
                                     ResultSet rs = stmt.executeQuery("Select `Height`, `Weight` From healthtrack.info Where info.uname='"+Final.uname+"'");
                                      while (rs.next()) {
                                     height= rs.getInt("Height");
                                      weight=rs.getInt("Weight");
                                      }
                                      stmt.close();
                                     con.close();
                                }
                            catch(SQLException se)
                                {
                                  //Handle errors for JDBC
                                  se.printStackTrace();
                                }
                                catch(Exception e){
                                     //Handle errors for Class.forName
                                     e.printStackTrace();
                                  }
      
      //Prompt user to enter a workout
                            weightinkg=weight/2.2;
                           
      Object sworkoutObject = JOptionPane.showInputDialog(null, "Select Workout: ","Workout", JOptionPane.QUESTION_MESSAGE, null, workouts, null);
      if (sworkoutObject.equals("Cardio (light walking 2-3.5 MPH)"))
              {
                  MET = 2.9;
              }
      if (sworkoutObject.equals("Cardio (Brisk walking 3.5-4.5 MPH)"))
              {
                MET = 4.0;
              }
      if (sworkoutObject.equals("Cardio (Light jogging 4.5-5.0 MPH)"))
              {
                  MET = 5.3;
              }
      if (sworkoutObject.equals("Cardio (Medium jogging 5.0-6.0 MPH)"))
              {
                MET = 7.0;
              }
      if (sworkoutObject.equals("Cardio (Sprinting 6.0+ MPH)"))
              {
                MET = 8.6;
              }
      if (sworkoutObject.equals("Weight Lifting (Low weight, High Reps)"))
              {
                MET = 4.5;
              }
      if (sworkoutObject.equals("Weight Lifting (High weight, Low Reps)"))
              {
                MET = 5.5;
              }
      if (sworkoutObject.equals("Weight Lifting (High weight, High Reps)"))
              {
                MET = 6.5;
              }
      if (sworkoutObject.equals("Weight Lifting (High weight, High Reps) + Light Cardio"))
              {
                MET = 11.8;
              }
      if (sworkoutObject.equals("Weight Lifting (High weight, High Reps) + Medium Cardio"))
              {
                MET = 13.5;
              }
      if (sworkoutObject.equals("Weight Lifting (High weight, High Reps) + Intense Cardio"))
              {
                MET = 15.1;
              }
      if (sworkoutObject.equals("Aerobics"))
              {
                MET = 6.0;
              }
      if (sworkoutObject.equals("Swimming"))
              {
                MET = 6.0;
              }
      if (sworkoutObject.equals("Sports(Basketball,Football,Soccer,etc)"))
              {
                MET = 18.2;
              }
      
      
      
      //Array for time used
      Object[] timeRange = {new Integer(5),new Integer(10),new Integer(15),new Integer(20),new Integer(30), new Integer(45), new Integer(60), new Integer(90), new Integer(120)};
      
      //Prompt user to enter time
      Object timeObject = JOptionPane.showInputDialog(null,"Select time of Workout: ", "Workout", JOptionPane.QUESTION_MESSAGE, null, timeRange, null);
      int numoftime = ((Integer)timeObject).intValue();
      if(numoftime==5)
      {
            newnum=5.0/60.0;
      }
      if(numoftime==10)
      {
            newnum=10.0/60.0;
      }
      if(numoftime==15)
      {
            newnum=15.0/60.0;
      }
      if(numoftime==20)
      {
            newnum=20.0/60.0;
      }
      if(numoftime==30)
      {
            newnum=30.0/60.0;
      }
      if(numoftime==45)
      {
            newnum=45.0/60.0;
      }
      if(numoftime==60)
      {
            newnum=60.0/60.0;
      }
      if(numoftime==90)
      {
            newnum=90.0/60.0;
      }
      if(numoftime==120)
      {
            newnum=120.0/60.0;
      }
      
      
      //Obtain total Calories burned from workout
      double totalBurned = (MET *weightinkg) * newnum;
      
      String total = String.format("%.2f", totalBurned);
      
      //Display
      String output = "Workout chosen: " + sworkoutObject + " " + "\nMinutes Performed: " + numoftime + "\nBMI: " + Final.bmi5;
      output += "\n Total Amount Of Calories burned: " +total;
      
      JOptionPane.showMessageDialog(null, output, "Welcome", JOptionPane.INFORMATION_MESSAGE, null);
      
      
      
      try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/healthtrack","root","root");
                        Statement stmt=(Statement)con.createStatement();
                        
                        ResultSet rs = stmt.executeQuery("Select `CAL`,`EATEN`,`BMR` From healthtrack.info Where info.uname='"+Final.uname+"'");
                        while (rs.next()) {
                            double cal = rs.getDouble("CAL");
                            double eaten= rs.getDouble("EATEN");
                            double bmr=rs.getDouble("BMR");
                              newcal=cal+Double.parseDouble(total);
                              caneat=cal+totalBurned;
                        }
                        String insert="UPDATE `healthtrack`.`info` SET `CAL`='"+newcal+"' WHERE `uname`='"+Final.uname+"';";
                         
                            stmt.executeUpdate(insert);
                        
                       
                        stmt.close();
                        con.close();
                    }
                    catch(SQLException se)
                    {
                      //Handle errors for JDBC
                      se.printStackTrace();
                    }
                    catch(Exception e){
                         //Handle errors for Class.forName
                         e.printStackTrace();
                      }
      String total1 = String.format("%.2f", caneat);
      String output2 = "Congratulations! with your new workout you can now eat " +total1+ " Calories today!";
      JOptionPane.showMessageDialog(null, output2, "Good Job!", JOptionPane.INFORMATION_MESSAGE, null);
    }
}

      

