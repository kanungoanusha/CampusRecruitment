/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campusrecruit;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class appdetail extends JFrame{
 public static void main(String args[]){
  new appdetail(0);
 }


 JTable tab;
 JPanel tpan=new JPanel();
 JPanel bpan=new JPanel();
 String header[]={"Name","Age","Sex","Education","Co-curriculars","Salary"};
 Object data[][]=new String[15][6];
 JButton check=new JButton("TRY");
 int i,j,ki;

 public appdetail(int k){
  this.ki=k;
  setVisible(true);
  setSize(800,600);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  getContentPane().add(tpan,BorderLayout.CENTER);
  getContentPane().add(bpan,BorderLayout.SOUTH);
  bpan.add(check);
  try{
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=go;integratedSecurity=true");
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("select * from Applicant where Field="+ki);
   while(rs.next()){
    for(j=0;j<=5;j++)
     data[i][j]=rs.getString(j+1);
    i++;
   }
  }
  catch(Exception e){
   JOptionPane.showMessageDialog(null,data[1][0]);
   System.exit(0);
  }
  tab=new JTable(data,header);
  tab.setPreferredScrollableViewportSize(new Dimension(600,600));
  JScrollPane sp=new JScrollPane(tab);
  tpan.add(sp);
  pack();
  
 }
} 