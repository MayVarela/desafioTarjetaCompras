import com.sun.jdi.DoubleValue;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cual es el limite de la tarjeta? ");
        double limite = scanner.nextDouble();;
        TarjetaCompras tarjeta = new TarjetaCompras(limite);

        int añadirObjeto = 1;
        while (añadirObjeto != 0 ){
            System.out.println("Cupo disponible: " + tarjeta.getSaldo());
            System.out.println("Nombre el objeto que desea comprar: ");
        String descripcion = scanner.next();

        System.out.println("Cual es el valor de: " + "(" + descripcion + ")");
        double valor = Double.valueOf(scanner.nextDouble());

        Compra compra = new Compra(valor, descripcion);
        boolean compraRealizada = tarjeta.lanzarCompra(compra);

        if (compraRealizada){
            System.out.println("Añadido al carrito de compras");
            double total = 0;
            for (Compra comprafor : tarjeta.getListaDeCompras()) {
            System.out.println(comprafor.getDescripcion() + " - " + comprafor.getValor());
            total += comprafor.getValor();
        }
            System.out.println("----------------------------------------------------------------");
            System.out.println("Escriba (1) para añadir otro articulo o (0) para salir.");
            añadirObjeto = scanner.nextInt();
        } else {
            System.out.println("Saldo insuficiente");
            añadirObjeto = 0;
        }
        }

        System.out.println("*********************************************************************");
        System.out.println("RESUMEN DE SU COMPRA");
        double total = 0;
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
            total += compra.getValor();
        }
        System.out.println("Valor total: " + total);
        System.out.println("********************************************************************");
        System.out.println("Saldo de la tarjeta " + tarjeta.getSaldo() );
    }

}
