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
public class Produttore extends Thread{
    
    public Semaforo pieno;
    public Semaforo vuoto;
    
    public Produttore(Semaforo pieno, Semaforo vuoto){
        this.pieno = pieno;
        this.vuoto = vuoto;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){ 
            vuoto.P();
            ProdConsSem.buffer = i; //produce un numero;
            System.out.println("Dato scritto:" + i);
            pieno.V();
            try{
              Thread.sleep(500); //tempo di riposo/attesa del thread;
            }catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
    }
}
