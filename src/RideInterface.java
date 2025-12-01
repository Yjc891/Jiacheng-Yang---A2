public interface RideInterface {
    // Part 3: 队列操作
    void addVisitorToQueue(Visitor visitor);
    Visitor removeVisitorFromQueue();
    void printQueue();
    
    // Part 4: 历史记录操作
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
    
    // Part 5: 运行游乐设施
    void runOneCycle();
}