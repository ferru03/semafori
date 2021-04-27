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
public class Semaforo {
    
    public int valore; //indica se il semaforo è verde o rosso;
    
    public Semaforo(int valore){
       this.valore = valore; 
    }
    
    public synchronized void P(){
        while(valore == 0){ //se valore è uguale a zero il semaforo è rosso;
            try{
               wait(); //il thread si sospende;
            }catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
        valore --; //pone il semaforo a rosso;
    }
    
    public synchronized void V(){
        valore ++; //pone il semaforo a verde;
        notify(); //il thread si risveglia dalla coda;
    }
}
