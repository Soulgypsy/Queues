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
public class Q3TicketSim {
    ADTQueueE_RA<Q3UserData> theQueueGig1 = new ADTQueueE_RA(10);
    ADTQueueE_RA<Q3UserData> theQueueGig2 = new ADTQueueE_RA(10);
    ADTQueueE_RA<Q3UserData> theQueueGig3 = new ADTQueueE_RA(10);
    ADTQueueE_RA<Q3UserData> theQueue = new ADTQueueE_RA(10);
    
    private static final int GIG1LIMIT = 20;
    private static final int GIG2LIMIT = 15;
    private static final int GIG3LIMIT = 25;
    
    private static int gig1RT = 0;
    private static int gig2RT = 0;
    private static int gig3RT = 0;
    
    private static int diff = 0;
    
    private boolean AllDone = false;
    
    public void intialise(){
        theQueue.createQueue();
        theQueueGig1.createQueue();
        theQueueGig2.createQueue();
        theQueueGig3.createQueue();
    }
    
    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public void generateData(){
        String[] gigRefs = {"Gig1","Gig2","Gig3"};
        String[] emails = {"JoeSoap@soap.co.uk", "Jinkys@Velma.com", "Scooby@Doo.net","Echo@Bunnymen.co.uk","Dexter@Lab.com"};
        for(int item = 0; item < 10; item++){
            Q3UserData theData = new Q3UserData(gigRefs[getRandomInt(0,3)], getRandomInt(1,10),emails[getRandomInt(0,5)]);
            theQueue.enqueue(theData);
        }
    }
    
    public void run(){
        System.out.println("Generating data for the main Queue.");
        System.out.println("Main Queue");
        System.out.println("----------");
        generateData();
        theQueue.displayQueue();
        
        System.out.println("Processing main Queue.");
        Q3UserData theData = new Q3UserData();
        while(!theQueue.isEmpty()){
            theData = theQueue.dequeue();
            if(theData.getGigID() == "Gig1"){
                theQueueGig1.enqueue(theData);
            }
            else if (theData.getGigID() == "Gig2"){
                theQueueGig2.enqueue(theData);
            }
            else if (theData.getGigID() == "Gig3"){
                theQueueGig3.enqueue(theData);
            }
        }
        System.out.println("Main Queue");
        System.out.println("----------");
        theQueue.displayQueue();
        System.out.println("Gig1 Queue");
        System.out.println("----------");
        theQueueGig1.displayQueue();
        System.out.println("Gig2 Queue");
        System.out.println("----------");
        theQueueGig2.displayQueue();
        System.out.println("Gig3 Queue");
        System.out.println("----------");
        theQueueGig3.displayQueue();
        
        
        System.out.println("Process Gig1 Ticket Queue");
        System.out.println("-------------------------");
        while(!theQueueGig1.isEmpty() && !AllDone){
            
            try {
                    theData = theQueueGig1.dequeue();
                    diff = GIG1LIMIT - gig1RT;
                    if(theData.getNumTickets() <= diff){
                        gig1RT += theData.getNumTickets();
                        System.out.println(String.format("%s you have successfully bought %d tickets", theData.getEmailAddr(), theData.getNumTickets()));
                    }
                    else
                    {
                        System.out.println(String.format("You require %d tickets but only %d tickets left!", theData.getNumTickets(), diff));
                        AllDone = true;
                    }
                }
            catch(NullPointerException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
        }

        diff = 0;
        AllDone = false;
        System.out.println("Process Gig2 Ticket Queue");
        System.out.println("-------------------------");
        while(!theQueueGig2.isEmpty() && !AllDone){
            
            try {
                    theData = theQueueGig2.dequeue();
                    diff = GIG1LIMIT - gig2RT;
                    if(theData.getNumTickets() <= diff){
                        gig2RT += theData.getNumTickets();
                        System.out.println(String.format("%s you have successfully bought %d tickets", theData.getEmailAddr(), theData.getNumTickets()));
                    }
                    else
                    {
                        System.out.println(String.format("You require %d tickets but only %d tickets left!", theData.getNumTickets(), diff));
                        AllDone = true;
                    }
                }
            catch(NullPointerException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
        }
        
        diff = 0;
        AllDone = false;
        System.out.println("Process Gig3 Ticket Queue");
        System.out.println("-------------------------");
        while(!theQueueGig3.isEmpty() && !AllDone){
            
            try {
                    theData = theQueueGig3.dequeue();
                    diff = GIG1LIMIT - gig1RT;
                    if(theData.getNumTickets() <= diff){
                        gig3RT += theData.getNumTickets();
                        System.out.println(String.format("%s you have successfully bought %d tickets", theData.getEmailAddr(), theData.getNumTickets()));
                    }
                    else
                    {
                        System.out.println(String.format("You require %d tickets but only %d tickets left!", theData.getNumTickets(), diff));
                        AllDone = true;
                    }
                }
            catch(NullPointerException e) 
                { 
                    System.out.println(e.getMessage()); 
                } 
        }
        
    }
    
}
