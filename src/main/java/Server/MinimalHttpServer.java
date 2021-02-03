package Server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimalHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        server.createContext("/echo", httpExchange -> {
            Headers headers = httpExchange.getRequestHeaders();
            Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
            StringBuffer response = new StringBuffer();
            for (Map.Entry<String, List<String>> entry : entries)
                response.append(entry.toString() + "\n");
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        });
        server.start();
    }
}
