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
        server.createContext("/headers", new HeaderHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:9000");
    }

    static class RootHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {

            String response =
                    "<html>" +
                            "<body>" +
                            "<h2>Java Web Server Running</h2>" +
                            "<p>BridgeLabz Servlet Assignment</p>" +
                            "</body>" +
                            "</html>";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HeaderHandler implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {

            StringBuilder response = new StringBuilder();

            for (String key : exchange.getRequestHeaders().keySet()) {
                response.append(key)
                        .append(" : ")
                        .append(exchange.getRequestHeaders().get(key))
                        .append("\n");
            }

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }
}