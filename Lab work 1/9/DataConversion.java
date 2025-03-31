import java.nio.*;

public class DataConversion {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        
        buffer.putInt(123); // Storing an integer
        buffer.flip();
        
        int value = buffer.getInt(); // Retrieving integer
        System.out.println("Converted Value: " + value);
    }
}
