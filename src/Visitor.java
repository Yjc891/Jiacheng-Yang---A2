public class Visitor extends Person {
    private String ticketNumber;
    private boolean hasPremiumPass;
    
    public Visitor() {
        super();
        this.ticketNumber = "TICKET000";
        this.hasPremiumPass = false;
    }
    
    public Visitor(String name, int age, String id, 
                   String ticketNumber, boolean hasPremiumPass) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.hasPremiumPass = hasPremiumPass;
    }
    
    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    
    public boolean hasPremiumPass() { return hasPremiumPass; }
    public void setPremiumPass(boolean hasPremiumPass) { this.hasPremiumPass = hasPremiumPass; }
}