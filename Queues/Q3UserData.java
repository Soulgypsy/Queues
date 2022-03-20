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
public class Q3UserData {
    private String GigID;
    private int NumTickets;
    private String EmailAddr;

    /**
     * Default constructor
     */
    public Q3UserData(){
        this.GigID = "";
        this.NumTickets = 0;
        this.EmailAddr = "";
    }
    
    /**
     * 
     * @param GigID
     * @param NumTickets
     * @param EmailAddr 
     */
    public Q3UserData(String GigID, int NumTickets, String EmailAddr) {
        this.GigID = GigID;
        this.NumTickets = NumTickets;
        this.EmailAddr = EmailAddr;
    }

    /**
     * @return the GigID
     */
    public String getGigID() {
        return GigID;
    }

    /**
     * @param GigID the GigID to set
     */
    public void setGigID(String GigID) {
        this.GigID = GigID;
    }

    /**
     * @return the NumTickets
     */
    public int getNumTickets() {
        return NumTickets;
    }

    /**
     * @param NumTickets the NumTickets to set
     */
    public void setNumTickets(int NumTickets) {
        this.NumTickets = NumTickets;
    }

    /**
     * @return the EmailAddr
     */
    public String getEmailAddr() {
        return EmailAddr;
    }

    /**
     * @param EmailAddr the EmailAddr to set
     */
    public void setEmailAddr(String EmailAddr) {
        this.EmailAddr = EmailAddr;
    }
    
    @Override
    public String toString(){
        String output;
        output = String.format("%s,%d,%s", this.GigID, this.NumTickets, this.EmailAddr);
        return output;
    }
    
}
