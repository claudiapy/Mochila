package py.una.pol.ia.mochila;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Claudia Valenzuela
 * @version 1.0
 */
public abstract class Mochila{
    
    protected List<Item> items;
    protected List<Item> mochila;
    protected int  pesoMaximo;

    public Mochila() {
        this.mochila = new ArrayList();
        this.items = new ArrayList();
        pesoMaximo = 0;
    }
    
    /**
     *
     * @param items
     * @param peso
     */
    public Mochila(List<Item> items, int peso) {
        this.mochila = new ArrayList();
        this.items = items;
        this.pesoMaximo = peso;
    }

    public abstract void resolverProblema();
    
    public List<Item> getAlmacen() {
        return items;
    }

    public void setAlmacen(List<Item> almacen) {
        this.items = almacen;
    }

    public List<Item> getMochila() {
        return mochila;
    }

    public void setMochila(List<Item> mochila) {
        this.mochila = mochila;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
}
