import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        System.out.println(uuid);
    }
}