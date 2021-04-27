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
public class ProdConsSem {
    
     public boolean pieno = false;
    public static int valore;
    
    public synchronized int preleva(){
        while(pieno == false){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
        pieno = false;
        notify();
        System.out.println("Consuma:" + valore);
        return valore;
    }
    
    public synchronized void deposita(int val){
        while(pieno == true){
            try{
                wait();
            }
            catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
        pieno = true;
        valore = val;
        notify();
        System.out.println("Produce:" + valore);
    }
}
