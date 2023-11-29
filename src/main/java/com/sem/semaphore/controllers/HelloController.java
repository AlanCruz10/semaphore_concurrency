package com.sem.semaphore.controllers;

import com.sem.semaphore.models.Monitor;
import com.sem.semaphore.models.Semaphore;
import com.sem.semaphore.threads.ThreadHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Circle red;

    @FXML
    private Circle green;

    @FXML
    private Circle yellow;

    @FXML
    private Button buttonStart;

    @FXML
    void startSimulator(MouseEvent event) {
        Semaphore semaphore = new Semaphore();
        Monitor monitor = new Monitor(semaphore);
        ThreadHandler threadHandler = new ThreadHandler(monitor);
        threadHandler.addObserver(this);
        Thread h1 = new Thread(threadHandler);
        h1.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        switch (Integer.valueOf(String.valueOf(arg))) {
            case 1 -> {
                red.setFill(Color.RED);
                green.setFill(Color.WHITE);
                yellow.setFill(Color.WHITE);
            }
            case 2 -> {
                red.setFill(Color.WHITE);
                green.setFill(Color.WHITE);
                yellow.setFill(Color.YELLOW);
            }
            case 3 -> {
                red.setFill(Color.WHITE);
                green.setFill(Color.GREEN);
                yellow.setFill(Color.WHITE);
            }
        }
    }
}
