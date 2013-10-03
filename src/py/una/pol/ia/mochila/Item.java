package py.una.pol.ia.mochila;

/**
 * @author Claudia Valenzuela
 * @version 1.0
 */
public class Item {

    private String nombre;
    private int valor;
    private int peso;

    /**
     * Construye un Item con los parametros.
     *
     * @param nombre
     * @param valor
     * @param peso
     */
    Item(String nombre, int valor, int peso) {
        this.nombre = nombre;
        this.valor = valor;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
