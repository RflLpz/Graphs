/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appgraphs;

/**
 *
 * @author Rflpz
 */
public class Nodo implements Comparable<Nodo> {
    char id;
    int  distancia   = Integer.MAX_VALUE;
    Nodo procedencia = null;
    //Constructor
    Nodo(char x, int d, Nodo p) 
    {
        id=x; 
        distancia=d; 
        procedencia=p;
    }
    Nodo(char x) 
    { 
        this(x, 0, null);
    }
    public int compareTo(Nodo tmp) 
    {
        return this.distancia-tmp.distancia;
    }
    public boolean equals(Object o) 
    {
        Nodo tmp = (Nodo) o;
        if(tmp.id==this.id) 
            return true;
        return false;
    }
}
