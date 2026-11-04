/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mikmin.car_race_sim;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 *
 * @author 2556963
 */
public class CarModel {
    Type carType;
    int number;
    Color color;
    double speed;
    double[] positionXY;
    Shape[] carBody;

    public CarModel(Type carType, int number, Color color, double speed, double[] positionXY) {
        this.carType = carType;
        this.number = number;
        this.color = color;
        this.speed = speed;
        this.positionXY = positionXY;
    }
    
    private Shape[] generateCarBody(Color color, int number, double[] positionXY) {
        Shape[] newCarBody = new Shape[10];
        Polygon body = new Polygon(0.0 + positionXY[0],38.0 + positionXY[1],
                85.0 + positionXY[0],38.0 + positionXY[1],
                85.0 + positionXY[0],30.0 + positionXY[1], 
                81.65 + positionXY[0],21.25 + positionXY[1], 
                64.25 + positionXY[0],14.25 + positionXY[1], 
                56.0 + positionXY[0],0.25 + positionXY[1], 
                24.25 + positionXY[0],0.25 + positionXY[1], 
                17 + positionXY[0],14.25 + positionXY[1], 
                2.5 + positionXY[0],19.5 + positionXY[1], 
                0 + positionXY[0],28 + positionXY[1]);
        Polygon light = new Polygon(-15.5, 35.25,
        -7.25, 42.75
        -9.75, 35.25
        );
        
        // <Polygon fill="DODGERBLUE" layoutX="50.0" layoutY="-2.0" points="-50.0, 40.0, 35.0, 40.0, 35.0, 32.0, 31.75, 23.25, 14.25, 16.25, 6.0, 2.25, -25.75, 2.25, -33.0, 16.25, -47.5, 21.5, -50.0, 30.0" stroke="BLACK" strokeType="INSIDE" />
//      <Polygon fill="#1fff6c" layoutX="91.0" layoutY="-13.0" points="-15.5, 35.25, -7.75, 42.75, -9.75, 35.25" stroke="BLACK" strokeType="INSIDE" />
//      <Polygon fill="#7cc0ff" layoutX="58.0" layoutY="-30.0" points="-35.25, 45.25, 4.25, 45.25, -3.5, 31.75, -29.75, 31.75" stroke="BLACK" strokeType="INSIDE" />
//      <Circle fill="DODGERBLUE" layoutX="20.0" layoutY="38.0" radius="10.0" stroke="BLACK" strokeType="INSIDE" />
//      <Circle fill="DODGERBLUE" layoutX="66.0" layoutY="38.0" radius="10.0" stroke="BLACK" strokeType="INSIDE" />
//      <Rectangle arcHeight="5.0" arcWidth="5.0" fill="WHITE" height="12.0" layoutX="30.0" layoutY="22.0" stroke="BLACK" strokeType="INSIDE" width="25.0" />
//        
        
        return newCarBody;
    }
    
    
    
    
    
    
    public enum Type {
        SLOWSTART, FASTSTART, STEADY, BURST, INCREASING, DECREASING, VARIABLE, STARTANDSTOP;
    }
}
