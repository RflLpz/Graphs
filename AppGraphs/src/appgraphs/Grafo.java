/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appgraphs;

import java.util.*;

/**
 *
 * @author Rflpz
 */
public class Grafo {
    //Atributos
    List<Nodo>  revisados = null; //Nodos revisados
    char[]  nodos; //Nodo identifier
    int distanciaRutaMasCorta = Integer.MAX_VALUE; //Distancia de la ruta mas corta
    String  rutaMasCorta;  //Ruta mas corta encontrada
    int[][] grafo; //Matriz de las distancias
    
/*-----------------------------------------------------*/    
    //Constructor
    Grafo(String serieNodos) 
    {
        nodos = serieNodos.toCharArray();
        grafo = new int[nodos.length][nodos.length];
    }
/*-----------------------------------------------------*/
    //Agregar ruta
    public void agregarRuta(char origen, char destino, int distancia) 
    {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);
        grafo[n1][n2]=distancia;
        grafo[n2][n1]=distancia;
    }
/*-----------------------------------------------------*/ 
    //Crear la posicion del nodo
    private int posicionNodo(char nodo) 
    {
        for(int i=0; i < nodos.length; i++) 
        {
            if(nodos[i] == nodo)
                return i;
        }
        return -1;
    }
        
/*------------------------------------------------------------------------*/             
    // Encontrar y buscar la ruta mas pequena (Recursividad)
    public String encontrarRutaMinima(char inicio, char fin) {
        // Empezar a calcular la ruta desde el nodo inicio
        encontrarRutaMinima(inicio);
        // tmp contiene el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        
        if(!revisados.contains(tmp)) 
        {
            String error = "Error, nodo no alcanzable";
            return error;
        }
        tmp = revisados.get(revisados.indexOf(tmp));
        int distancia = tmp.distancia;  
        //Crea una pila para almacenar la ruta de nodo final - origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while(tmp != null)
        {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        //Recorrido de la pila para armar la ruta en orden correcto
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return distancia + ": " + ruta;
    }
    public void encontrarRutaMinima(char inicio)
    {
        Queue<Nodo>   cola = new PriorityQueue<Nodo>(); //Crea cola de prioridad
        Nodo            ni = new Nodo(inicio);          //Nodo inicial
         
        revisados = new LinkedList<Nodo>();//Lista de nodos revisados
        cola.add(ni);                   //Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty())
        {        //Ciclo mientras la cola no esta vacia
            Nodo tmp = cola.poll();     //Pop al primer elemento de la pila
            revisados.add(tmp);            //Push a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j < grafo[p].length; j++) 
            {  // revisa los nodos hijos del nodo tmp
                if(grafo[p][j] == 0) 
                    continue;        // si no hay conexión no lo evalua
                if(estaTerminado(j)) 
                    continue;      // si ya fue agregado a la lista de terminados
                Nodo nod = new Nodo(nodos[j],tmp.distancia+grafo[p][j],tmp);
                // si no está en la cola de prioridad, lo agrega
                if(!cola.contains(nod))
                {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for(Nodo x: cola) 
                {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if((x.id == nod.id) && (x.distancia > nod.distancia))
                    {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }
}
