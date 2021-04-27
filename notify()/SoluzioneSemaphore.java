/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;
/**
 *
 * @author andre
 */
public class SoluzioneSemaphore {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Produttore p1 = new Produttore();
        Consumatore c1 = new Consumatore();
        p1.start();
        c1.start();
    } 
}
