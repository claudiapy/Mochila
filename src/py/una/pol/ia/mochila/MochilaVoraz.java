/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @Override
    public void resolverProblema() {
        // Comparador para ordenar los elementos del almacen por valor
        Comparator cmp = new Comparator<Item>() {
            public int compare(Item x, Item y) {
                return (int) (x.getValor() / x.getPeso() - y.getValor() / y.getPeso());
            }
        };
        Collections.sort(items, cmp);  // ordena usando el comparador anterior
        Collections.reverse(items);   // reversa el orden de los elementos

        double pesoMochila = 0;
        int posicion = 0;
        while (pesoMochila < pesoMaximo && posicion < items.size()) {
            Item tmp = items.get(posicion);
            if (pesoMochila + tmp.getPeso() <= pesoMaximo) {
                mochila.add(tmp);
                pesoMochila += tmp.getPeso();
            }
            posicion++;
        }
    }
}
