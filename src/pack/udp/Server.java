package pack.udp;

import javafx.scene.control.TextArea;
import pack.Controller;

public class Server extends Thread {
    private TextArea serverMsg;
    public Server(TextArea serverMsg) {
        this.serverMsg=serverMsg;
    }

    private boolean isActive;
    void disable(){
        isActive = false;
    }
    @Override
    public void run() {
        boolean cont;
        isActive = true;
        while (isActive) {
            for (int i = 0; !(cont=isInterrupted()) && i < 100; i++) {
                serverMsg.appendText(i + "\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
