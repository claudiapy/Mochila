package py.una.pol.ia.mochila;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Claudia Valenzuela
 * @version 1.0
 */
public class MochilaVoraz extends Mochila {

    public MochilaVoraz() {
        super();
    }

    public MochilaVoraz(List items, int peso) {
        super(items, peso);
    }
    private int nodosExpandidos = 0;//nodos expandidos

    public int getNodosExpandidos() {
        return this.nodosExpandidos;
    }


    @Override
    public void resolverProblema() {
        // Comparador para ordenar los items del almacen por valor/peso
        Comparator cmp = new Comparator<Item>() {
            @Override
            public int compare(Item x, Item y) {
                return (int) (x.getValor() / x.getPeso() - y.getValor() / y.getPeso());
            }
        };

        int pesoMochila = 0;//peso actual de la mochila
        Collections.sort(items, cmp);  // ordena usando el comparador anterior
        Collections.reverse(items);   // reversa el orden de los elementos
        int posicion = 0;
        while (pesoMochila < pesoMaximo && posicion < items.size()) {
            Item tmp = items.get(posicion); // item candidato

            /*  Se realiza el control de restricciones, si el peso actual de la
             *  mochila sumado al peso del item que se esta probando no supera
             *  el peso maximo de la mochila, entonces 
             *  el item se agrega a la lista de item solucion */
            if (pesoMochila + tmp.getPeso() <= pesoMaximo) {
                mochila.add(tmp);
                pesoMochila += tmp.getPeso();
                nodosExpandidos++;//cuenta los nodos expandidos
            }
            posicion++;
        }
    }
}
