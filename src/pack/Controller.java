package pack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;//в импортах не должно быть awt!
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pack.udp.Server;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        server = new Server(serverMsg);
        //server.setDaemon(true);
        server.start();
    }

    public void initHandlers() {
        stage.setOnCloseRequest(event -> {
            //server.stop();
        });
    }

    private Server server;
    @FXML
    private TextField sendAdr;
    @FXML
    private TextArea serverMsg;
    @FXML
    private TextArea clientMsg;

    @FXML
    public void sendHandler() {
        clientMsg.setText("Start Text");
    }

    @FXML
    public void cleanText() {
        clientMsg.setText("");
        server.interrupt();
    }
}
