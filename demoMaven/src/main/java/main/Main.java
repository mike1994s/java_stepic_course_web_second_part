package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resourceServer.ResourceServerControllerMBean;
import resourceServer.ResourceServerController;
import resources.TestResource;
import servlets.ResourceServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by misha on 06.12.16.
 */
public class Main {
    // Выбираем порт вне пределов 1-1024:
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(PORT)){
            System.out.println("Started: " + s);
          // Блокирует до тех пор, пока не возникнет соединение:
        try (Socket socket = s.accept()){
                System.out.println("Connection accepted: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                // Вывод автоматически выталкивается из буфера PrintWriter'ом
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())), true);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END"))
                        break;
                    System.out.println("Echoing: " + str);
                    out.println(str);
                }
                // Всегда закрываем два сокета...
            }
        }
    }
}
