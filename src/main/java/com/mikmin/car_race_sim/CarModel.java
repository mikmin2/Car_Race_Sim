/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mikmin.car_race_sim;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author 2556963
 */
public class CarModel {
    String carType;
    int number;
    Color color;
    double speed;
    double[] positionXY;
    Node[] carBody;
    List<TranslateTransition> tt;
    List<RotateTransition> rt;
    PauseTransition timer;

    public CarModel(double positionX,double positionY, String carType, int number, Color color, double speed) {
        this.carType = carType;
        this.number = number;
        this.color = color;
        this.speed = speed;
        double[] tempPositionXY = {positionX,positionY};
        this.positionXY = tempPositionXY;
        this.carBody = generateCarBody(color, number, tempPositionXY);
        this.tt = new ArrayList<>();
        this.rt = new ArrayList<>();
        this.timer= new PauseTransition();
    }
    
    private Node[] generateCarBody(Color color, int number, double[] positionXY) {
        Node[] newCarBody = new Node[11];
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
        Polygon light = new Polygon(75.5 + positionXY[0], 25.25 + positionXY[1],
                83.75 + positionXY[0], 32.75 + positionXY[1],
                81.25 + positionXY[0], 25.25 + positionXY[1]
        );
        Polygon window = new Polygon(23.75 + positionXY[0], 18.25 + positionXY[1],
                60.25 + positionXY[0], 18.25 + positionXY[1],
                55.5 + positionXY[0], 5.75 + positionXY[1],
                29.25 + positionXY[0], 5.75 + positionXY[1]);
        Circle wheel1 = new Circle(20 + positionXY[0], 38  + positionXY[1], 10);
        Circle wheel2 = new Circle(63 + positionXY[0], 38  + positionXY[1], 10);
        Rectangle numPlate = new Rectangle(30  + positionXY[0],22  + positionXY[1],22,15);
        Line wheelLine1 = new Line(20 + positionXY[0] ,43 + positionXY[1],20 + positionXY[0],33 + positionXY[1]);
        Line wheelLine2 = new Line(15 + positionXY[0],38 + positionXY[1],25 + positionXY[0],38 + positionXY[1]);
        Line wheelLine3 = new Line(63 + positionXY[0],43 + positionXY[1],63 + positionXY[0],33 + positionXY[1]);
        Line wheelLine4 = new Line(58 + positionXY[0],38 + positionXY[1],68 + positionXY[0],38 + positionXY[1]);

        Label numPlateLabel = new Label(String.format("%d",number));
        numPlateLabel.setLayoutX(35 + positionXY[0]);
        numPlateLabel.setLayoutY(22 + positionXY[1]);

        body.setFill(color);
        light.setFill(Color.YELLOW);
        window.setFill(Color.LIGHTBLUE);
        wheel1.setFill(Color.BLACK);
        wheel2.setFill(Color.BLACK);
        wheelLine1.setStrokeWidth(3);
        wheelLine1.setStroke(Color.WHITE);
        wheelLine2.setStrokeWidth(3);
        wheelLine2.setStroke(Color.WHITE);
        wheelLine3.setStrokeWidth(3);
        wheelLine3.setStroke(Color.WHITE);
        wheelLine4.setStrokeWidth(3);
        wheelLine4.setStroke(Color.WHITE);
        numPlate.setArcHeight(5);
        numPlate.setArcWidth(5);
        numPlate.setFill(Color.WHITE);

        newCarBody[0] = body;
        newCarBody[1] = window;
        newCarBody[2] = light;
        newCarBody[3] = numPlate;
        newCarBody[4]= numPlateLabel;
        newCarBody[5] = wheel1;
        newCarBody[6] = wheel2;
        newCarBody[7] = wheelLine1;
        newCarBody[8] = wheelLine2;
        newCarBody[9] = wheelLine3;
        newCarBody[10] = wheelLine4;

        return newCarBody;
    }
    
    
    public void addNodes(Pane pane) {
        for (Node node : carBody) {
            pane.getChildren().add(node);
        }
    }

    public void animateCar() {
        Random random = new Random();
        double speedVariable = speed + (random.nextDouble() * 6 - 4.0);
        tt.clear();
        rt.clear();
        timer.stop();

                for (Node node : carBody) {
                    TranslateTransition TT = new TranslateTransition(Duration.seconds(speedVariable), node);
                    TT.setToX(node.getLayoutX() + 500);
                    if (node instanceof Label) {
                        TT.setToX(node.getLayoutX() + 500 - 56 );
                    }
                    tt.add(TT);
                }
                for (int i = 5; i < 11; i++) {
                    RotateTransition RT = new RotateTransition(Duration.seconds(speedVariable), carBody[i]);
                    RT.setToAngle(1440);
                    rt.add(RT);

                }
                timer.setDuration(Duration.seconds(speedVariable));
    }

    public void playAnimation() {
        for (TranslateTransition TT : tt) {
            TT.play();
        }
        for (RotateTransition RT : rt) {
            RT.play();
        }
        timer.play();

    }
    
    public void pauseAnimation() {
        for (TranslateTransition TT : tt) {
            TT.pause();
        }
        for (RotateTransition RT : rt) {
            RT.pause();
        }
        timer.pause();
    }

    public void setSimSpeed(double simSpeed) {
        for (TranslateTransition TT : tt) {
            TT.setRate(simSpeed);
        }
        for (RotateTransition RT : rt) {
            RT.setRate(simSpeed);
        }
        timer.setRate(simSpeed);
    }

}
