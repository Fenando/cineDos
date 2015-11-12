/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.FPeliculaDAL;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class FPeliculaBLL {
    
    private String codigo;
    private String nombre;
    private String categoria;
    private int diasPrestamo;
    private String formato;
    private Timestamp fechaIngreso;

    public FPeliculaBLL() {
    }

    public FPeliculaBLL(String codigo, String nombre, String categoria, int diasPrestamo, String formato, Timestamp fechaIngreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.diasPrestamo = diasPrestamo;
        this.formato = formato;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    /**
     * CRUD--Desde Capa DAL
     */
    public String createB(FPeliculaBLL pe){
        System.out.println("workBLL");
        int r = new FPeliculaDAL().create(pe);
        return r==1?"Guardado sin problemas":r==2?"Error al guardar":r==3?"codigo duplicado":"";
    }
    public String updateB(FPeliculaBLL pe){
        int r = new FPeliculaDAL().update(pe);
        return r==1?"Modificado sin problemas":r==2?"Error al modificar":r==3?"codigo duplicado":"";
    }
    public String deleteB(String c){
        int r = new FPeliculaDAL().delete(c);
        return r==1?"Borrado sin problemas":r==2?"Error al borrar":"";
    }
    public ArrayList<FPeliculaBLL> readEstrenoB(){
        return new FPeliculaDAL().readEstreno();
    }
    public ArrayList<FPeliculaBLL> readPorDateB(String d){
        return new FPeliculaDAL().readPorDate(d);
    }
    public ArrayList<FPeliculaBLL> readTablaUnoB(){
        return new FPeliculaDAL().readTablaUno();
    }
    public ArrayList<FPeliculaBLL> readTablaDosB(){
        return new FPeliculaDAL().readTablaDos();
    }
    
}
