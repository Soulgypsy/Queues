/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7qa;

import java.util.Random;

/**
 *
 * @author rla
 */
public class Q4FerrySim {
    ADTQueueE_RA<String> theQueueCars = new ADTQueueE_RA(10);
    ADTQueueE_RA<String> theQueueLorries = new ADTQueueE_RA(10);
    ADTQueueE_RA<String> theQueue = new ADTQueueE_RA(10);
    
   
    public void intialise(){
        theQueue.createQueue();
        theQueueCars.createQueue();
        theQueueLorries.createQueue();
    }
    
    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public void generateData(){
        String[] vehicles = {"Car","Lorry"};
        for(int item = 0; item < 10; item++){
            theQueue.enqueue(vehicles[getRandomInt(0,2)]);
        }
    }
    
    public void run(){
        System.out.println("Generating data for the main Queue.");
        System.out.println("Main Queue");
        System.out.println("----------");
        generateData();
        theQueue.displayQueue();
        
        System.out.println("Processing main Queue.");
        String vehicleType = "";
        while(!theQueue.isEmpty()){
            try{
                vehicleType = theQueue.dequeue();
                if("Car".equals(vehicleType)){
                    theQueueCars.enqueue(vehicleType);
                }
                else if ("Lorry".equals(vehicleType)){
                    theQueueLorries.enqueue(vehicleType);
                }
            }
            catch (NullPointerException npe){
                System.out.println(npe.getMessage());
            }
        }
        System.out.println("Ferry Queue");
        System.out.println("----------");
        theQueue.displayQueue();
        
        System.out.println("Process Ferry Queue");
        System.out.println("-------------------");

        System.out.println("Car Queue");
        System.out.println("---------");
        theQueueCars.displayQueue();
        System.out.println("Lorry Queue");
        System.out.println("-----------");
        theQueueLorries.displayQueue();
        
        System.out.println("Ferry disembarking Queue");
        System.out.println("-------------------------");
        while(!theQueueCars.isEmpty() || !theQueueLorries.isEmpty()){
            int carQSize = theQueueCars.getQueueSize();
            int lorryQSize = theQueueLorries.getQueueSize();
            
            try {
                if(carQSize >= 3){
                    for(int item = 0; item < 3; item++){
                        theQueue.enqueue(theQueueCars.dequeue());
                    }
                }
                else {
                    for(int item = 0; item < carQSize; item++){
                        theQueue.enqueue(theQueueCars.dequeue());
                    }
                }
                }
            catch(NullPointerException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
            try {
                if(lorryQSize > 0){
                    theQueue.enqueue(theQueueLorries.dequeue());
                } 
                }
            catch(NullPointerException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
        }
        theQueue.displayQueue();
    }
    
}
