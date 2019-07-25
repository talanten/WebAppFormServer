package webAppFormSrv;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.stream.Collectors;
import com.sun.net.httpserver.*;

import controller.HTTPRequestHandler;

public class AppSrv {

    public static void main(String[] args) throws IOException {
        //System is started on port 8500 with path webappform
        HttpServer server = HttpServer.create(new InetSocketAddress(8500), 0);
        HttpContext context = server.createContext("/webappform");
        //HTTP handler is registered
        context.setHandler(AppSrv::handleRequest);
        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();
        
        String response = "";
        //Request body is read
        String request = new BufferedReader(
                new InputStreamReader(
                        exchange.getRequestBody()
                )
        ).lines().collect(Collectors.joining("\n"));
        System.out.println("HTTP:" + request);
        //Checked if request is not empty
        if (!request.isEmpty()) {            
            try {
                //Appropriate request handler is called
                response = HTTPRequestHandler.handleRequest(path, request);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        //Response is prepared and flushed
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Credentials", "true");
        exchange.getResponseHeaders().set("Content-Type", "plain/text");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Content-Type");
        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
