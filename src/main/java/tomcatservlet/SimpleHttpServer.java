package tomcatservlet;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // UC1
        server.createContext("/", new RootHandler());

        // UC2
        server.createContext("/headers", new HeaderHandler());

        // UC3
        server.createContext("/query", new QueryHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:8080");
    }

    // UC1
    static class RootHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello from Simple Java HTTP Server";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // UC2
    static class HeaderHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {

            StringBuilder response = new StringBuilder();

            exchange.getRequestHeaders().forEach((key,value) ->
                    response.append(key).append(" : ").append(value).append("\n")
            );

            byte[] bytes = response.toString().getBytes();

            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    // UC3
    static class QueryHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {

            String query = exchange.getRequestURI().getQuery();
            String response = "Query received: " + query;

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}