import java.awt.image.DataBuffer;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.*;

public class GenerateData {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(41 * 2 * 8);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();

        for (double x = -10.0; x <= 10; x += 0.5) {
            doubleBuffer.put(x);
            doubleBuffer.put(Math.abs(x));
        }

        doubleBuffer.flip();
        FileChannel fileChannel = FileChannel.open(Path.of("DataByBuffer.bin"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        fileChannel.write(byteBuffer);
    }

}
