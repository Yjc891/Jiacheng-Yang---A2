
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private String type;
    private Employee operator;
    private Queue<Visitor> waitingQueue;
    
    // 构造器
    public Ride() {
        this.rideName = "Unknown Ride";
        this.type = "General";
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
    }
    
    public Ride(String rideName, String type, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
    }
    
    // Getter和Setter
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    
    // Part 3: 队列操作方法
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Error: Cannot add null visitor to queue");
            return;
        }
        waitingQueue.add(visitor);
        System.out.println("✅ Visitor " + visitor.getName() + " added to queue");
    }
    
    @Override
    public Visitor removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Error: Queue is empty");
            return null;
        }
        Visitor removed = waitingQueue.poll();
        System.out.println("✅ Visitor " + removed.getName() + " removed from queue");
        return removed;
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("📭 Queue is empty");
            return;
        }
        System.out.println("\n===== Waiting Queue =====");
        int pos = 1;
        for (Visitor v : waitingQueue) {
            System.out.println(pos + ". " + v.getName());
            pos++;
        }
    }
    
    // Part 4-5方法（保持为空）
    @Override public void addVisitorToHistory(Visitor visitor) {
        System.out.println("[Part 4] addVisitorToHistory: To be implemented");
    }
    
    @Override public boolean checkVisitorFromHistory(Visitor visitor) {
        System.out.println("[Part 4] checkVisitorFromHistory: To be implemented");
        return false;
    }
    
    @Override public int numberOfVisitors() {
        System.out.println("[Part 4] numberOfVisitors: To be implemented");
        return 0;
    }
    
    @Override public void printRideHistory() {
        System.out.println("[Part 4] printRideHistory: To be implemented");
    }
    
    @Override public void runOneCycle() {
        System.out.println("[Part 5] runOneCycle: To be implemented");
    }
}