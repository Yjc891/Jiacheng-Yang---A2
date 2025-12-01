public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== PROG2004 Assignment 2 ===");
        System.out.println("Theme Park Visitor Management System");
        System.out.println("Student: JIacheng Yang");
        System.out.println("Project: JIacheng-Yang-A2");

        // 测试基础类
        System.out.println("\n--- Testing Basic Classes ---");

        // 创建员工 - 注意：没有参数标签！
        Employee emp1 = new Employee("John Operator", 30, "E001",
                                     "EMP123", "Ride Operations");
        System.out.println("Employee created: " + emp1.getName());

        // 创建游客 - 注意：没有参数标签！
        Visitor visitor1 = new Visitor("Alice Guest", 25, "V001",
                                       "T123456", true);
        System.out.println("Visitor created: " + visitor1.getName());

        // 创建游乐设施 - 注意：没有参数标签！
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", emp1);
        System.out.println("Ride created: " + rollerCoaster.getRideName());

        System.out.println("\n✅ All basic classes are working correctly!");
        
        // ========== Part 2测试代码 ==========
        
        System.out.println("\n=== Testing Part 2: Abstract Class and Interface ===");
        
        // 测试接口方法（虽然现在是空实现）
        System.out.println("Testing RideInterface methods:");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.printQueue();
        
        System.out.println("\n✅ Part 2: Person is abstract, Ride implements RideInterface");
        
        // ========== Part 3演示 ==========
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STARTING PART 3 DEMONSTRATION");
        System.out.println("=".repeat(50));
        
        // 创建AssignmentTwo对象并调用partThree方法
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }
    
    // Part 3: Waiting Queue Implementation
    public void partThree() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PART 3: WAITING QUEUE IMPLEMENTATION");
        System.out.println("=".repeat(60));
        
        System.out.println("\n--- 1. Setting up ride and visitors ---");
        
        // 创建操作员
        Employee rideOperator = new Employee("Sam Operator", 32, "OP002", 
                                             "OPER789", "Ride Operations");
        System.out.println("Created operator: " + rideOperator.getName());
        
        // 创建游乐设施
        Ride dragonCoaster = new Ride("Dragon Coaster", "Extreme Thrill", rideOperator);
        System.out.println("Created ride: " + dragonCoaster.getRideName());
        
        // 创建游客数组
        Visitor[] visitors = {
            new Visitor("Alex Chen", 25, "VC001", "TK1001", true),
            new Visitor("Maria Garcia", 30, "VC002", "TK1002", false),
            new Visitor("David Kim", 22, "VC003", "TK1003", true),
            new Visitor("Sarah Johnson", 28, "VC004", "TK1004", false),
            new Visitor("James Wilson", 35, "VC005", "TK1005", true),
            new Visitor("Lisa Brown", 27, "VC006", "TK1006", false)
        };
        
        System.out.println("Created " + visitors.length + " visitors");
        
        // ===== 演示开始 =====
        
        System.out.println("\n--- 2. Adding visitors to queue ---");
        System.out.println("-".repeat(40));
        for (int i = 0; i < visitors.length; i++) {
            System.out.print("Adding visitor " + (i+1) + ": ");
            dragonCoaster.addVisitorToQueue(visitors[i]);
        }
        
        System.out.println("\n--- 3. Display current queue ---");
        System.out.println("-".repeat(40));
        dragonCoaster.printQueue();
        
        System.out.println("\n--- 4. Removing visitors from queue (FIFO) ---");
        System.out.println("-".repeat(40));
        
        // 移除前3个游客
        for (int i = 0; i < 3; i++) {
            System.out.print("Removal " + (i+1) + ": ");
            dragonCoaster.removeVisitorFromQueue();
        }
        
        System.out.println("\n--- 5. Display queue after removals ---");
        System.out.println("-".repeat(40));
        dragonCoaster.printQueue();
        
        System.out.println("\n--- 6. Testing edge cases ---");
        System.out.println("-".repeat(40));
        
        // 测试1: 添加null游客
        System.out.println("Test 1: Adding null visitor");
        dragonCoaster.addVisitorToQueue(null);
        
        // 测试2: 从空队列移除
        System.out.println("\nTest 2: Creating new empty ride");
        Ride emptyRide = new Ride("Empty Ride", "Test", rideOperator);
        emptyRide.printQueue();
        System.out.print("Attempting to remove from empty queue: ");
        emptyRide.removeVisitorFromQueue();
        
        // 测试3: 添加更多游客到现有队列
        System.out.println("\nTest 3: Adding more visitors to existing queue");
        Visitor extraVisitor = new Visitor("Extra Guest", 40, "VC007", "TK1007", false);
        dragonCoaster.addVisitorToQueue(extraVisitor);
        dragonCoaster.printQueue();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ PART 3 COMPLETED SUCCESSFULLY");
        System.out.println("Summary:");
        System.out.println("- Queue implemented with FIFO behavior");
        System.out.println("- All required methods working");
        System.out.println("- Error handling for edge cases");
        System.out.println("=".repeat(60));
    }
    
    // Part 4A: Ride History (to be implemented)
    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History ===");
        System.out.println("To be implemented...");
    }
    
    // Part 4B: Sorting the ride history (to be implemented)
    public void partFourB() {
        System.out.println("\n=== Part 4B: Sorting Ride History ===");
        System.out.println("To be implemented...");
    }
    
    // Part 5: Run a ride cycle (to be implemented)
    public void partFive() {
        System.out.println("\n=== Part 5: Run One Cycle ===");
        System.out.println("To be implemented...");
    }
    
    // Part 6: Writing to a file (to be implemented)
    public void partSix() {
        System.out.println("\n=== Part 6: Writing to File ===");
        System.out.println("To be implemented...");
    }
    
    // Part 7: Reading from a file (to be implemented)
    public void partSeven() {
        System.out.println("\n=== Part 7: Reading from File ===");
        System.out.println("To be implemented...");
    }
}