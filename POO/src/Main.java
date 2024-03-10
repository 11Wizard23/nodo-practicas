import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el sexo (H/M): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Introduce el peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Introduce la altura (m): ");
        double altura = scanner.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona3.setNombre("Juan");
        persona3.setEdad(30);
        persona3.setSexo('H');
        persona3.setPeso(75.5);
        persona3.setAltura(1.75);

        evaluarPersona(persona1);
        evaluarPersona(persona2);
        evaluarPersona(persona3);
    }

    private static void evaluarPersona(Persona persona) {
        int resultadoIMC = persona.calcularIMC();
        switch (resultadoIMC) {
            case -1:
                System.out.println(persona + "\nPeso ideal: Debajo de su peso ideal");
                break;
            case 0:
                System.out.println(persona + "\nPeso ideal: Peso ideal");
                break;
            case 1:
                System.out.println(persona + "\nPeso ideal: Sobrepeso");
                break;
        }

        if (persona.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        System.out.println();
    }
}