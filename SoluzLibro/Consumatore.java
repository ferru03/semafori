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
public class Consumatore extends Thread{
    public Semaforo pieno;
    public Semaforo vuoto;
    public int dato; //numero dati da consumare;
    
    public Consumatore(Semaforo pieno, Semaforo vuoto){
        this.pieno = pieno;
        this.vuoto = vuoto;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            pieno.P();
            dato = ProdConsSem.buffer; //consuma un numero;
            System.out.println("Dato letto:" + dato);
            vuoto.V();
            try{
              Thread.sleep(500); //tempo di riposo/attesa del thread;
            }catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
    }
}
