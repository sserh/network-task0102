package ru.raccoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8084;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("New connection accepted");
                    out.println("Hi, what is your name?");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, are you more than 18?", name));
                    boolean isPens = in.readLine().equalsIgnoreCase("yes");
                    if (isPens) {
                        out.println("Welcome to private club! Are you glad?");
                        in.readLine();
                        out.println("Anyway we don't have nothing interesting things for you. It's just joke :) Buy!");
                    } else {
                        out.println("We are sorry, you won't get our materials :(");
                    }
                }
            }
        }
    }
}