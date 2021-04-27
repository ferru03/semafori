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
public class Consumatore extends Thread{
    
    public ProdConsSem p;
    public int numero = 0;
    
    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            numero = (int) (Math.random() * 50);
            p.deposita(i);
            try{
                sleep(500);
            }catch(InterruptedException e){
                System.out.println("Eccezione:" + e);  
            }
            }
        }
    }
