import java.io.IOException;

public class Bclient {
    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient("BClient");
        nioClient.start();
    }
}
