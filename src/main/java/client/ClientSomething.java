package client;

import java.io.*;
import java.net.Socket;

public class ClientSomething {

    private String buffRead;
    private String buffWrite;
    private String strRead;
    private String strWrite;
    private Socket socket;
    private BufferedReader reader;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ClientSomething(String ip, int port) {
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            System.err.println(e);
        }
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Введіть ваше ім'я: ");
            name = reader.readLine();
            new ClientThreadRead();
            new ClientThreadWrite();

        } catch (IOException e) {
            ClientSomething.this.downService();
            e.printStackTrace();
        }
    }


    public String getStrRead() {
        return strRead;
    }


    public String getStrWrite() {
        return strWrite;
    }

    public String getName() {
        return name;
    }


    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

    private class ClientThreadRead extends Thread {

        public ClientThreadRead() throws IOException {
            start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    buffRead = in.readLine();
                    if (buffRead != null) {
                        if (buffRead.equals("close")) {
                            ClientSomething.this.downService();
                            break;
                        } else {
                            strRead = buffRead;
                            System.out.println(strRead);
                            String[] mass = strRead.split(" ");
                            strRead = "";
                            for (int i = 1; i < mass.length; i++) {
                                strRead += mass[i];
                                if (i != mass.length - 1) {
                                    strRead += " ";
                                }
                            }
                        }
                    }

                } catch (IOException e) {
                    ClientSomething.this.downService();
                }
            }
        }
    }

    private class ClientThreadWrite extends Thread {
        public ClientThreadWrite() throws IOException {
            out.println(name);
            start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    buffWrite = reader.readLine();
                    if (buffWrite != null) {
                        if (buffWrite.equals("close")) {
                            out.println(buffWrite);
                            break;
                        } else {
                            strWrite = buffWrite;
                            out.println(strWrite);
                        }
                    }
                } catch (IOException e) {
                    ClientSomething.this.downService();
                }
            }
        }
    }
}
