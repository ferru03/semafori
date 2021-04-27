/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author andre
 */
public class Produttore extends Thread{
    
    public Semaphore vuoto;
    public Semaphore pieno;
    public static int buffer = 0;
    
     public Produttore() {
        this.vuoto = new Semaphore(1);
        this.pieno = new Semaphore(0);
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            try{
                pieno.acquire();
                buffer ++;
                System.out.println("Produce: " + buffer);
                Thread.sleep(500); //tempo di riposo/attesa del thread
                vuoto.release();
            }catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
    }
}
