package Zoo;

import Zoo.Weather.WeatherApi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ZooBuddy");
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
        WeatherApi.getWeather();
    }
}
