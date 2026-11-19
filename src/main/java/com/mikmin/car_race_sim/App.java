package com.mikmin.car_race_sim;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    // git repository: https://github.com/mikmin2/Car_Race_Sim

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Image image1 = new Image("file:src/main/resources/com/mikmin/car_race_sim/CarPictures/car1.png");
        ImageView car1Image = new ImageView(image1);
        Image image2 = new Image("file:src/main/resources/com/mikmin/car_race_sim/CarPictures/car2.png");
        ImageView car2Image = new ImageView(image2);
        Image image3 = new Image("file:src/main/resources/com/mikmin/car_race_sim/CarPictures/car3.png");
        ImageView car3Image = new ImageView(image3);
        Image image4 = new Image("file:src/main/resources/com/mikmin/car_race_sim/CarPictures/car4.png");
        ImageView car4Image = new ImageView(image4);
        Image image5 = new Image("file:src/main/resources/com/mikmin/car_race_sim/CarPictures/car5.png");
        ImageView car5Image = new ImageView(image5);

        List<ImageView> images = List.of(car1Image,car2Image,car3Image,car4Image,car5Image);

        SequentialTransition SQImage = new SequentialTransition();
        SequentialTransition SQLabel = new SequentialTransition();

        Label welcomeLabel = new Label("Welcome to the Car Simulation!\nLets Introduce our Cars~");
        Label car1Label = new Label("Vibecoded #67 (Yellow)");
        Label car2Label = new Label("Grimobile #69 (Purple)");
        Label car3Label = new Label("Lightning Mcqueen #95 (Red)");
        Label car4Label = new Label("Pig Hotwheel #75 (Green)");
        Label car5Label = new Label("Barbie Sports Van #59 (Pink)");

        List<Label> labels = List.of(car1Label,car2Label,car3Label,car4Label,car5Label);

        Pane viewPane = new Pane(welcomeLabel,car1Image,car1Label,car2Image,car2Label,car3Image,car3Label,car4Image,car4Label,car5Image,car5Label);

        welcomeLabel.setLayoutX(250);
        welcomeLabel.setLayoutY(220);


        for (ImageView image : images) {
            image.setVisible(false);
            image.setLayoutX(150);
            image.setLayoutY(100);
        }
        for (Label label : labels) {
            label.setVisible(false);
            label.setLayoutX(220);
            label.setLayoutY(300);
        }

        for (ImageView image : images) {
            PauseTransition step = new PauseTransition(Duration.seconds(3));
            step.setOnFinished(e -> {
                for (ImageView tempImage : images) {
                    tempImage.setVisible(false);
                }
                welcomeLabel.setVisible(false);
                image.setVisible(true);
            } );
            SQImage.getChildren().add(step);
        }

        for (Label label : labels) {
            PauseTransition step = new PauseTransition(Duration.seconds(3));
            step.setOnFinished(e -> {
                for (Label tempLabel : labels) {
                    tempLabel.setVisible(false);
                }
                label.setVisible(true);
            });
            SQLabel.getChildren().add(step);
        }


        SQImage.play();
        SQLabel.play();

        Scene viewScreen = new Scene(viewPane,640,480);



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
        Label winnerLabel = new Label("");

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
            leaderBoard.getChildren().add(car1Label);
        });
        car2.timer.setOnFinished(e -> {
            leaderBoard.getChildren().add(car2Label);
        });
        car3.timer.setOnFinished(e -> {
            leaderBoard.getChildren().add(car3Label);
        });
        car4.timer.setOnFinished(e -> {
            leaderBoard.getChildren().add(car4Label);
        });
        car5.timer.setOnFinished(e -> {;
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
        PauseTransition sceneTimer = new PauseTransition(Duration.seconds(18));

        sceneTimer.play();
        sceneTimer.setOnFinished(e -> {
            stage.setScene(carScene);
            for (Label label : labels) {
                label.setLayoutY(0);
                label.setLayoutX(0);
                label.setVisible(true);
            }
        });


        stage.setScene(viewScreen);
        stage.setTitle("Car Racing Sim");
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