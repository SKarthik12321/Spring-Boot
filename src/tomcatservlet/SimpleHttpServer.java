package tomcatservlet;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);

        server.createContext("/", new RootHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:9000");
    }

    static class RootHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {

            String response = "Java Web Server Running";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}