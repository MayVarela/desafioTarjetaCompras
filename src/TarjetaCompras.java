import java.util.ArrayList;
import java.util.List;


public class TarjetaCompras {
    private double limite;
    private double saldo;
    private List<Compra> listaDeCompras;

    public TarjetaCompras(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean lanzarCompra (Compra compra){
        if (this.saldo >= compra.getValor()){
            this.saldo -= compra.getValor();
            this.listaDeCompras.add(compra);
            return true;
        } return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    @Override
    public String toString() {
        return "El cupo es " + limite;
    }
}
