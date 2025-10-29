import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateData {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("abs.bin"))) {
            for (double x = -10; x <= 10; x += 0.5) {
                double y = Math.abs(x);
                out.writeDouble(x);
                out.writeDouble(y);
            }
            System.out.println("Файл abs.bin успешно создан!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
