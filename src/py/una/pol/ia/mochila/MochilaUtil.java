
package py.una.pol.ia.mochila;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Claudia Valenzuela
 * @version 1.0
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
        int pesoMochila = mochila.getPesoMochila();
        int valorMochila = mochila.getValorMochila();
        long nodosExpandidos = mochila.getNodosExpandidos();
        System.out.println();
        for (Item e : mochila.getMochila()) {
            System.out.printf("%s\tV(%d)\tP(%d)\tR(%d)%n",e.getNombre(),
                    e.getValor(),e.getPeso(),(int)(e.getValor()/e.getPeso()));
        }
        System.out.println("------");
        System.out.printf("Peso  = %,12d %n", pesoMochila);
        System.out.printf("Valor = %,12d %n", valorMochila);
        System.out.printf("Nodos Expandidos = %,12d %n", nodosExpandidos);
    }
    
        public static void printListItems(List<Item> list) {
        for (Item i : list) {
            System.out.printf("%s\tV(%d)\tP(%d)\tR(%d)%n", i.getNombre(), 
                    i.getValor(), i.getPeso(), (int) (i.getValor() / i.getPeso()));

        }
    }
}
