
package py.una.pol.ia.mochila;

/**
 * @author Claudia Valenzuela
 * @version 1.0
 */
public class Item {

    private String nombre;
    private int valor;
    private int peso;

    Item(String n, int v, int p) {
        nombre = n;
        valor = v;
        peso = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
