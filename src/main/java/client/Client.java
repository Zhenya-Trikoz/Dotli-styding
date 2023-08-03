package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static String IP = "localhost";
    public static int PORT = 8080;

    public static void main(String[] args) {
        new ClientSomething(IP, PORT);
    }
}


