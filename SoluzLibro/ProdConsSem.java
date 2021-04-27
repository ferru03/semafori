/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semafori;

/**
 *
 * @author andre
 */
public class ProdConsSem {
    
    public static int buffer;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semaforo s1 = new Semaforo(0);
        Semaforo s2 = new Semaforo(1);
        Produttore p1 = new Produttore(s1, s2);
        Consumatore c1 = new Consumatore(s1, s2);
        p1.start();
        c1.start();
    }
}
