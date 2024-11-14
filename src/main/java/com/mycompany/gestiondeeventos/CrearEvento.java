package com.mycompany.GestionDeEventos;
import javax.swing.JOptionPane;

public class CrearEvento {
    String nombre;
    String fecha;
    String tipo;
    public CrearEvento(String nombre,String fecha,String tipo){
     this.nombre=nombre;
     this.fecha=fecha;
     this.tipo=tipo;
    }
   public String getNombre(){
       return nombre;
   } 
   public String getFecha(){
       return fecha;
   }
   public String busquedaTipo(){
       return this.nombre+this.fecha;
   }
     // Método para crear un nuevo evento
    public void crearEvento() {
        // Solicitar al usuario que ingrese los datos del nuevo evento
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del evento:");
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha del evento (dd/mm/aaaa):");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de evento:");

        CrearEvento nuevoEvento = new CrearEvento(nombre, fecha, tipo);
    }
}

