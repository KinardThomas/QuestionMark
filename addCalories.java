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
public class addCalories {
    static double eaten,left,daily,totalConsumed,newleft;
    public addCalories(){
        run();
    }
    
    private void run(){
        //Array for available workouts with Caloric expenditure
      Object[] cal = new Object[1];
      /*int i = 0;
      for(double work = 0; work <=1; work++)
      {
         cal[i++] = new Double(work);
         cal[0] = calor;
      }*/
      
      
      //Prompt user to enter calorie information
      String sworkoutObject = JOptionPane.showInputDialog(null, "Enter Calories Consumed: ","Calories", JOptionPane.QUESTION_MESSAGE);
      Double calnum = Double.parseDouble(sworkoutObject);
    
      //Obtain total Calories burned from workout
      
      
                            try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/healthtrack","root","root");
                                    Statement stmt=(Statement)con.createStatement();
                                    
                                    
                                        ResultSet rs = stmt.executeQuery("Select `BMR`, `CAL`, `EATEN` From healthtrack.info Where info.uname='"+Final.uname+"'");
                                            while (rs.next()) {
                                                   eaten = rs.getDouble("EATEN");
                                                  left = rs.getDouble("CAL");
                                                  daily = rs.getDouble("BMR");

                                                 

                                                }
                                             totalConsumed = eaten +calnum;
                                             newleft= daily - totalConsumed;
                                             
                                             
                                        
                                       
                                            String insert="UPDATE `healthtrack`.`info` SET `CAL`='"+newleft+"', `EATEN`='"+totalConsumed+"' WHERE `uname`='"+Final.uname+"';";
                        
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
                                
                                
                            
      double consum=eaten+calnum;
      //Display
      String output = "Calories alotted per day: " +daily+"\nCalories Consumed this meal : " + calnum + " " + "\nTotal calories consumed today: " + consum + "\nTotal Remaining: " + newleft;
      
      JOptionPane.showMessageDialog(null, output, "Welcome", JOptionPane.INFORMATION_MESSAGE, null);
    }
}

      

