package com.temr1.lesson2_3_maven.monkeytype.Controllers;

import com.temr1.lesson2_3_maven.monkeytype.Models.BaseTimerModel;
import com.temr1.lesson2_3_maven.monkeytype.Models.TimerModel;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {
    private final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan sed mauris sit amet congue. Vestibulum pellentesque lorem eu velit porttitor, sed scelerisque neque maximus. Curabitur eu neque lacinia, mollis ligula eu, dictum diam. Proin luctus dui in cursus tristique. Nullam quis eros velit. Vivamus a lacinia arcu. Fusce id eros ex. Maecenas et nisi metus. Suspendisse potenti. Duis quis ipsum in est varius placerat. Fusce ultrices quam leo, non fermentum lorem ultricies in. Aliquam dignissim ligula eget maximus commodo. Morbi sed tristique ante, eget laoreet felis. Nunc porta elementum aliquam. ";
    @FXML
    private TextFlow textFlow;
    @FXML
    private Label timerLabel;
    private Scene scene;
    private int indexOfLetter = 0;
    private boolean isStart;

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void setup(){
        isStart = false;
        for (char letter:str.toCharArray()){
            Text newText = new Text(String.valueOf(letter));
            newText.setFill(Color.LIGHTGRAY);
            textFlow.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED,this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent){
        if (isStart){
            String enteredText = keyEvent.getText();

            if (!enteredText.isEmpty()){
                char currentChar = str.charAt(indexOfLetter);
                char enteredChar = keyEvent.isShiftDown() ? keyEvent.getText().toUpperCase().charAt(0) : keyEvent.getText().charAt(0);

                Color color = currentChar == enteredChar ? Color.GREY : Color.RED;

                ((Text) textFlow.getChildren().get(indexOfLetter)).setText(String.valueOf(enteredChar));
                ((Text) textFlow.getChildren().get(indexOfLetter)).setFill(color);

                indexOfLetter++;
            }
        }
    }

    public void onStartButtonClick(){
        isStart = true;

        TimerModel timerModel = new TimerModel();
        timerModel.setParameters(timerLabel, 30);

        Thread timerThread = new Thread(timerModel);
        timerThread.start();

//        timerModel = new TimerModel();
//        timerModel.setParameters(timerLabel, 30);
//
//        Thread timerThread = new Thread(timerModel);
//        timerThread.start();
    }
}