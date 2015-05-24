/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nard
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nard
 */
import java.sql.*;
 import java.util.*;
import javax.swing.JOptionPane;
public class Password1 {
        Scanner scan = new Scanner(System.in);
        public Password1()
        {
                    String sworkoutObject = JOptionPane.showInputDialog(null, "Did you forget your password? Y/N ","Incorrect login", JOptionPane.QUESTION_MESSAGE);
                    //String enter = String.parseString(sworkoutObject);
                   
                    System.out.print(sworkoutObject);
                            if(sworkoutObject.equals("Y"))
                            {
                                
                                String sworkoutObject2 = JOptionPane.showInputDialog(null, "Enter Your username: ","Incorrect login", JOptionPane.QUESTION_MESSAGE);
                                String uname=sworkoutObject2;
                                
                                String sworkoutObject3 = JOptionPane.showInputDialog(null, "Enter Your firstname: ","Incorrect login", JOptionPane.QUESTION_MESSAGE);
                                String fname=sworkoutObject3;
                                
                                String sworkoutObject4 = JOptionPane.showInputDialog(null, "Enter Your age ","Incorrect login", JOptionPane.QUESTION_MESSAGE);
                                int age=Integer.parseInt(sworkoutObject4);
                                
                                
                                
                                
                                try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/healthtrack","root","root");
                                    Statement stmt=(Statement)con.createStatement();
                                    
                                    try
                                    {
                                        ResultSet rs = stmt.executeQuery("Select `pass` From healthtrack.info Where info.uname='"+uname+"'");
                                        if (!rs.isBeforeFirst() ) { 
                                         String output = "Could not find user in database";
                                        JOptionPane.showMessageDialog(null, output, "Error", JOptionPane.INFORMATION_MESSAGE, null);
                                        Final b = new Final();
                                        b.setVisible(true);
                                        
                                       } 
                                        else
                                        {
                                                while (rs.next()) {
                                                 String pass1 = rs.getString("pass");
                                                 String output = "Your Password is: " +pass1;
                                                 JOptionPane.showMessageDialog(null, output, "Incorrect login", JOptionPane.INFORMATION_MESSAGE, null);

                                                 

                                                }
                                                Final a = new Final();
                                                a.setVisible(true);
                                                
                                        }
                                    }
                                    catch (Exception e) {
                                    e.printStackTrace();
                                } finally {
                                    try {
                                        if (stmt != null) {
                                            stmt.close();
                                        }
                                    } catch (SQLException se) {
                                    }
                                    if (con != null) {
                                        con.close();
                                    }
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
                                
                                
                            }
                            else
                            {
                                
                                Final c = new Final();
                                c.setVisible(true);
        
                            }
                                
                                
                            
            
        }
    
}

