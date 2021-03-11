/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class db {

   
    public static void main(String[] args) {
        try{
        //connection avec database
            String host="jdbc:derby://localhost:1527/db";
            String uName ="zmb";
            String uPass="zmb";
            Connection con = DriverManager.getConnection(host, uName, uPass);
        //connection avec le table document    
            Statement stmt =con.createStatement();
            String SQL = "SLECT * FROM Admin";// mettre tout les information de cette tableau sur SQL
            ResultSet rs = stmt.executeQuery(SQL);//mettre tout les information de SQL sur rs (short mémoire)
            
            rs.next();//pointer sur le premier ligne just ca le dernier 
            long id = rs.getInt("ID");//mettre les info de ID dans id
            String user = rs.getString("username");//mettre les info de nom_document dans nom_doc
            String motpasse = rs.getString("password");//mettre les info de chemp_document dans chemp_doc
            
            
            System.out.println( id+""+user+""+motpasse);
            
        }
        catch( SQLException e){
                         System.out.println(e.getMessage());
                               } 
        
    }
    
}
