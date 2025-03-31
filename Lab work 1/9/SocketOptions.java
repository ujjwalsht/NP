import java.net.*;
import java.nio.channels.*;

public class SocketOptions {
    public static void main(String[] args) throws Exception {
        SocketChannel sc = SocketChannel.open();
        System.out.println("Supported Socket Options:");
        for (SocketOption<?> option : sc.supportedOptions()) {
            System.out.println(option.name());
        }
        sc.close();
    }
}
