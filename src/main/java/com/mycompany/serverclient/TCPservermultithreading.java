/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverclient;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket ;
import java.net.ServerSocket ;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author bechi
 */
public class TCPservermultithreading {
    private static final int PORT = 11010;
    private static final int MAX_THREADS = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPservermultithreading.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                try (clientSocket) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message received from client: " + message);
                        
                                           Thread.sleep(2000); 

                        out.println("Hello, Client!");
                        
                        if (message.equals("exit")) {
                            break;
                        }
                    }
                    
                    System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
                } catch (InterruptedException ex) {
                    Logger.getLogger(TCPservermultithreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException e) {
            }
        }
    }
}