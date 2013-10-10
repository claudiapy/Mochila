/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.ia.mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author charlyx
 */
public class MochilaVegas extends Mochila {

    private boolean mark[];
    private int peso;
    private int valor;
    private int nodosExp = 0;
    private double pesoMochila = 0;//peso actual de la mochila

    public int getNodosExp() {
        return nodosExp;
    }

    public double getPesoMochila() {
        return pesoMochila;
    }

    public MochilaVegas() {
        super();
    }

    public MochilaVegas(List items, int peso) {
        super(items, peso);
    }

    @Override
    public void resolverProblema() {



        int posicion = 0;
        int valorAnt = 0;
        while (posicion < items.size()) {
            nodosExp++;
            generarSolRndom(posicion);

            if (valorAnt < valor) {
                valorAnt = valor;
                mochila.clear();
                for (int k = 0; k < mark.length; k++) {
                    if (mark[k]) {
                        Item seleccionado = items.get(k);
                        mochila.add(seleccionado);

                    }

                }
            }
            posicion++;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.printf("Las Vegas - Nodos Expandidos: %d ", nodosExp);
    }

    //genera una solucion randonomica en cada llamado
    public void generarSolRndom(int posicion) {
        int indice = 0;
        peso = 0;
        valor = 0;
        mark = new boolean[items.size()];
        for (int j = 0; j < mark.length; j++) {
            mark[j] = false;
        }
        mark[posicion] = true;
        peso = items.get(posicion).getPeso();
        valor = items.get(posicion).getValor();
        List<Integer> intLista = generarIntLista(posicion);
        Collections.shuffle(intLista);
        while (peso < pesoMaximo && intLista.size() > 0) {
            nodosExp++;
            indice = intLista.remove(intLista.size() - 1);
            peso += items.get(indice).getPeso();
            valor += items.get(indice).getValor();

            if (peso <= pesoMaximo) {
                mark[indice] = true;
            } else {
                peso -= items.get(indice).getPeso();
                valor -= items.get(indice).getValor();
            }
        }


    }

    public List<Integer> generarIntLista(int posicion) {
        List<Integer> intLista = new ArrayList<Integer>(mark.length - 1);
        for (int i = 0; i < mark.length - 1; i++) {
            if (i != posicion) {
                intLista.add(new Integer(i));
            }
        }
        /*
         array de posicion de los elementos a elegir menos la posicion del 
         elemento actual seleccionado
         */
        return intLista;
    }
}
