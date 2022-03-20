/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7qa;

/**
 *
 * @author rla
 */
public class Q2TrafficSim {
    ADTQueueE_RA<String> theQueueL = new ADTQueueE_RA(10);
    ADTQueueE_RA<String> theQueueR = new ADTQueueE_RA(10);
    
    public void intialise(){
        theQueueL.createQueue();
        theQueueR.createQueue();
    }
    
    public void run(){
        System.out.println("Adding Cars to each Queue.");
        for(int car = 0; car < 10; car++){
            StringBuilder sb = new StringBuilder("Car");
            sb.append(Integer.toString(car));
            theQueueL.enqueue(sb.toString());
            theQueueR.enqueue(sb.toString());
        }
        System.out.println("Cars in Left hand Queue.");
        theQueueL.displayQueue();
        System.out.println("Cars in Right hand Queue.");
        theQueueR.displayQueue();
        
        System.out.println("Starting Traffic Sim");
        System.out.println("--------------------");
        
        int counter = 3;
        boolean queueTurnLeft = true;
        while(!theQueueL.isEmpty() || !theQueueR.isEmpty()){
            if(queueTurnLeft){
                System.out.println("Dequeuing left hand queue.");
                while(counter > 0 && !theQueueL.isEmpty()){
                    System.out.print(theQueueL.dequeue());
                    System.out.print(" ");
                    counter--;                        
                }
                queueTurnLeft = !queueTurnLeft;
            }
            else {
                System.out.println("Dequeuing right hand queue.");
                while(counter > 0 && !theQueueR.isEmpty()){
                    System.out.print(theQueueR.dequeue());
                    System.out.print(" ");
                    counter--;          
                }
                queueTurnLeft = !queueTurnLeft;
            }
            System.out.println();
            counter = 3;
        }
        System.out.println("Left hand Queue: ");
        theQueueL.displayQueue();
        System.out.println("Right hand Queue: ");
        theQueueR.displayQueue();
    }
    
}
