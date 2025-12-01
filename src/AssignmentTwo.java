public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== PROG2004 Assignment 2 ===");
        System.out.println("Theme Park Visitor Management System");
        System.out.println("Student: JIacheng Yang");
        System.out.println("Project: JIacheng-Yang-A2");
        System.out.println("=".repeat(50));

        // 测试基础类
        System.out.println("\n--- Testing Basic Classes ---");
        Employee emp1 = new Employee("John Operator", 30, "E001",
                                     "EMP123", "Ride Operations");
        System.out.println("Employee created: " + emp1.getName());

        Visitor visitor1 = new Visitor("Alice Guest", 25, "V001",
                                       "T123456", true);
        System.out.println("Visitor created: " + visitor1.getName());

        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", emp1);
        System.out.println("Ride created: " + rollerCoaster.getRideName());

        System.out.println("\n✅ All basic classes are working correctly!");
        
        // Part 2测试
        System.out.println("\n=== Testing Part 2: Abstract Class and Interface ===");
        System.out.println("Testing RideInterface methods:");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.printQueue();
        System.out.println("\n✅ Part 2: Person is abstract, Ride implements RideInterface");
        
        // 创建AssignmentTwo对象
        AssignmentTwo assignment = new AssignmentTwo();
        
        // Part 3演示
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STARTING PART 3 DEMONSTRATION");
        System.out.println("=".repeat(50));
        assignment.partThree();
        
        // Part 4A演示
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("STARTING PART 4A DEMONSTRATION");
        System.out.println("=".repeat(50));
        assignment.partFourA();
        
        // Part 4B演示
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("STARTING PART 4B DEMONSTRATION");
        System.out.println("=".repeat(50));
        assignment.partFourB();
        
        // Part 5演示
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("STARTING PART 5 DEMONSTRATION");
        System.out.println("=".repeat(50));
        assignment.partFive();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ALL DEMONSTRATIONS COMPLETED");
        System.out.println("=".repeat(50));
    }
    
    // Part 3: Waiting Queue Implementation
    public void partThree() {
        System.out.println("\n--- Part 3: Queue Operations ---");
        
        Employee operator = new Employee("Queue Operator", 28, "OP003", 
                                         "QUE001", "Queue Management");
        Ride coaster = new Ride("Dragon Coaster", "Extreme", operator);
        
        // 添加游客到队列
        Visitor[] visitors = {
            new Visitor("Alex", 25, "V1001", "TK001", true),
            new Visitor("Maria", 30, "V1002", "TK002", false),
            new Visitor("David", 22, "V1003", "TK003", true),
            new Visitor("Sarah", 28, "V1004", "TK004", false),
            new Visitor("James", 35, "V1005", "TK005", true)
        };
        
        System.out.println("Adding 5 visitors to queue:");
        for (Visitor v : visitors) {
            coaster.addVisitorToQueue(v);
        }
        
        coaster.printQueue();
        
        System.out.println("\nRemoving 2 visitors:");
        coaster.removeVisitorFromQueue();
        coaster.removeVisitorFromQueue();
        
        coaster.printQueue();
        
        System.out.println("\n✅ Part 3: Queue implementation complete");
    }
    
    // Part 4A: Ride History Implementation
    public void partFourA() {
        System.out.println("\n--- Part 4A: Ride History with LinkedList ---");
        
        Employee operator = new Employee("History Op", 35, "OP004", 
                                         "HIST001", "History Dept");
        Ride waterRide = new Ride("Water Splash", "Water", operator);
        
        Visitor[] visitors = {
            new Visitor("Tom", 45, "V2001", "TH001", true),
            new Visitor("Emma", 33, "V2002", "EW002", false),
            new Visitor("Chris", 42, "V2003", "CE003", true),
            new Visitor("Scarlett", 38, "V2004", "SJ004", true),
            new Visitor("Robert", 56, "V2005", "RD005", false)
        };
        
        System.out.println("Adding visitors to history:");
        for (Visitor v : visitors) {
            waterRide.addVisitorToHistory(v);
        }
        
        System.out.println("\nChecking if Tom is in history:");
        System.out.println("Result: " + (waterRide.checkVisitorFromHistory(visitors[0]) ? "Found" : "Not found"));
        
        System.out.println("\nNumber of visitors in history: " + waterRide.numberOfVisitors());
        
        System.out.println("\nPrinting ride history (using Iterator):");
        waterRide.printRideHistory();
        
        System.out.println("\n✅ Part 4A: LinkedList history implementation complete");
    }
    
    // Part 4B: Sorting Ride History
    public void partFourB() {
        System.out.println("\n--- Part 4B: Sorting Ride History ---");
        
        Employee operator = new Employee("Sort Op", 40, "OP005", 
                                         "SORT001", "Sorting Dept");
        Ride ferrisWheel = new Ride("Ferris Wheel", "Scenic", operator);
        
        // 创建不同年龄和姓名的游客
        Visitor[] visitors = {
            new Visitor("Zack", 20, "V3001", "ZK001", false),
            new Visitor("Alice", 25, "V3002", "AL002", true),
            new Visitor("Charlie", 30, "V3003", "CH003", false),
            new Visitor("Bob", 22, "V3004", "BO004", true),
            new Visitor("David", 28, "V3005", "DA005", false)
        };
        
        System.out.println("Adding visitors to history:");
        for (Visitor v : visitors) {
            ferrisWheel.addVisitorToHistory(v);
        }
        
        System.out.println("\nOriginal ride history:");
        ferrisWheel.printRideHistory();
        
        // 创建Comparator并排序
        System.out.println("\nSorting by name (then age):");
        VisitorComparator nameComparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(nameComparator);
        
        System.out.println("\nSorted ride history:");
        ferrisWheel.printRideHistory();
        
        System.out.println("\n✅ Part 4B: Sorting implementation complete");
    }
    
    // Part 5: Run One Cycle
    public void partFive() {
        System.out.println("\n--- Part 5: Run One Ride Cycle ---");
        
        Employee operator = new Employee("Cycle Op", 32, "OP006", 
                                         "CYC001", "Operations");
        Ride rollerCoaster = new Ride("Roller Coaster", "Thrill", operator, 3); // max 3 riders per cycle
        
        // 创建10个游客
        System.out.println("Creating 10 visitors:");
        Visitor[] visitors = new Visitor[10];
        for (int i = 0; i < 10; i++) {
            visitors[i] = new Visitor("Visitor" + (i+1), 20 + i, "V" + (4000 + i), 
                                      "TICK" + (1000 + i), i % 2 == 0);
            rollerCoaster.addVisitorToQueue(visitors[i]);
        }
        
        System.out.println("\nInitial queue:");
        rollerCoaster.printQueue();
        
        System.out.println("\nRunning first cycle (max 3 riders):");
        rollerCoaster.runOneCycle();
        
        System.out.println("\nQueue after first cycle:");
        rollerCoaster.printQueue();
        
        System.out.println("\nRide history after first cycle:");
        rollerCoaster.printRideHistory();
        
        System.out.println("\nRunning second cycle:");
        rollerCoaster.runOneCycle();
        
        System.out.println("\n✅ Part 5: Ride cycle implementation complete");
    }
    
    // Part 6: Writing to a file
    public void partSix() {
        System.out.println("\n=== Part 6: Writing to File ===");
        System.out.println("To be implemented...");
    }
    
    // Part 7: Reading from a file
    public void partSeven() {
        System.out.println("\n=== Part 7: Reading from File ===");
        System.out.println("To be implemented...");
    }
}