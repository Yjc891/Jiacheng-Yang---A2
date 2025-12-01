import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Ride implements RideInterface {
    private String rideName;
    private String type;
    private Employee operator;
    private Queue<Visitor> waitingQueue;
    private LinkedList<Visitor> rideHistory;
    
    // Part 5 新增属性
    private int maxRider;
    private int numOfCycles;
    
    // ===== 构造器 =====
    public Ride() {
        this.rideName = "Unknown Ride";
        this.type = "General";
        this.operator = null;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;  // 默认每周期最多2人
        this.numOfCycles = 0;
    }
    
    public Ride(String rideName, String type, Employee operator) {
        this.rideName = rideName;
        this.type = type;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2;
        this.numOfCycles = 0;
    }
    
    public Ride(String rideName, String type, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.type = type;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }
    
    // ===== Getter和Setter =====
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    
    public int getNumOfCycles() { return numOfCycles; }
    
    // ===== Part 3: 队列操作方法 =====
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Error: Cannot add null visitor to queue");
            return;
        }
        waitingQueue.add(visitor);
        System.out.println("✅ Visitor " + visitor.getName() + " added to queue for " + rideName);
    }
    
    @Override
    public Visitor removeVisitorFromQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Error: Queue is empty for " + rideName);
            return null;
        }
        Visitor removed = waitingQueue.poll();
        System.out.println("✅ Visitor " + removed.getName() + " removed from queue for " + rideName);
        return removed;
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("📭 Queue for " + rideName + " is empty");
            return;
        }
        System.out.println("\n===== Waiting Queue for " + rideName + " =====");
        System.out.println("Total waiting: " + waitingQueue.size());
        System.out.println("-".repeat(40));
        int pos = 1;
        for (Visitor v : waitingQueue) {
            System.out.println(pos + ". " + v.getName() + " (Ticket: " + v.getTicketNumber() + ")");
            pos++;
        }
        System.out.println("=".repeat(40));
    }
    
    // ===== Part 4A: 历史记录操作方法 =====
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Error: Cannot add null visitor to history");
            return;
        }
        if (checkVisitorFromHistory(visitor)) {
            System.out.println("⚠️ " + visitor.getName() + " is already in ride history");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("✅ " + visitor.getName() + " added to ride history of " + rideName);
    }
    
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Error: Cannot check null visitor");
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getId().equals(visitor.getId())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
    
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("📭 No visitors have taken " + rideName + " yet");
            return;
        }
        System.out.println("\n===== Ride History for " + rideName + " =====");
        System.out.println("Total visitors: " + rideHistory.size());
        System.out.println("-".repeat(50));
        
        // 必须使用Iterator
        Iterator<Visitor> iterator = rideHistory.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(count + ". " + visitor.getName() + 
                             " (ID: " + visitor.getId() + 
                             ", Age: " + visitor.getAge() + 
                             ", Ticket: " + visitor.getTicketNumber() + ")");
            count++;
        }
        System.out.println("=".repeat(50));
    }
    
    // ===== Part 4B: 排序方法 =====
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.println("⚠️ No history to sort");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println("✅ Ride history sorted successfully");
    }
    
    // ===== Part 5: 运行周期方法 =====
    @Override
    public void runOneCycle() {
        System.out.println("\n--- Running one cycle for " + rideName + " ---");
        
        // 检查操作员
        if (operator == null) {
            System.out.println("❌ Error: No operator assigned to " + rideName);
            return;
        }
        
        // 检查队列
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Error: No visitors waiting for " + rideName);
            return;
        }
        
        // 计算本次可以搭乘的人数
        int ridersThisCycle = Math.min(maxRider, waitingQueue.size());
        System.out.println("Riders this cycle: " + ridersThisCycle + "/" + maxRider);
        
        // 从队列移除并添加到历史记录
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor rider = removeVisitorFromQueue();
            if (rider != null) {
                addVisitorToHistory(rider);
            }
        }
        
        // 更新周期计数
        numOfCycles++;
        System.out.println("✅ Cycle " + numOfCycles + " completed for " + rideName);
    }
    
    // ===== Part 6: 导出历史记录到文件 =====
    public void exportRideHistory(String filename) {
        // Part 6 实现
        System.out.println("[Part 6] exportRideHistory: To be implemented");
    }
    
    // ===== Part 7: 从文件导入历史记录 =====
    public void importRideHistory(String filename) {
        // Part 7 实现
        System.out.println("[Part 7] importRideHistory: To be implemented");
    }
}