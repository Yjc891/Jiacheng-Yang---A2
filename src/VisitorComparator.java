
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 首先按姓名排序
        int nameCompare = v1.getName().compareTo(v2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        
        // 如果姓名相同，按年龄排序
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}