package com.mycompany.gestiondeeventos;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GestionDeEventos {

    public static class Evento {

        String nombre;
        String fecha;
        String tipo;

        // Constructor para inicializar los datos del evento
        public Evento(String nombre, String fecha, String tipo) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.tipo = tipo;
        }

        // Mostrar el evento
        public String mostrarEvento() {
            return "Nombre: " + nombre + ", Fecha: " + fecha + ", Tipo: " + tipo;
        }
    }

    // Array para almacenar los eventos (max 100)
    private Evento[] listaEventos = new Evento[100];
    private int contadorEventos = 0;

    // Método para crear un evento
    public void crearEvento() {
        // Cargar la imagen 
        ImageIcon icono = new ImageIcon(getClass().getResource("/images/evento.png"));
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del evento:", "Crear Evento", JOptionPane.PLAIN_MESSAGE, icono, null, "").toString();
        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha del evento (dd/mm/aaaa):", "Crear Evento", JOptionPane.PLAIN_MESSAGE, icono, null, "").toString();
        String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de evento:", "Crear Evento", JOptionPane.PLAIN_MESSAGE, icono, null, "").toString();

        // Crear el evento y agregarlo al array
        Evento nuevoEvento = new Evento(nombre, fecha, tipo);
        listaEventos[contadorEventos] = nuevoEvento;
        contadorEventos++;

        JOptionPane.showMessageDialog(null, "Evento creado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE, icono);
    }

    // Método para listar los eventos
    public void listarEventos() {
        // Cargar la imagen 
        ImageIcon icono = new ImageIcon(getClass().getResource("/images/evento.png"));

        String eventosListado = "Lista de eventos registrados:\n";
        for (int i = 0; i < contadorEventos; i++) {
            eventosListado += listaEventos[i].mostrarEvento() + "\n";
        }
        if (contadorEventos == 0) {
            eventosListado = "No hay eventos registrados.";
        }

        // Mostrar la lista de eventos 
        JOptionPane.showMessageDialog(null, eventosListado, "Listado de Eventos", JOptionPane.INFORMATION_MESSAGE, icono);
    }

    // Método para mostrar el menú
    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            // Opciones del menú
            String[] opciones = { "Crear evento", "Listar eventos", "Salir" };

            // Cargar la imagen 
            ImageIcon icono = new ImageIcon(getClass().getResource("/images/evento.png"));

            // Mostrar el menú 
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "--- Menú Gestión de Eventos ---\nSeleccione una opción:",
                    "Menú de Eventos",
                    JOptionPane.PLAIN_MESSAGE,
                    icono,  // Usamos la imagen aquí
                    opciones,
                    opciones[0] // Opción por defecto seleccionada
            );

            if (seleccion != null) {
                // Evaluamos la opción seleccionada
                if (seleccion.equals("Crear evento")) {
                    crearEvento();
                } else if (seleccion.equals("Listar eventos")) {
                    listarEventos();
                } else if (seleccion.equals("Salir")) {
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción.");
            }
        }
    }

    public static void main(String[] args) {
        GestionDeEventos gestion = new GestionDeEventos();
        gestion.mostrarMenu();  // Llamamos al menú para comenzar
    }
}
     
           
  
