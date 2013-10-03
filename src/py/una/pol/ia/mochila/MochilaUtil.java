/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.ia.mochila;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cvalenzuela
 */
public class MochilaUtil {

    public static List<Item> generarElementos(int numeroElementos) {

        List<Item> elementos = new ArrayList();
        Random random = new Random();

        for (int i = 0; i < numeroElementos; i++) {
            int peso = random.nextInt(100)+1;
            int valor = random.nextInt(1000)+1;
            String nombre = "item" + i + "";
            elementos.add(new Item(nombre, valor, peso));
        }
        return elementos;
    }

    public static void mostrarMochila(Mochila mochila) {
        int pesoMochila = 0;
        int valorMochila = 0;
        System.out.println();
        for (Item e : mochila.getMochila()) {
            ///System.out.println(e.getNombre()+"\tP("+e.getPeso()+")\tV("+e.getValor()+")\tR("+e.getValor()/e.getPeso());
            System.out.printf("%s\tV(%d)\tP(%d)\tR(%d)%n",e.getNombre(),e.getValor(),e.getPeso(),(int)(e.getValor()/e.getPeso()));
            pesoMochila += e.getPeso();
            valorMochila += e.getValor();
        }
        System.out.println("------");
        System.out.printf("Peso  = %,12d %n", pesoMochila);
        System.out.printf("Valor = %,12d %n", valorMochila);
    }
}
