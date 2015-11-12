/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class FConector {

    private Connection conn;

    public FConector() {
        this.getConection();
    }
    
    private void getConection(){
    
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cine","root","");
            System.out.println("work c");
        } catch (SQLException ex) {
            System.out.println("d work c");
            Logger.getLogger(FConector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Statement getStatement(){
        
        try {
            System.out.println("work S");
            Statement s = conn.createStatement();
            System.out.println("work S1");
            return s;
        } catch (SQLException ex) {
            System.out.println("d work s");
            Logger.getLogger(FConector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
