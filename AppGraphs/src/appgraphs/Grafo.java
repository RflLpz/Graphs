/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appgraphs;

import java.util.List;

/**
 *
 * @author Rflpz
 */
public class Grafo {
    //Atributos
    List<Nodo>  listos=null;
    char[]  nodos; //Nodo identifier
    int distanciaRutaMasCorta = Integer.MAX_VALUE; //Distancia de la ruta mas corta
    String  rutaMasCorta;  //Ruta mas corta encontrada
    int[][] grafo; //Matriz de las distancias
    
/*-----------------------------------------------------*/    
    //Constructor
    Grafo(String serieNodos) {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
/*-----------------------------------------------------*/
    //Agregar ruta
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2]=distancia;
        grafo[n2][n1]=distancia;
    }
/*-----------------------------------------------------*/ 
    //Crear la posicion del nodo
        private int posicionNodo(char nodo) {
        for(int i=0; i < nodos.length; i++) {
            if(nodos[i] == nodo)
                return i;
        }
        return -1;
    }
}
