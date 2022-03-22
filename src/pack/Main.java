package pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/resources/main.fxml"));
            Pane root = loader.load();
            Controller controller = loader.getController();
            controller.setStage(stage);
            controller.initHandlers();
            Scene scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass()
                    .getResource("/resources/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Udp Chat");
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
            //primaryStage.close();
            //Platform.exit();
            System.exit(1);
        }
    }
}
