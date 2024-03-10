import java.util.Random;
public class CuentaCorriente {
    private Double saldo;
    private Boolean estado;
    private String titular;
    private Integer numeroCuenta;

    public CuentaCorriente(){
        this.saldo = 0.0;
        this.estado = true;
        Random random = new Random();
        this.numeroCuenta = 1000 + random.nextInt((9999 + 1) - 1000);
    }

    public CuentaCorriente(String titular){
        this();
        this.titular = titular;
    }

    public CuentaCorriente(CuentaCorriente cuentaCopia){
        this.setSaldo(cuentaCopia.getSaldo());
        this.setEstado(cuentaCopia.getEstado());
        Random random = new Random();
        this.setNumeroCuenta(1000 + random.nextInt((9999 + 1) - 1000));
        this.setTitular(cuentaCopia.getTitular());
        cuentaCopia.setEstado(false);
    }

    private Boolean verificarTransaccion(){
        if(this.getTitular() == null){
            System.out.println("No se puede realizar la transacción, esta cuenta no tiene titular.");
            return false;
        }else if(!this.getEstado()){
            System.out.println("No se puede realizar la transacción, esta cuenta no está activa.");
            return false;
        }

        return true;
    }

    private Boolean verificarEgreso(Double valor){
        if(this.getSaldo() < valor){
            System.out.println("No se puede realizar la transacción, esta cuenta no tiene saldo suficiente.");
            return false;
        }
        return true;
    }

    public Boolean ingreso(Double valor){
        if(!verificarTransaccion()){
            return false;
        }

        this.saldo += valor;
        return true;
    }

    public void egreso(Double valor){
        if(!verificarTransaccion()){
            return;
        }

        if(!verificarEgreso(valor)){
            return;
        }

        this.saldo -= valor;
    }

    public void reintegro(){

    }

    public void transferencia(Double valor, CuentaCorriente cuentaTransferir){
        if(!verificarTransaccion()){
            return;
        }

        if(!verificarEgreso(valor)){
            return;
        }

        if(!cuentaTransferir.ingreso(valor)){
            return;
        }

        this.saldo -= valor;
    }

    public String toString(){
        return "Cuenta: " + this.numeroCuenta + (this.estado ? " activa" : " inactiva") +  ", a nombre de: " + this.titular + ", con saldo: " + this.saldo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getTitular() {
        return titular;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
