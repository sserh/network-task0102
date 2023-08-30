package ru.raccoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String LOCALHOST = "127.0.0.1";
        int port = 8084;
        try (Socket clientSocket = new Socket(LOCALHOST, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);
            String resp;

            while (true) {
                if (in.ready()) {
                    resp = in.readLine();
                    System.out.println(resp);
                    String outString = scanner.nextLine();
                    out.println(outString);
                }
            }
        }
    }
}
