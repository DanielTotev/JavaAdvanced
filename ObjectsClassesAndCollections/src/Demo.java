import java.util.ArrayDeque;
import java.util.Deque;

public class Demo {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add("first person");
        queue.add("second person");
        queue.offer("third person");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        queue.offer("a");
    }
}
