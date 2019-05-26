import java.io.IOException;

public class Aclient {
    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient("AClient");
        nioClient.start();
    }
}
