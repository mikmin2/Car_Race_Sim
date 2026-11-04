package com.mikmin.car_race_sim;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        double[] positionXY = {0,0};
        Polygon body = new Polygon(0.0 + positionXY[0],42.0 + positionXY[1],
                85.0 + positionXY[0],42.0 + positionXY[1],
                85.0 + positionXY[0],34.0 + positionXY[1], 
                81.65 + positionXY[0],25.25 + positionXY[1], 
                64.25 + positionXY[0],18.25 + positionXY[1], 
                56.0 + positionXY[0],4.25 + positionXY[1], 
                24.25 + positionXY[0],4.25 + positionXY[1], 
                17 + positionXY[0],18.25 + positionXY[1], 
                2.5 + positionXY[0],23.5 + positionXY[1], 
                0 + positionXY[0],32 + positionXY[1]);
        Polygon light = new Polygon(45.5, 35.25,
        42.75, 42.75,
        40.25, 35.25
        );
        light.setFill(Color.YELLOW);
        body.setFill(Color.BLUE);
        Pane pane = new Pane(body, light);
        scene = new Scene(pane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}