/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appgraphs;

/**
 *
 * @author Rflpz
 */
public class AppGraphs {

    /**
     * @param args the command line arguments
     */
    public void crearMapa()
    {
      
    }
    public static void main(String[] args) {
        Grafo g = new Grafo("abcdefghijkl");
        //A - Colima
        g.agregarRuta('a', 'b', 20);//Colima - Cuahutemoc 
        g.agregarRuta('a', 'e', 4);//Colima - Villa de alavarez
        g.agregarRuta('a', 'd', 50);//Colima - Tecoman
        g.agregarRuta('a', 'c', 40);//Colima - Ixtlahuacan
        //B - Cuahutemoc
        g.agregarRuta('b', 'a', 20);//Cuahutemoc - Colima
        g.agregarRuta('b', 'h', 31);//Cuahutemoc - Comala
        g.agregarRuta('b', 'k', 21);//Cuahutemoc - Alzada
        g.agregarRuta('b', 'l', 7);//Cuahutemoc - Alcaraces
        //C - Ixtlahuacan
        g.agregarRuta('c', 'a', 40);//Ixtlahuacan - Colima
        g.agregarRuta('c', 'd', 31);//Ixtlahuacan - Tecoman 
        //D - Tecoman
        g.agregarRuta('d', 'a', 50);//Tecoman - Colima
        g.agregarRuta('d', 'g', 14);//Tecoman - Armeria
        g.agregarRuta('d', 'j', 69);//Tecoman - Manzanillo
        g.agregarRuta('d', 'f', 43);//Tecoman - Coquimatlan
        //E - Villa De Alvarez
        g.agregarRuta('e', 'a', 4);//Villa de alvarez - Colima
        g.agregarRuta('e', 'f', 12);//Villa de alvarez - Coquimatlan
        g.agregarRuta('e', 'i', 56);//Villa de alvarez - Minatitlan
        g.agregarRuta('e', 'h', 8);//Villa de alvarez - Comala
        //F - Coquimatlan
        g.agregarRuta('f', 'e', 12);//Coquimatlan - Villa de Alvarez
        g.agregarRuta('f', 'a', 13);//Coquimatlan - Colima
        g.agregarRuta('f', 'd', 43);//Coquimatlan - Tecoman
        g.agregarRuta('f', 'g', 56);//Coquimatlan - Armeria
        //G - Armeria
        g.agregarRuta('g', 'f', 56);//Armeria - Coquimatlan
        g.agregarRuta('g', 'd', 14);//Armeria - Tecoman
        g.agregarRuta('g', 'j', 54);//Armeria - Manzanillo
        //H - Comala
        g.agregarRuta('h', 'e', 8);//Comala - Villa de Alvarez
        g.agregarRuta('h', 'b', 31);//Comala - Cuahutemoc
        //I - Minatitlan
        g.agregarRuta('i', 'e', 56);//Minatitlan - Villa de Alvarez
        g.agregarRuta('i', 'j', 54);//Minatitlan - Manzanillo
        //J - Manzanillo
        g.agregarRuta('j', 'i', 54);//Manzanillo - Minatitlan
        g.agregarRuta('j', 'g', 54);//Manzanillo - Armeria
        g.agregarRuta('j', 'd', 69);//Manzanillo - Tecoman  
        //K - Alzada
        g.agregarRuta('k', 'b', 21);//Alzada - Cuahutemoc
        //L - Alcaraces
        g.agregarRuta('l', 'b', 7);//Alcaraces - Cuahutemoc
        
        char inicio = 'k';
        char fin    = 'l';
        String respuesta = g.encontrarRutaMinima(inicio, fin);
        System.out.println(respuesta);
    }
}
