/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.FPeliculaBLL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class FPeliculaDAL {

    public FPeliculaDAL() {
    }
    
        /**
         * CRUD
         */ 
    public int create(FPeliculaBLL pe){
        System.out.println("workDAL1");
        Statement sta = new FConector().getStatement();
        System.out.println("??");
        StringBuilder sb = new StringBuilder(
                "insert into pelicula (codigo,nombre,categoria,dias_prestamo,"
                        + "formato,fecha_ingreso) values ( '");
        sb.append(pe.getCodigo()).append("','").
                append(pe.getNombre()).append("','").
                append(pe.getCategoria()).append("',").
                append(pe.getDiasPrestamo()).append(",'").
                append(pe.getFormato()).append("','").
                append(pe.getFechaIngreso()).append("')");
        System.out.println(sb.toString());
        try {
            sta.executeUpdate(sb.toString());
            System.out.println("workDAL2");
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1062) {
                return 3;
            }else{
                return 2;
            }
        }finally{
            try {
                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public int update(FPeliculaBLL pe){
        
        Statement sta = new FConector().getStatement();
        StringBuilder sb = new StringBuilder(
                "update pelicula set nombre = '");
        sb.append(pe.getNombre()).append("', categoria = '").
                append(pe.getCategoria()).append("', dias_prestamo = ").
                append(pe.getDiasPrestamo()).append(", formato = '").
                append(pe.getFormato()).append("', fecha_ingreso = '").
                append(pe.getFechaIngreso()).append("' where codigo = '").
                append(pe.getCodigo()).append("'");
        
        try {
            sta.executeUpdate(sb.toString());
            return 1;
         } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 1) {
                return 3;
            }else{
                return 2;
            }
        }finally{
            try {
                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public int delete(String code){
        Statement sta = new FConector().getStatement();
        try {
            sta.executeUpdate("delete pelicula where codigo = '"+code+"'");
            return 1;
            }catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
               return 2;
            }finally{
            try {
                sta.close();
            } catch (SQLException ex) {
                Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList<FPeliculaBLL> readEstreno(){
        
        ArrayList<FPeliculaBLL> pe = new ArrayList<>();
        Statement sta = new FConector().getStatement();
        try {
            ResultSet rSet = sta.executeQuery("select * from pelicula "
                    + "where categoria = 'estreno'");
            while (rSet.next()) {
               FPeliculaBLL p1 = new FPeliculaBLL(rSet.getString("codigo"), 
                       rSet.getString("nombre"), 
                       rSet.getString("categoria"), 
                       rSet.getInt("dias_prestamo"),
                       rSet.getString("formato"), 
                       rSet.getTimestamp("fecha_ingreso"));
               pe.add(p1);
            }
            sta.close();
            return pe;
        } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<FPeliculaBLL> readPorDate(String date){
        
        ArrayList<FPeliculaBLL> pe = new ArrayList<>();
        Statement sta = new FConector().getStatement();
        try {
            String query = "select * from pelicula "
                    + "where fecha_ingreso like '"+date+"%'";
            System.out.println(query);
            ResultSet rSet = sta.executeQuery(query);
            
            while (rSet.next()) {
               FPeliculaBLL p1 = new FPeliculaBLL(rSet.getString("codigo"), 
                       rSet.getString("nombre"), 
                       rSet.getString("categoria"), 
                       rSet.getInt("dias_prestamo"),
                       rSet.getString("formato"), 
                       rSet.getTimestamp("fecha_ingreso"));
               pe.add(p1);
            }
            sta.close();
            return pe;
            
        } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<FPeliculaBLL> readTablaUno(){
        
        ArrayList<FPeliculaBLL> pe = new ArrayList<>();
        Statement sta = new FConector().getStatement();
        try {
            ResultSet rSet = sta.executeQuery("select * from pelicula ");
            while (rSet.next()) {
               FPeliculaBLL p1 = new FPeliculaBLL();
                p1.setCodigo(rSet.getString("codigo")); 
                //p1.setNombre(rSet.getString("nombre")); 
                p1.setCategoria(rSet.getString("categoria")); 
                //p1.setDiasPrestamo(rSet.getInt("dias_prestamo"));
                //p1.setFormato(rSet.getString("formato")); 
                //p1.setFechaIngreso(rSet.getTimestamp("fecha_ingreso"));
               pe.add(p1);
            }
            sta.close();
            return pe;
        } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<FPeliculaBLL> readTablaDos(){
        
        ArrayList<FPeliculaBLL> pe = new ArrayList<>();
        Statement sta = new FConector().getStatement();
        try {
            ResultSet rSet = sta.executeQuery("select * from pelicula ");
            while (rSet.next()) {
               FPeliculaBLL p1 = new FPeliculaBLL();
                //p1.setCodigo(rSet.getString("codigo")); 
                p1.setNombre(rSet.getString("nombre")); 
                //p1.setCategoria(rSet.getString("categoria")); 
                p1.setDiasPrestamo(rSet.getInt("dias_prestamo"));
                //p1.setFormato(rSet.getString("formato")); 
                p1.setFechaIngreso(rSet.getTimestamp("fecha_ingreso"));
               pe.add(p1);
            }
            sta.close();
            return pe;
        } catch (SQLException ex) {
            Logger.getLogger(FPeliculaDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
