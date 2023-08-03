package server;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerListSocket extends Thread {
    private String buff;
    private String str;
    private String name;
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ServerListSocket(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        name = in.readLine();
        time = new Date();
        dt1 = new SimpleDateFormat("HH:mm:ss");
        dtime = dt1.format(time);
        start();
    }

    @Override
    public void run() {
        System.out.println(dtime + " " + name);
        for (ServerListSocket serverListSocket : Server.listSockets) {
            serverListSocket.send("Користувач " + name + " приєднався до чату");
        }
        try {
            while (true) {
                try {
                    buff = in.readLine();
                    if (buff != null) {
                        if (buff.equals("close")) {
                            for (ServerListSocket serverListSocket : Server.listSockets) {
                                if (socket != serverListSocket.socket) {
                                    serverListSocket.send(name + " покинув чат");
                                }
                            }
                            this.send("close");
                            this.downService();
                            break;
                        } else {
                            str = buff;
                            System.out.println("Server: " + name + " " + str);
                            for (ServerListSocket serverListSocket : Server.listSockets) {
                                serverListSocket.send(name + ": " + str);
                            }
                        }

                    }
                } catch (NullPointerException ignored) {

                }
            }
        } catch (
                IOException e) {
            this.downService();
        }

    }

    public void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();

                Server.listSockets.remove(this);
            }
        } catch (IOException ignored) {

        }
    }

    public void send(String msg) {
        out.println(msg);
    }

    public String getNameClient() {
        return name;
    }

    @Override
    public String toString() {
        return "ServerListSocket{" +
                "buff='" + buff + '\'' +
                ", str='" + str + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
