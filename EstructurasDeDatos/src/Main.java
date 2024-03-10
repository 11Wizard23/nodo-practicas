public class Main {
    public static void main(String[] args) {
        System.out.println("Contador---------------");
        Contador contador = new Contador();
        contador.incrementar();
        System.out.println(contador.getValor());
        contador.incrementar(5);
        System.out.println(contador.getValor());
        contador.decrementar();
        System.out.println(contador.getValor());
        contador.decrementar(2);
        System.out.println(contador.getValor());
        contador.setValor(50);
        System.out.println(contador.getValor());
        contador.decrementar(100);
        System.out.println(contador.getValor());
        System.out.println("Contador---------------");

        System.out.println();
        System.out.println("CuentaCorriente--------");
        CuentaCorriente cuenta1 = new CuentaCorriente();
        CuentaCorriente cuenta2 = new CuentaCorriente("Pedro casas");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        cuenta1.ingreso(1000.00);
        cuenta1.setTitular("Esteban García");
        cuenta1.ingreso(1000.00);
        System.out.println(cuenta1);
        cuenta1.transferencia(1000.00, cuenta2);
        System.out.println(cuenta1);
        cuenta1.ingreso(2000.00);
        cuenta2.egreso(500.00);
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        cuenta2.transferencia(1000.00, cuenta1);
        System.out.println(cuenta2);
        cuenta2.transferencia(500.00, cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta1);
        CuentaCorriente cuenta3 = new CuentaCorriente(cuenta1);
        System.out.println(cuenta1);
        System.out.println(cuenta3);
        System.out.println("CunetaCorriente--------");

        System.out.println();
        System.out.println("Fecha------------------");
        Fecha fecha = new Fecha();
        System.out.println(fecha);
        Fecha fecha2 = new Fecha(2023, 10, 15);
        System.out.println(fecha2);
        System.out.println("Fecha------------------");

        System.out.println();
        System.out.println("Fracciones-------------");
        Fraccion fraccion = new Fraccion(1,2);
        fraccion.sumar(1, 2);
        System.out.println(fraccion);
        fraccion.restar(2, 3);
        System.out.println(fraccion);
        fraccion.multiplicar(1, 5);
        System.out.println(fraccion);
        fraccion.dividir(1,2);
        System.out.println(fraccion);

        System.out.println("Fracciones-------------");


    }

}