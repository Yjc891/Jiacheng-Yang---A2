public class Ride {
    private String rideName;
    private String type;
    private Employee operator;
    
    public Ride() {
        this.rideName = "Unknown Ride";
        this.type = "General";
        this.operator = null;
    }
    
    public Ride(String rideName, String type, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.operator = operator;
    }
    
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
}