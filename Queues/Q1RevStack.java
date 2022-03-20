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
public class Q1RevStack {
    ADTStackE_RA<String> theStack = new ADTStackE_RA(6);
    ADTQueueE_RA<String> theQueue = new ADTQueueE_RA(6);
    
    public void intialise(){
        theStack.createStack();
        theQueue.createQueue();
    }
    
    public void run(){
        intialise();
        System.out.println("Adding names to the Stack.");
        theStack.push("Bobby");
        theStack.push("Martin");
        theStack.push("Brian");
        theStack.push("Frank");
        theStack.push("Iain");
        theStack.displayStack();
        System.out.println("Popping names from the Stack to the Queue.");
        while (!theStack.isEmpty()){
            theQueue.enqueue(theStack.pop());
        }
        theQueue.displayQueue();
        System.out.println("Dequeing names from the Queue to the Stack.");
        while (!theQueue.isEmpty()){
            theStack.push(theQueue.dequeue());
        }
        theStack.displayStack();
    }
}
