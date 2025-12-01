public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("=== PROG2004 Assignment 2 ===");
        System.out.println("Theme Park Visitor Management System");
        System.out.println("Student: JIacheng Yang");
        System.out.println("Project: JIacheng-Yang-A2");

        // 测试基础类
        System.out.println("\n--- Testing Basic Classes ---");

        // 创建员工 - 去掉参数标签
        Employee emp1 = new Employee("John Operator", 30, "E001",
                                     "EMP123", "Ride Operations");
        System.out.println("Employee created: " + emp1.getName());

        // 创建游客 - 去掉参数标签
        Visitor visitor1 = new Visitor("Alice Guest", 25, "V001",
                                       "T123456", true);
        System.out.println("Visitor created: " + visitor1.getName());

        // 创建游乐设施 - 去掉参数标签
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", emp1);
        System.out.println("Ride created: " + rollerCoaster.getRideName());

        System.out.println("\n✅ All basic classes are working correctly!");
    }
    
    // Part 3 到 Part 7 的占位方法
    public void partThree() {
        System.out.println("\n=== Part 3: Waiting Queue ===");
        System.out.println("To be implemented...");
    }
    
    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History ===");
        System.out.println("To be implemented...");
    }
    
    public void partFourB() {
        System.out.println("\n=== Part 4B: Sorting Ride History ===");
        System.out.println("To be implemented...");
    }
    
    public void partFive() {
        System.out.println("\n=== Part 5: Run One Cycle ===");
        System.out.println("To be implemented...");
    }
    
    public void partSix() {
        System.out.println("\n=== Part 6: Writing to File ===");
        System.out.println("To be implemented...");
    }
    
    public void partSeven() {
        System.out.println("\n=== Part 7: Reading from File ===");
        System.out.println("To be implemented...");
    }
}