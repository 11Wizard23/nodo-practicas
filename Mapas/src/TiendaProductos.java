import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TiendaProductos {
    private Map<String, Double> productos = new HashMap<>();
    public Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("==== TIENDA DE PRODUCTOS ====");
        System.out.println("1. Introducir producto");
        System.out.println("2. Modificar precio");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Mostrar productos");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                introducirProducto();
                break;
            case 2:
                modificarPrecio();
                break;
            case 3:
                eliminarProducto();
                break;
            case 4:
                mostrarProductos();
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private void introducirProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = this.scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = this.scanner.nextDouble();
        this.scanner.nextLine();
        productos.put(nombre, precio);
        System.out.println("Producto agregado correctamente.");
    }

    private void modificarPrecio() {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = this.scanner.nextLine();
        if (productos.containsKey(nombre)) {
            System.out.print("Ingrese el nuevo precio: ");
            double nuevoPrecio = this.scanner.nextDouble();
            this.scanner.nextLine();
            productos.put(nombre, nuevoPrecio);
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("El producto no existe en la tienda.");
        }
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = this.scanner.nextLine();
        if (productos.containsKey(nombre)) {
            productos.remove(nombre);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("El producto no existe en la tienda.");
        }
    }

    private void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
        } else {
            System.out.println("==== PRODUCTOS ====");
            for (Map.Entry<String, Double> entry : productos.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
        }
    }
}
