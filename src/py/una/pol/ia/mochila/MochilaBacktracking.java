/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.ia.mochila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class MochilaBacktracking extends Mochila{
   List<Item> tmpMochila;
   double valorMaximo;

  public MochilaBacktracking(List items, int peso){
        super(items, peso);
        valorMaximo=Double.MIN_VALUE;
        tmpMochila=new ArrayList<Item>();
    }
 public void resolverProblemaBT(int posicion) {
        double  pesoMochila=getPeso(tmpMochila);    // peso de la solucion temporal
        double valorMochila=getValor(tmpMochila);   // valor de la solucion temporal
         
        if( posicion>=items.size() ) {            // si ya se tuvieron en cuenta todos los elementos
            if(valorMochila>valorMaximo) {          // si el valor es mayor que el máximo anterior
                valorMaximo=valorMochila;           // se actualiza el valor mayor
                mochila.clear();
                mochila.addAll(tmpMochila);
            }
            return;
        }
        Item e = items.get(posicion);
        // Si el elemento se puede agregar, se envía a la mochila temporal
        if(pesoMochila + e.getPeso() <= pesoMaximo) {
                tmpMochila.add(e);                  // Se agrega a la mochila temporal
                resolverProblemaBT(posicion+1);     // se revisa para el siguiente elemento
                tmpMochila.remove(e);               // Se retira el elemento
        }
        // Si no se pudo agregar, o ya se agregó y se retiró, se revisa para el siguiente
        resolverProblemaBT(posicion+1);
    }
 
    double getPeso(List<Item> tmp) {
        double respuesta=0;
        for(Item e: tmp) respuesta+=e.getPeso();
        return respuesta;
    }
 
    double getValor(List<Item> tmp) {
        double respuesta=0;
        for(Item e: tmp) respuesta+=e.getValor();
        return respuesta;
    }

    @Override
    public void resolverProblema() {
        this.resolverProblemaBT(0);
        
    }
    
}
