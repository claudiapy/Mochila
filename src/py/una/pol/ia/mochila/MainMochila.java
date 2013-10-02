package py.una.pol.ia.mochila;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Claudia Valenzuela
 * @version 1.0
 */
public class MainMochila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mochila mochila = new MochilaVoraz(cargarElementos(), 50);
        mochila.resolverProblema();
        mostrarMochila(mochila);
                
    }

    public static List <Item> cargarElementos() {

        List<Item> elementos = new ArrayList();
        elementos.add(new Item("TV", 300, 15));
        elementos.add(new Item("PS3", 100, 3));
        elementos.add(new Item("Libro Java", 10, 1));
        elementos.add(new Item("DVD Player", 5, 2));
        elementos.add(new Item("Blu-Ray", 50, 1));
        elementos.add(new Item("Balon", 30, 3));
        elementos.add(new Item("iPod", 150, 1));
        elementos.add(new Item("Printer", 20, 4));
        elementos.add(new Item("VideoBeam", 200, 4));
        elementos.add(new Item("LapTop", 20, 3));
        elementos.add(new Item("iPad", 150, 2));
        elementos.add(new Item("PC", 100, 5));
        elementos.add(new Item("BlackBerry", 150, 2));
        return elementos;
    }
    
    
     public static void mostrarMochila(Mochila mochila) {
        int pesoMochila=0;
        int valorMochila=0;
        System.out.println();
        for(Item e: mochila.getMochila()) {
            System.out.println(e.getNombre());
            pesoMochila+=e.getPeso();
            valorMochila+=e.getValor();
        }
        System.out.println("------");
        System.out.printf("Peso  = %,12d %n", pesoMochila);
        System.out.printf("Valor = %,12d %n", valorMochila);
    }
}
