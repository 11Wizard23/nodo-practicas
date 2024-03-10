import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> valores = new ArrayList<>();
        ArrayList<Integer> mayoresMedia = new ArrayList<>();

        int suma = 0;
        int valor;

        System.out.println("Ingrese valores enteros (-99 para terminar):");

        do {
            valor = scanner.nextInt();
            if (valor != -99) {
                valores.add(valor);
                suma += valor;
            }
        } while (valor != -99);

        int numValores = valores.size();
        double media = (double) suma / numValores;

        System.out.println("\nNúmero de valores leídos: " + numValores);
        System.out.println("Suma de los valores: " + suma);
        System.out.println("Media de los valores: " + media);

        int mayoresQueMedia = 0;
        System.out.println("\nValores leídos:");
        for (int num : valores) {
            System.out.print(num + " ");
            if (num > media) {
                mayoresQueMedia++;
                mayoresMedia.add(num);
            }
        }

        System.out.println("\n\nCantidad de valores mayores que la media: " + mayoresQueMedia + " (" + mayoresMedia + ")");
    }
}