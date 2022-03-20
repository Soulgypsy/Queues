/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7qa;

import java.util.Scanner;

/**
 *
 * @author rla
 */
public class AppMenu {
    
    public void run(){
        Q1RevStack q1 = new Q1RevStack();
        Q2TrafficSim q2 = new Q2TrafficSim();
        Q3TicketSim q3 = new Q3TicketSim();
        Q4FerrySim q4 = new Q4FerrySim();
        
        Scanner userInput = new Scanner(System.in);
        int iChoice = 0;
        String aName = "";
        boolean allDone = false;

        do { 
            do {
                try
                {
                    iChoice = Integer.parseInt(theMenu(userInput));
                }
                catch(NumberFormatException nfe){
                    System.out.println("Your choice is not in the range 1 to 5!");
                    iChoice = 0;
                }
            }while(iChoice < 1 || iChoice> 5);
            
            switch (iChoice) {
                case 1:
                    System.out.println("Now running Q1 reverse stack uysing a queue");
                    System.out.println("-------------------------------------------");
                    q1.run();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Now running Q2 Traffic Sim");
                    System.out.println("-------------------------------------------");
                    q2.run();
                    System.out.println(); 
                    break;
                case 3:
                    System.out.println("Now running Q3 Ticket Sim");
                    System.out.println("-------------------------------------------");
                    q3.run();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Now running Q4 Ferry Sim");
                    System.out.println("-------------------------------------------");
                    q4.run();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("All done! Bye ...");
                    allDone = true;
                    break;
                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;
            }
        }while(!allDone);      
    }
    private String theMenu(Scanner theInput) {
        String choice = "";
        // Print menu to console  
        System.out.println("Queue's Lab Menu");
        System.out.println(String.format("%s", "_".repeat(10)));
        System.out.println("1: Reverse Stack using one Queue and one Stack");
        System.out.println("2: Two Queues Traffic Sim");
        System.out.println("3: Four Queue Ticket Sim");
        System.out.println("4: Three Queue Ferry Sim");
        System.out.println("5: Exit");
        System.out.println();

        System.out.print("Choose one of the options above: ");
        choice = theInput.nextLine();
        return choice;
    }

}
