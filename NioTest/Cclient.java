import java.io.IOException;

public class Cclient {
    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient("CClient");
        nioClient.start();
    }
}
