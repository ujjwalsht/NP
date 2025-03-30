import java.nio.*;

public class BufferOperations {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        
        // Filling buffer
        buffer.put((byte) 10).put((byte) 20);
        System.out.println("Filled Buffer: " + buffer);

        // Draining buffer (reading values)
        buffer.flip(); 
        System.out.println("Drained: " + buffer.get());

        // Duplicating buffer
        ByteBuffer duplicate = buffer.duplicate();
        System.out.println("Duplicated Buffer: " + duplicate);

        // Slicing buffer
        ByteBuffer slice = buffer.slice();
        System.out.println("Sliced Buffer Capacity: " + slice.capacity());

        // Compact buffer
        buffer.compact();
        System.out.println("Compacted Buffer: " + buffer);
    }
}
