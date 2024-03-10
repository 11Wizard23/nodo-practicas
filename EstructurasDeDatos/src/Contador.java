public class Contador {
    private Integer valor;

    public Contador (){
        this.valor = 0;
    }

    public Contador (Integer valor){
        this.valor = valor;
    }

    public void decrementar(){
        this.valor -= 1;
    }

    public void decrementar(Integer decremento){
        this.valor -= decremento;
    }
    public void incrementar(){
        this.valor += 1;
    }
    public void incrementar(Integer incremento) {
        this.valor += incremento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
