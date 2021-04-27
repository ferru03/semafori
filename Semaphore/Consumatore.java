/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author andre
 */
public class Consumatore extends Thread{ 
      
    public Semaphore vuoto;
    public Semaphore pieno;
    public static int buffer = 0;
    public int j;

    public Consumatore() {
        this.vuoto = new Semaphore(1);
        this.pieno = new Semaphore(0);
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            try{
                pieno.acquire();
                j = buffer;
                System.out.println("Consuma: " + j);
                Thread.sleep(500); //tempo di riposo/attesa del thread
                vuoto.release();
            }catch(InterruptedException e){
                System.out.println("Eccezione" + e);
            }
        }
    }
}
