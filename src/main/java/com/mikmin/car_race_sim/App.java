package com.mikmin.car_race_sim;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Scene viewScreen = new Scene();



        CarModel car1 = new CarModel(20,20, "Vibecoded",67,Color.YELLOWGREEN,6);
        CarModel car2 = new CarModel(20,70, "Grimobile" ,69,Color.PURPLE,6);
        CarModel car3 = new CarModel(20,120, "Lightning Mcqueen" ,95,Color.RED,6);
        CarModel car4 = new CarModel(20,170, "Pig Hotwheel",75,Color.GREEN,6);
        CarModel car5 = new CarModel(20,220, "Barbie Sports Van",59,Color.HOTPINK,6);


        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button resetButton = new Button("Reset");
        Slider simSpeedSlider = new Slider(0.1,3.0,1.0);
        VBox leaderBoard = new VBox();
        VBox placements = new VBox(new Label("1st"),new Label("2nd"),new Label("3rd"),new Label("4th"),new Label("5th"));
        Label winnerLabel = new Label();
        Label car1Label = new Label();
        Label car2Label = new Label();
        Label car3Label = new Label();
        Label car4Label = new Label();
        Label car5Label = new Label();

        Pane pane = new Pane(playButton, pauseButton, resetButton,simSpeedSlider,winnerLabel,placements, leaderBoard);
        playButton.setLayoutX(50);
        playButton.setLayoutY(330);
        pauseButton.setLayoutX(100);
        pauseButton.setLayoutY(330);
        resetButton.setLayoutX(150);
        resetButton.setLayoutY(330);
        simSpeedSlider.setLayoutX(50);
        simSpeedSlider.setLayoutY(380);
        simSpeedSlider.setMajorTickUnit(0.5);
        simSpeedSlider.setShowTickMarks(true);
        simSpeedSlider.setShowTickLabels(true);
        leaderBoard.setLayoutX(300);
        leaderBoard.setLayoutY(330);
        placements.setLayoutX(275);
        placements.setLayoutY(330);
        winnerLabel.setLayoutX(275);
        winnerLabel.setLayoutY(310);

        car1.animateCar();
        car2.animateCar();
        car3.animateCar();
        car4.animateCar();
        car5.animateCar();

        car1.addNodes(pane);
        car2.addNodes(pane);
        car3.addNodes(pane);
        car4.addNodes(pane);
        car5.addNodes(pane);
        Scene carScene = new Scene(pane, 640, 480);

        car1.timer.setOnFinished(e -> {
            car1Label.setText("Vibecoded #67 (Yellow)");
            leaderBoard.getChildren().add(car1Label);
        });
        car2.timer.setOnFinished(e -> {
            car2Label.setText("Grimobile #69 (Purple)");
            leaderBoard.getChildren().add(car2Label);
        });
        car3.timer.setOnFinished(e -> {
            car3Label.setText("Lightning Mcqueen #95 (Red)");
            leaderBoard.getChildren().add(car3Label);
        });
        car4.timer.setOnFinished(e -> {
            car4Label.setText("Pig Hotwheel #75 (Green)");
            leaderBoard.getChildren().add(car4Label);
        });
        car5.timer.setOnFinished(e -> {
            car5Label.setText("Barbie Sports Van #59 (Pink)");
            leaderBoard.getChildren().add(car5Label);
        });

        playButton.setOnAction(e -> {
            car1.playAnimation();
            car2.playAnimation();
            car3.playAnimation();
            car4.playAnimation();
            car5.playAnimation();
        });

        pauseButton.setOnAction(e -> {
            car1.pauseAnimation();
            car2.pauseAnimation();
            car3.pauseAnimation();
            car4.pauseAnimation();
            car5.pauseAnimation();
        });

        leaderBoard.getChildren().addListener((ListChangeListener<Node>) change ->{
            if (leaderBoard.getChildren().size() >= 5) {
                Label winner = (Label) leaderBoard.getChildren().get(0);
                winnerLabel.setText(String.format("Congratulations!, %s is the winner!", winner.getText()));
                winnerLabel.setVisible(true);
            }
        });

        resetButton.setOnAction(e -> {
            simSpeedSlider.setValue(1.0);
            leaderBoard.getChildren().clear();
            car1.pauseAnimation();
            car2.pauseAnimation();
            car3.pauseAnimation();
            car4.pauseAnimation();
            car5.pauseAnimation();
            for (Node node : car1.carBody) {
                node.setTranslateX(0);
                node.setRotate(0);
            }
            for (Node node : car2.carBody) {
                node.setTranslateX(0);
                node.setRotate(0);

            }
            for (Node node : car3.carBody) {
                node.setTranslateX(0);
                node.setRotate(0);

            }
            for (Node node : car4.carBody) {
                node.setTranslateX(0);
                node.setRotate(0);

            }
            for (Node node : car5.carBody) {
                node.setTranslateX(0);
                node.setRotate(0);

            }
            car1.animateCar();
            car2.animateCar();
            car3.animateCar();
            car4.animateCar();
            car5.animateCar();
            winnerLabel.setVisible(false);
        });

        simSpeedSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
            car1.setSimSpeed((double)newValue);
            car2.setSimSpeed((double)newValue);
            car3.setSimSpeed((double)newValue);
            car4.setSimSpeed((double)newValue);
            car5.setSimSpeed((double)newValue);
        });


        stage.setScene(carScene);
        stage.setResizable(false);
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