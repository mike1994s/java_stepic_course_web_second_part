package server;

import java.net.Socket;

/**
 * Created by misha on 10.10.17.
 */
public class ThreadHandler implements Runnable {

    private Socket socket;
    public ThreadHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
