public class Main {

    public static void main(String[] args) {
        int opcion;
        TiendaProductos tienda = new TiendaProductos();
        do {
            tienda.mostrarMenu();
            opcion = tienda.scanner.nextInt();
            tienda.scanner.nextLine(); // Consumir el salto de línea después de leer el número
            tienda.ejecutarOpcion(opcion);
        } while (opcion != 5);
    }

}

