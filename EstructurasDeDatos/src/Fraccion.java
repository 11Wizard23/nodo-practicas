public class Fraccion {
    private Integer numerador;
    private Integer denominador;

    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public Fraccion(Integer numerador, Integer denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public String toString(){
        return this.numerador + "/" + this.denominador;
    }

    private static Integer calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCD(b, a % b);
    }

    private static Integer[] simplificarFraccion(Integer numerador, Integer denominador) {
        Integer mcd = calcularMCD(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
        return new Integer[]{numerador, denominador};
    }

    public void sumar(Integer numerador, Integer denominador) {
        Integer sumaNumerador = (this.numerador * denominador) + (numerador * this.denominador);
        Integer sumaDenominador = (this.denominador * denominador);
        Integer[] suma = simplificarFraccion(sumaNumerador, sumaDenominador);
        this.setNumerador(suma[0]);
        this.setDenominador(suma[1]);
    }

    public void restar(Integer numerador, Integer denominador) {
        this.sumar(numerador * -1, denominador);
    }

    public void multiplicar(Integer numerador, Integer denominador) {
        Integer multiplicarNumerador = this.numerador * numerador;
        Integer multiplicarDenominador = this.denominador * denominador;
        Integer[] multiplicar = simplificarFraccion(multiplicarNumerador, multiplicarDenominador);
        this.setNumerador(multiplicar[0]);
        this.setDenominador(multiplicar[1]);
    }

    public void dividir(Integer numerador, Integer denominador) {
        this.multiplicar(denominador, numerador);
    }


    public void setNumerador(Integer numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(Integer denominador) {
        this.denominador = denominador;
    }
}
