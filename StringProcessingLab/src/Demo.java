public class Demo {
    public static void main(String[] args) {
        System.out.println(String.format("%1$s, %2$s", "Hello", "World"));
        System.out.println(String.format("%2$s, %1$s", "Hello", "World"));
        System.out.println(String.format("%03d", 1));
    }
}
